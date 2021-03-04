package dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import business.*;


public class DataAccessFacade implements DataAccess{

	private Statement st = null;
	private ResultSet rs = null;
	private Connection c = ConnectionManager.getConnection();
	private String query = null;
	private PreparedStatement prepare;
	
	public List<User> allUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		query = "SELECT * FROM users";
		try {
			st = (Statement) c.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			throw new SQLException();
		}
		
		while(rs.next()) {
			
			if(rs.getString("userFlag").equals(Auth.CLIENT)) {
				users.add(new Client());
			}
			else if (rs.getString("userFlag").equals(Auth.AGENT)) {
				users.add(new Manager());
			}
			else {
				users.add(new Agent());
			}
			
		}
		st.close();
		return users;
	}

	@Override
	public User login(String username, String pw) throws SQLException {
		query = "SELECT * FROM user WHERE userName =? AND passWord=?";
		prepare = c.prepareStatement(query);
		prepare.setString(1, username);
		prepare.setString(2, pw);
		rs = prepare.executeQuery();
		User ur = null;
		if(rs.next()) {
			if(rs.getString("userFlag").equals("CLIENT")) {
				ur = new Client();
			}
			else if (rs.getString("userFlag").equals("AGENT")) {
				ur = new Agent();
			}
			else {
				ur = new Manager();
			}
		}
		rs.close();
		return ur;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return null;
	}

	@Override
	public void saveTicket(Ticket t) {
		query =  "INSERT INTO ticket ";
	}

	@Override
	public void updateStatus(Status st) {
		
	}


	

	
}
