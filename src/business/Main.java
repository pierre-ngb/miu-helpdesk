package business;

import java.sql.SQLException;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main {

	public static void main (String[] args) {
		
		DataAccess da  = new DataAccessFacade();
//		List<User> ls = null;
//		try {
//			ls = da.allUsers();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(ls.size());
		User s = new Client();
		try {
			s = da.login("pierrengb", "12345");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
			//da.getClientTickets(s).forEach(System.out::println);
			s.getTickets().forEach(System.out::println);
		
	}
}
