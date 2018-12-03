package Service;

import java.util.List;
import DAO.ItemDAO;
import Model.Item;

public class ItemService {

	ItemDAO dao = new ItemDAO();
		
	public void inserir(Item item) throws Exception {
		dao.inserirItem(item);
	}
		
	public List<Item> listarItenDoProduto(Item item) throws Exception {
		 return dao.consultarItenProduto(item);
	}
	
	public List<Item> listarItensPorTipo(Item item) throws Exception {
		return dao.listarItensPorTipo(item);
	}
		
	public void deletar(Item item) throws Exception {
		dao.deletarItem(item);
	}
		
	public void atualizar(Item item) throws Exception {
		dao.atualizarItem(item);
	}
}
