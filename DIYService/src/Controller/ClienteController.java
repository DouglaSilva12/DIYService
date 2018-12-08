package Controller;

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
			
			String operacao = req.getParameter("Operacao");
			System.out.println(operacao);
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
				case("Consultar"):
					consultar(req, resp);
					break;
				case("Login"):
					login(req, resp);
					break;
					
			}
		}
		
		public Cliente login(HttpServletRequest req, HttpServletResponse resp) {
			Cliente cliente = new Cliente();
			try {
				cliente.setNomeCliente(req.getParameter("NOME_CLIENTE"));
				cliente.setSenha(req.getParameter("SENHA"));
				cliente = model.login(cliente);
				req.setAttribute("ID_CLIENTE", cliente.getIdCliente());
				req.setAttribute("NOME_CLIENTE", cliente.getNomeCliente());
				req.setAttribute("ENDERECO", cliente.getEndereco() );
				req.setAttribute("TELEFONE", cliente.getTelefone());
				req.getSession().setAttribute("nomeLogin", cliente.getNomeCliente());
				redirecionar(req,resp,"/Pedido.jsp");
				
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Deu error"+ e.getMessage() + e);
			}
			return cliente;
			
		}
		
		
		public Cliente consultar(HttpServletRequest req, HttpServletResponse resp) {
			Cliente cliente = new Cliente();
			try {
				cliente.setNomeCliente(req.getParameter("NOME_CLIENTE"));
				model.consultar(cliente);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return cliente;
		}
		
		
		public void inserir(HttpServletRequest req, HttpServletResponse resp) {
			
			Cliente novoCliente = new Cliente();
			novoCliente.setNomeCliente(req.getParameter("NOME_CLIENTE"));
			novoCliente.setTelefone(req.getParameter("TELEFONE"));
			novoCliente.setSenha(req.getParameter("SENHA"));
			novoCliente.setEndereco(req.getParameter("ENDERECO"));
			
			try {
				model.inserir(novoCliente);
				
				RequestDispatcher requestDispatcher; 
				requestDispatcher = req.getRequestDispatcher("/Login.jsp");
				requestDispatcher.forward(req, resp);
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("erro "+e.getMessage()+e);
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
		
		
		private void redirecionar(	HttpServletRequest pRequest,HttpServletResponse pResponse,	String pJsp)throws ServletException, IOException {
			pRequest.getRequestDispatcher(pJsp).forward(pRequest, pResponse);
		}
	}
