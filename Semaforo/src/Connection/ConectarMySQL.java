
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectarMySQL {

	private static ConectarMySQL rep = new ConectarMySQL();
	private ConectarMySQL() { }

	public static  synchronized ConectarMySQL getInstance(){
		if (rep == null){
			rep = new ConectarMySQL();
		}
		return rep;
	}

	public static Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/semaforo"+"?user=root&password=");
		}
		catch (SQLException sex) {
			throw new SQLException(sex.getMessage());
		}
		return connection;
	}
	
	public static void devolveconexao(Connection connection) throws SQLException {
		try {
			connection.close();
		}
		catch (Exception ex) {
			throw new SQLException(ex.getMessage());
		}
	}
	
}
