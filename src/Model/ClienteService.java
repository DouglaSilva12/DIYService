package Model;

import java.util.List;

import DAO.ClienteDAO;

public class ClienteService {

	ClienteDAO dao = new ClienteDAO();
	
	public void inserir(Cliente cliente) throws Exception {
		dao.inserirCliente(cliente);
	}
	
	public List<Cliente> listar() throws Exception {
		return dao.listarTodos();
	}
	
}
