package Service;

import java.util.List;

import DAO.PedidoDAO;
import Model.Pedido;

public class PedidoService {
	
	PedidoDAO dao = new PedidoDAO();
	
	public void inserir(Pedido pedido) throws Exception {
		dao.inserirPedido(pedido);
	}

	public void deletar(Pedido pedido) throws Exception {
		dao.deletarPedido(pedido);
	}
	
	public void atualizar(Pedido pedido) throws Exception {
		dao.atualizarPedido(pedido);
	}
	
	public Pedido consultar(Pedido pedido) throws Exception {
		 return dao.consultarPedido(pedido);
	}
	
	public List<Pedido> listar() throws Exception {
		return dao.ListarPedidos();
	}
	
}
