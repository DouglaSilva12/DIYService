package Service;

import java.util.List;

import DAO.ClienteDAO;
import Model.Cliente;

public class ClienteService {

	ClienteDAO dao = new ClienteDAO();
	
	public void inserir(Cliente cliente) throws Exception {
		dao.inserirCliente(cliente);
	}
	
	public List<Cliente> listar() throws Exception {
		return dao.listarTodos();
	}
	
	public Cliente Consultar(Cliente cliente) throws Exception {
		 return dao.consultarCliente(cliente);
	}
	
	public void deletar(Cliente cliente) throws Exception {
		 dao.deletarCliente(cliente);
	}
	
	public void atualizar(Cliente cliente) throws Exception {
		dao.atualizarCliente(cliente);
	}
}
