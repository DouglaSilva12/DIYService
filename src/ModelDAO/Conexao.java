package ModelDAO;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao{

	Connection con;
	String url = "jdbc:mysql://localhost:3306/DIYService";
	String user = "root";
	String senha = "12345";
	
	// metodo para realizar uma nova conexão
	
	public Connection conectaBanco() throws Exception{
		if(con == null) {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection(url, user, senha);
				System.out.println("Conexão realizada com sucesso");
		}
		return con;
	}

	// metodo para fechar conexão.
	
	public void desconectaBanco() throws Exception{
		if(con != null) {
				con.close();
				System.out.println("Conexão fechada com sucesso");
		}
	}
}
