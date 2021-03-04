package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;

import business.Parameters;

public class ConnectionManager {

	private static Parameters p;
	private static Connection con;
	
	private ConnectionManager() {
		p = null;
		con = null;
	}
	
	private static Connection connect() {
		p = new 
				Parameters("root", "@Csprl2020",  "jdbc:mysql://localhost/helpdesk", "com.mysql.jdbc.Driver");
			try {
				con = (Connection) DriverManager.getConnection(p.getDbURL()+"?serverTimezone=UTC",
						p.getUsername(),p.getPassword());
			} catch (Exception e) {
				e.printStackTrace(); 
			}
		return con;
	}
	
	public static Connection getConnection() {
		return Optional.ofNullable(con).orElseGet(ConnectionManager::connect);
	}
}
