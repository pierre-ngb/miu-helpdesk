package dataaccess;

import java.sql.Connection;
import java.sql.DriverManager;


import business.Parameters;

public class ConnectionManager {

	private static Parameters p;
	private static Connection con;
	
	private ConnectionManager() {
		p = null;
		con = null;
	}
	
	public static Connection getConnection() {
		p = new 
				Parameters("root", "",  "jdbc:mysql://localhost/helpdesk", "com.mysql.jdbc.Driver");
		boolean ok = true;
//		try {
//			Class.forName(p.getDriverDB());
//		} catch (Exception e) {
//			ok = false;
//		}
		
		if(ok) {
			try {
				con = (Connection) DriverManager.getConnection(p.getDbURL()+"?serverTimezone=UTC",
						p.getUsername(),p.getPassword());
			} catch (Exception e) {
				System.out.println(e.getMessage()); 
			}
		}
		return con;
	}
}
