package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexão.Conexao;
import Model.Item;
import Model.TipoItem;

public class ItemDAO {

	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection c;
	private Conexao conexao = null;
	
	//construtor para instanciar conexão
	public ItemDAO() {
		conexao = new Conexao();
	}
	
// metodo para adiconar dados na tabela Item
	public void inserirItem(Item item) throws Exception{
		sql = "INSERT INTO ITEM (ID_TIPO_ITEM_FK, ID_PRODUTO_FK) VALUES (?,?);";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
			
		ps = c.prepareStatement(sql);
		ps.setInt(1, item.getTipoItem().getIdTipoItem());
		ps.setInt(2, item.getProduto().getIdProduto());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para deletar linha da tabela
	public void deletarItem(Item item) throws Exception{
		sql = "DELETE FROM ITEM WHERE ID_ITEM = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, item.getIdItem());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para atualizar linha da tabela
	public void atualizarItem(Item item) throws Exception{
		sql = "UPDATE ITEM SET ID_TIPO_ITEM_FK = ?, ID_PRODUTO_FK = ? WHERE ID_ITEM = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, item.getTipoItem().getIdTipoItem());
		ps.setInt(2, item.getProduto().getIdProduto());
		ps.setInt(3, item.getIdItem());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para consultar dados da tabela
	public List<Item> consultarItenProduto(Item item) throws Exception{
		sql = "SELECT ITEM.ID_ITEM, ITEM.ID_TIPO_ITEM_FK, TIPO_ITEM.NOME_TIPO_ITEM, TIPO_ITEM.VALOR_TIPO_ITEM FROM ITEM"
			+ "JOIN TIPO_ITEM ON ITEM.ID_TIPO_ITEM_FK = TIPO_ITEM.ID_TIPO_ITEM"
			+ "WHERE ITEM.ID_PRODUTO_FK = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		ps = c.prepareStatement(sql);
		ps.setInt(1, item.getProduto().getIdProduto());
		rs = ps.executeQuery(sql);
		
		Item i = null;
		TipoItem t = null;
		List<Item> listaItens = new ArrayList<Item>();
		
        while (rs.next()) {
        	
        	i = new Item();
        	t = new TipoItem();
        	i.setIdItem(rs.getInt("ID_ITEM"));
        	t.setIdTipoItem(rs.getInt("ID_TIPO_ITEM"));
        	t.setNomeTipoItem(rs.getString("NOME_TIPO_ITEM"));
        	t.setValorTipoItem(rs.getDouble("VALOR_TIPO_ITEM"));
        	
        	i.setTipoItem(t);
        	listaItens.add(i);
        }
		conexao.desconectaBanco();
		return listaItens;
	}

	// Método para listar todos os item da tabela
	public List<Item> listarItensPorTipo(Item item) throws Exception {
		sql = "SELECT ITEM.ID_ITEM, ITEM.ID_TIPO_ITEM_FK, TIPO_ITEM.NOME_TIPO_ITEM, TIPO_ITEM.VALOR_TIPO_ITEM FROM ITEM"
			+ "JOIN TIPO_ITEM ON ITEM.ID_TIPO_ITEM_FK = TIPO_ITEM.ID_TIPO_ITEM"
			+ "WHERE TIPO_ITEM.ID_TIPO_ITEM = ?";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, item.getTipoItem().getIdTipoItem() );
		rs = ps.executeQuery(sql);
		
		Item i = null;
		TipoItem t = null;
		List<Item> listaItens = new ArrayList<Item>();
		
        while (rs.next()) {
        	
        	i = new Item();
        	t = new TipoItem();
        	i.setIdItem(rs.getInt("ID_ITEM"));
        	t.setIdTipoItem(rs.getInt("ID_TIPO_ITEM"));
        	t.setNomeTipoItem(rs.getString("NOME_TIPO_ITEM"));
        	t.setValorTipoItem(rs.getDouble("VALOR_TIPO_ITEM"));
        	
        	i.setTipoItem(t);
        	listaItens.add(i);
        }
		conexao.desconectaBanco();
		return listaItens;
	}
}
