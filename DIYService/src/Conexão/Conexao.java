package Conex�o;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

		Connection con;
		String url = "jdbc:mysql://localhost:3306/DIYService?useTimezone=true&serverTimezone=UTC";
		String user = "root";
		String senha = "123456";
		
		// metodo para realizar uma nova conex�o
		public static void main(String[] args) throws Exception {
			Conexao c = new Conexao();
			c.conectaBanco();
			c.desconectaBanco();
		}
		
		public Connection conectaBanco() throws Exception{
			if(con == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, senha);
				System.out.println("Conex�o realizada com sucesso!");
			}
			return con;
		}

		// metodo para fechar conex�o.
		public void desconectaBanco() throws Exception{
			if(con != null) {
				con.close();
				con = null;
				System.out.println("Conex�o fechada com sucesso!");
			}
		}
	}
