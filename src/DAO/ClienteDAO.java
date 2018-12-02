package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Conexão.Conexao;
import Model.Cliente;

public class ClienteDAO {
	
	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection c;
	private Conexao conexao = null;

	// construtor para instanciar conexão
	public ClienteDAO() {
		conexao = new Conexao();
	}
	
	// metodo para adiconar dados na tabela cliente
	public void inserirCliente(Cliente cliente) throws Exception{
		sql = "INSERT INTO CLIENTE (NOME_CLIENTE, TELEFONE, ENDERECO, SENHA) VALUES (?,?,?,?);";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setString(1, cliente.getNomeCliente());
		ps.setString(2, cliente.getTelefone());
		ps.setString(3, cliente.getEndereco());
		ps.setString(4, cliente.getSenha());
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
		sql = "UPDATE CLIENTE SET NOME_CLIENTE = ?, TELEFONE = ?, ENDERECO = ?, SENHA = ? WHERE ID_CLIENTE = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setString(1, cliente.getNomeCliente());
		ps.setString(2, cliente.getTelefone());
		ps.setString(3, cliente.getEndereco());
		ps.setString(4, cliente.getSenha());
		ps.setInt(5, cliente.getIdCliente());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para consultar dados da tabela
	public Cliente consultarCliente(Cliente cliente) throws Exception{
		sql = "SELECT ID_CLIENTE, NOME_CLIENTE, TELEFONE, ENDERECO, SENHA FROM CLIENTE WHERE ID_CLIENTE = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		ps = c.prepareStatement(sql);
		ps.setInt(1, cliente.getIdCliente());
		rs = ps.executeQuery(sql);
		
		Cliente c = null;
		
        while (rs.next()) {
        	
        	c = new Cliente();
        	c.setIdCliente(rs.getInt("ID_CLIENTE"));
        	c.setTelefone(rs.getString("TELEFONE"));
        	c.setEndereco(rs.getString("ENDERECO"));
        	c.setSenha(rs.getString("SENHA"));
        	c.setNomeCliente(rs.getString("NOME_CLIENTE"));
        }
		conexao.desconectaBanco();
		return c;
	}

	// Método para listar todos os cliente da tabela
	public List<Cliente> listarTodos() throws Exception {
		sql = "SELECT ID_CLIENTE, NOME_CLIENTE, TELEFONE, ENDERECO, SENHA FROM CLIENTE";
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
        	int id = rs.getInt("ID_CLIENTE");
        	String nome = rs.getString("NOME_CLIENTE");
        	String telefone = rs.getString("TELEFONE");
        	String endereco = rs.getString("ENDERECO");
        	String senha = rs.getString("SENHA");
        	
        	Cliente c = new Cliente();
        	c.setIdCliente(id);
        	c.setTelefone(telefone);
        	c.setNomeCliente(nome);
        	c.setEndereco(endereco);
        	c.setSenha(senha);
        	
        	clientes.add(c);
        }
        conexao.desconectaBanco();
        return clientes; 
	}
}
