package ModelDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import Model.*;

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
		ps.execute();
		
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
		ps.execute();
		
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
		ps.execute();
		
		conexao.desconectaBanco();
	}
	
	// metodo para consultar dados da tabela
	//incompleto
	public void consultarCliente(Cliente cliente) throws Exception{
		sql = "SELECT ID_CLIENTE, NOME_CLIENTE, TELEFONE FROM CLIENTE WHERE ID_CLIENTE = ?;";
		c = conexao.conectaBanco();
		if(c == null) {
			System.out.println("Erro ao conectar (DAO)");
		} else { 
			System.out.println("Conectado com sucesso");
		}
		
		ps = c.prepareStatement(sql);
		ps.setInt(1, cliente.getIdCliente());
		rs = ps.executeQuery();
				
		conexao.desconectaBanco();
	}
}