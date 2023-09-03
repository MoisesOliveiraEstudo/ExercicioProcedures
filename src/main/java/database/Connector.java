package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {

	public static Connection connect() throws ClassNotFoundException, SQLException {
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		
		return DriverManager.getConnection("jdbc:jtds:sqlserver://localhost:1433/db_app_procedures");
	}
	
	public static void main(String[] args) {
		try {
			connect();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
