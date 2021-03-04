package business;

import java.sql.SQLException;
import java.util.List;

import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

public class Main {

	public static void main (String[] args) {
		
		DataAccess da  = new DataAccessFacade();
		List<User> ls = null;
		try {
			ls = da.allUsers();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(ls.size());
	}
}
