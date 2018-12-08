package Service;

import Model.Item;
import java.util.List;
import DAO.ItemDAO;

public class TipoItemService {

	ItemDAO dao = new ItemDAO();
	
	public void inserir(Item item) throws Exception {
		dao.inserirItem(item);
	}
	
	public void deletar(Item item) throws Exception {
		dao.deletarItem(item);
	}
	
	public void atualizar(Item item) throws Exception {
		dao.atualizarItem(item);
	}
	
	public List<Item> listarItensProduto(Item item) throws Exception {
		return dao.consultarItenProduto(item);
	}
	
	public List<Item> listarPorTipo(Item item) throws Exception {
		return dao.listarItensPorTipo(item);
	}
}
