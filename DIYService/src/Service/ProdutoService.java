package Service;

import java.util.List;

import DAO.ProdutoDAO;
import Model.Produto;

public class ProdutoService {

	ProdutoDAO dao = new ProdutoDAO();
	
	public void inserir(Produto produto) throws Exception {
		dao.inserirProduto(produto);
	}
	
	public void deletar(Produto produto) throws Exception {
		dao.deletarProduto(produto);
	}
	
	public void atualizar(Produto produto) throws Exception {
		dao.atualizarProduto(produto);
	}
	
	public Produto consultar(Produto produto) throws Exception {
		return dao.consultarProduto(produto);
	}
	
	public List<Produto> listar() throws Exception {
		return dao.listaProdutos();
	}
}
