package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Cliente;
import Model.ClienteService;

//import ModelDAO.Conexao;

public class ClienteController extends HttpServlet {

	ClienteService model = new ClienteService();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doPost(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String operacao = req.getParameter("operacao");

		if(operacao.equals("INSERIR")) {
			inserir(req, resp);
		} else if(operacao.equals("LISTAR")) {
			listar(req, resp);
		}
	}
	
	
	public void inserir(HttpServletRequest req, HttpServletResponse resp) {
		
		Cliente novoCliente = new Cliente();
		novoCliente.setNomeCliente(req.getParameter("nome"));
		novoCliente.setTelefone(req.getParameter("telefone"));
		
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
			System.out.println("===>> " + clientes.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
