package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Cliente;

public class ClienteDAO {
	
	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection c;
	private Conexao conexao = null;

	// construotor para instanciar conexão
	public ClienteDAO() {
		conexao = new Conexao();
	}
	
	// metodo para adiconar dados na tabela cliente
	public void inserirCliente(Cliente cliente) throws Exception{
		sql = "INSERT INTO CLIENTE (nome_Cliente, telefone) VALUES (?,?);";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setString(1, cliente.getNomeCliente());
		ps.setString(2, cliente.getTelefone());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para deletar linha da tabela
	public void deletarCliente(Cliente cliente) throws Exception{
		sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, cliente.getIdCliente());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para atualizar linha da tabela
	public void atualizarCliente(Cliente cliente) throws Exception{
		sql = "UPDATE CLIENTE SET nome_Cliente = ?, telefone = ? WHERE ID_CLIENTE = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setString(1, cliente.getNomeCliente());
		ps.setString(2, cliente.getTelefone());
		ps.setInt(3, cliente.getIdCliente());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para consultar dados da tabela
	//incompleto
	public Cliente consultarCliente(Cliente cliente) throws Exception{
		sql = "SELECT ID_CLIENTE, NOME_CLIENTE, TELEFONE FROM CLIENTE WHERE ID_CLIENTE = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		ps = c.prepareStatement(sql);
		ps.setString(1, cliente.getNomeCliente());
		rs = ps.executeQuery(sql);
		
		Cliente c = null;
		
        while (rs.next()) {
        	int id = rs.getInt("id_Cliente");
        	String nome = rs.getString("nome_Cliente");
        	String telefone = rs.getString("telefone");
        	
        	c = new Cliente();
        	c.setIdCliente(id);
        	c.setTelefone(telefone);
        	c.setNomeCliente(nome);
        }
				
		conexao.desconectaBanco();
		
		return c;
	}

	public List<Cliente> listarTodos() throws Exception {
		sql = "SELECT ID_CLIENTE, NOME_CLIENTE, TELEFONE FROM CLIENTE";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		rs = ps.executeQuery(sql);

		List<Cliente> clientes = new ArrayList<Cliente>();
		
        while (rs.next()) {
        	int id = rs.getInt("id_Cliente");
        	String nome = rs.getString("nome_Cliente");
        	String telefone = rs.getString("telefone");
        	
        	Cliente c = new Cliente();
        	c.setIdCliente(id);
        	c.setTelefone(telefone);
        	c.setNomeCliente(nome);
        	
        	clientes.add(c);
        }
        
        conexao.desconectaBanco();
        
        return clientes;
        
	}
}
