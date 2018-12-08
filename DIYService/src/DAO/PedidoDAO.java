package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Conexão.Conexao;
import Model.Cliente;
import Model.Pedido;

public class PedidoDAO {

		private String sql = null;
		private PreparedStatement ps = null;
		private ResultSet rs = null;
		private Connection c;
		private Conexao conexao = null;
		
	//construtor para instanciar conexão
	public PedidoDAO() {
		conexao = new Conexao();
	}

	// metodo para adiconar dados na tabela Item
	public void inserirPedido(Pedido pedido) throws Exception{
		sql = "INSERT INTO PEDIDO (VALOR_TOTAL, ID_CLIENTE_FK, PAGAMENTO) VALUES (?,?,?);";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
			
		ps = c.prepareStatement(sql);
		ps.setDouble(1, pedido.getValorTotal());
		ps.setInt(2, pedido.getCliente().getIdCliente());
		ps.setString(3, pedido.getPagamento());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	// metodo para deletar linha da tabela
	public void deletarPedido(Pedido pedido) throws Exception{
		sql = "DELETE FROM PEDIDO WHERE ID_PEDIDO = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, pedido.getIdPedido());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	
	// metodo para atualizar linha da tabela
	public void atualizarPedido(Pedido pedido) throws Exception{
		sql = "UPDATE PEDIDO SET VALOR_TOTAL = ?, ID_CLIENTE_FK = ?, PAGAMENTO = ? WHERE ID_PEDIDO = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setDouble(1, pedido.getValorTotal());
		ps.setInt(2, pedido.getCliente().getIdCliente());
		ps.setString(3, pedido.getPagamento());
		ps.setInt(4, pedido.getIdPedido());
		ps.executeUpdate();
		
		conexao.desconectaBanco();
	}
	
	
	// metodo para consultar dados da tabela
	public Pedido consultarPedido(Pedido pedido) throws Exception{
		sql = "SELECT ID_PEDIDO, VALOR_TOTAL, ID_CLIENTE_FK, PAGAMENTO FROM PEDIDO WHERE ID_PEDIDO = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		ps = c.prepareStatement(sql);
		ps.setInt(1, pedido.getIdPedido());
		rs = ps.executeQuery(sql);
		
		Pedido p = null;
		Cliente c = new Cliente();
		
        while (rs.next()) {
        	
        	p = new Pedido();
        	p.setCliente(c);
        	p.setIdPedido(rs.getInt("ID_PEDIDO"));
        	p.setValorTotal(rs.getDouble("VALOR_TOTAL"));
        	p.getCliente().setIdCliente(rs.getInt("ID_PEDIDO"));
        	p.setPagamento(rs.getString("PAGAMENTO"));
        }
		conexao.desconectaBanco();
		return p;
	}

	// Método para listar todos os item da tabela
	public List<Pedido> ListarPedidos () throws Exception {
		sql = "SELECT ID_PEDIDO, VALOR_TOTAL, ID_CLIENTE_FK, PAGAMENTO FROM PEDIDO";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		;
		rs = ps.executeQuery(sql);
		
		List<Pedido> listaPedidos = new ArrayList<Pedido>();
		Pedido p = null;
		Cliente c = null;
		
        while (rs.next()) {
        	
        	p = new Pedido();
        	
        	c = new Cliente();
        	p.setCliente(c);
        	p.setIdPedido(rs.getInt("ID_PEDIDO"));
        	p.setValorTotal(rs.getDouble("VALOR_TOTAL"));
        	p.getCliente().setIdCliente(rs.getInt("ID_PEDIDO"));
        	p.setPagamento(rs.getString("PAGAMENTO"));
        	
        	listaPedidos.add(p);
        }
		conexao.desconectaBanco();
		return listaPedidos;
	}
}

