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
<<<<<<< HEAD
				Parameters("root", "@Csprl2020",  "jdbc:mysql://localhost/helpdesk", "com.mysql.jdbc.Driver");
=======
				Parameters("root", "",  "jdbc:mysql://localhost/helpdesk", "com.mysql.jdbc.Driver");
		boolean ok = true;
//		try {
//			Class.forName(p.getDriverDB());
//		} catch (Exception e) {
//			ok = false;
//		}
		
		if(ok) {
>>>>>>> 02bdb30b670f35eb4a60791e84ae10cc116e810c
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
