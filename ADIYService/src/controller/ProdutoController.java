package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Produto;
import Service.ProdutoService;


public class ProdutoController {
ProdutoService model = new ProdutoService();
	
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
		
		Produto novoProduto = new Produto();
		novoProduto.setNomeProduto(req.getParameter("nome"));
		novoProduto.setValor(Double.parseDouble(req.getParameter("valor")));
		
		try {
			model.inserir(novoProduto);
			
			RequestDispatcher requestDispatcher; 
			requestDispatcher = req.getRequestDispatcher("/produto/cadastrar.jsp");
			requestDispatcher.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void listar(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Produto> produtos = model.listar();
			System.out.println("===>> " + produtos.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}