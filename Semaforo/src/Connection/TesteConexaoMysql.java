package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class TesteConexaoMysql{
	public Connection conexaoMysql(){
		String url = "jdbc:mysql://localhost:3306/banco";
		String login = "root";
		String senha = "";
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexao = DriverManager.getConnection(url, login, senha);
			return conexao;
		}catch (Exception ex){
			return null;
		}
	}
}
