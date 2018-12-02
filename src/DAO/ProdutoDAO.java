package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexão.Conexao;
import Model.Produto;
import Model.TipoItem;

public class ProdutoDAO {

	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection c;
	private Conexao conexao = null;
		
	//construtor para instanciar conexão
	public ProdutoDAO() {
		conexao = new Conexao();
	}
	// metodo para adiconar dados na tabela Item
	public void inserirProduto(Produto produto) throws Exception{
		sql = "INSERT INTO PRODUTO (NOME_PRODUTO, VALOR_PRODUTO) VALUES (?,?);";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setString(1, produto.getNomeProduto());
		ps.setDouble(2, produto.getValor());
		ps.executeUpdate();
	
		conexao.desconectaBanco();
	}
	
	// metodo para deletar linha da tabela
	public void deletarProduto(Produto produto) throws Exception{
		sql = "DELETE FROM Produto WHERE ID_PRODUTO = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getIdProduto());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para atualizar linha da tabela
	public void atualizarProduto(Produto produto) throws Exception{
		sql = "UPDATE PRODUTO SET NOME_PRODUTO = ?, VALOR_PRODUTO = ? WHERE ID_PRODUTO = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setString(1, produto.getNomeProduto());
		ps.setDouble(2, produto.getValor());
		ps.setInt(3, produto.getIdProduto());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para consultar dados da tabela
	public Produto consultarProduto(Produto produto) throws Exception{
		sql = "SELECT NOME_PRODUTO, VALOR_PRODUTO FROM PRODUTO WHERE ID_PRODUTO = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		ps = c.prepareStatement(sql);
		ps.setInt(1, produto.getIdProduto());
		rs = ps.executeQuery(sql);
		
		Produto c = null;
		
        while (rs.next()) {
        	
        	c = new Produto();
        	c.setIdProduto(rs.getInt("ID_PRODUTO"));
        	c.setNomeProduto(rs.getString("NOME_PRODUTO"));
        	c.setValor(rs.getDouble("VALOR_PRODUTO"));
        }
		conexao.desconectaBanco();
		return c;
	}

	// Método para listar todos os tipoItem da tabela
	public List<Produto> listaProdutos() throws Exception {
		sql = "SELECT ID_PRODUTO, NOME_PRODUTO, VALOR_PRODUTO FROM PRODUTO";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		rs = ps.executeQuery(sql);

		List<Produto> listaProdutos = new ArrayList<Produto>();
		Produto p = null;
        while (rs.next()) {
        	p = new Produto();
        	p.setIdProduto(rs.getInt("ID_PRODUTO"));
        	p.setNomeProduto(rs.getString("NOME_PRODUTO"));
        	p.setValor(rs.getDouble("VALOR_PRODUTO"));
        	listaProdutos.add(p);
        	
        }
        conexao.desconectaBanco();
        return listaProdutos;
	}
}