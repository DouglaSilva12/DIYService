package Controller;

import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Cliente;
import Model.Pedido;
import Service.ClienteService;
import Service.PedidoService;

public class PedidoController {
	PedidoService model = new PedidoService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, Exception {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, Exception {

		String operacao = req.getParameter("operacao");

		if(operacao.equals("INSERIR")) {
			inserir(req, resp);
		} else if(operacao.equals("LISTAR")) {
			listar(req, resp);
		}
	}
	
	
	public void inserir(HttpServletRequest req, HttpServletResponse resp) throws NumberFormatException, Exception {
		ClienteService cliente = new ClienteService();
		Cliente c = new Cliente(Integer.parseInt(req.getParameter("ID_CLIENTE")));
		Pedido novoPedido = new Pedido();
		
		
		novoPedido.setValorTotal(Double.parseDouble(req.getParameter("VALOR_TOTAL")));
		novoPedido.setCliente(cliente.consultar(c));
		novoPedido.setPagamento(req.getParameter("PAGAMENTO"));
		
		try {
			model.inserir(novoPedido);
			
			RequestDispatcher requestDispatcher; 
			requestDispatcher = req.getRequestDispatcher("/produto/pedido.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Pedido> produtos = model.listar();
			System.out.println("===>> " + produtos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	


}