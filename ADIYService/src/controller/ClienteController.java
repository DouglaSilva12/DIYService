package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Cliente;
import Service.ClienteService;

public class ClienteController extends HttpServlet {

	ClienteService model = new ClienteService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String operacao = req.getParameter("operacao");

		switch(operacao) {
			
			case("Inserir"):
				inserir(req, resp);
				break;
			case("Listar"):
				listar(req, resp);
				break;
			case("Atualizar"):
				atualizar(req, resp);
				break;
			case("Deletar"):
				deletar(req, resp);
				break;
		}
	}
	
	
	public void inserir(HttpServletRequest req, HttpServletResponse resp) {
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNomeCliente(req.getParameter("Nome"));
		novoCliente.setTelefone(req.getParameter("Telefone"));
		novoCliente.setSenha(req.getParameter("Senha"));
		
		try {
			model.inserir(novoCliente);
			
			RequestDispatcher requestDispatcher; 
			requestDispatcher = req.getRequestDispatcher("/cliente/cadastrar.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Cliente> clientes = model.listar();
			System.out.println("==>> " + clientes.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletar(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(Integer.parseInt(req.getParameter("IdCliente")));
			
			model.deletar(cliente);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(HttpServletRequest req, HttpServletResponse resp) {
		try {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(Integer.parseInt(req.getParameter("Id")));
			cliente.setNomeCliente(req.getParameter("Nome"));
			cliente.setTelefone(req.getParameter("Telefone"));
			cliente.setSenha(req.getParameter("Senha"));
			
			model.atualizar(cliente);
			
		} catch (Exception e){
			e.printStackTrace();
		}
	}
}
		

