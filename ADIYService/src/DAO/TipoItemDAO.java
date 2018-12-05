package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexão.Conexao;
import Model.TipoItem;

public class TipoItemDAO {

	private String sql = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection c;
	private Conexao conexao = null;
		
	//construtor para instanciar conexão
	public TipoItemDAO() {
		conexao = new Conexao();
	}
	// metodo para adiconar dados na tabela Item
	public void inserirTipoItem(TipoItem tipoItem) throws Exception{
		sql = "INSERT INTO TIPO_ITEM (VALOR_TIPO_ITEM, NOME_TIPO_ITEM) VALUES (?,?);";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setDouble(1, tipoItem.getValorTipoItem());
		ps.setString(2, tipoItem.getNomeTipoItem());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para deletar linha da tabela
	public void deletarTipoItem(TipoItem tipoItem) throws Exception{
		sql = "DELETE FROM TIPO_ITEM WHERE ID_TIPO_ITEM = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, tipoItem.getIdTipoItem());
		ps.executeUpdate();
		conexao.desconectaBanco();
	}
	
	// metodo para atualizar linha da tabela
	public void atualizarTipoItem(TipoItem tipoItem) throws Exception{
		sql = "UPDATE TIPO_ITEM SET NOME_tIPO_iTEM = ?, VALOR_TIPO_ITEM = ? WHERE ID_TIPO_ITEM = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setString(1, tipoItem.getNomeTipoItem());
		ps.setDouble(2, tipoItem.getValorTipoItem());
		ps.setInt(3, tipoItem.getIdTipoItem());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para consultar dados da tabela
	public TipoItem consultarTipoItem(TipoItem tipoItem) throws Exception{
		sql = "SELECT NOME_TIPO_ITEM, VALOR_TIPO_ITEM FROM TIPO_ITEM WHERE ID_TIPO_ITEM = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		ps = c.prepareStatement(sql);
		ps.setInt(1, tipoItem.getIdTipoItem());
		rs = ps.executeQuery(sql);
		
		TipoItem c = null;
		
        while (rs.next()) {
        	
        	c = new TipoItem();
        	c.setIdTipoItem(rs.getInt("ID_TIPO_ITEM"));
        	c.setNomeTipoItem(rs.getString("NOME_TIPO_ITEM"));
        	c.setValorTipoItem(rs.getDouble("VALOR_TIPO_ITEM"));
        }
		conexao.desconectaBanco();
		return c;
	}

	// Método para listar todos os tipoItem da tabela
	public List<TipoItem> listarTodos() throws Exception {
		sql = "SELECT ID_TIPO_ITEM, NOME_TIPO_ITEM, VALOR_TIPO_ITEM FROM TIPO_ITEM";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		rs = ps.executeQuery(sql);

		List<TipoItem> tipoItens = new ArrayList<TipoItem>();
		
        while (rs.next()) {
        	
        	TipoItem c = new TipoItem();
        	c.setIdTipoItem(rs.getInt("ID_TIPO_ITEM"));
        	c.setNomeTipoItem(rs.getString("NOME_TIPO_ITEM"));
        	c.setValorTipoItem(rs.getDouble("VALOR_TIPO_ITEM"));
        	
        	tipoItens.add(c);
        }
        conexao.desconectaBanco();
        return tipoItens;
	}
}