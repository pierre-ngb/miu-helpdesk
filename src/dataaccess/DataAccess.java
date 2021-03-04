package dataaccess;

import java.sql.SQLException;
import java.util.List;
import business.*;

public interface DataAccess {

	public List<User> allUsers() throws SQLException;
	
	public User login(String username, String pw) throws SQLException;
	
	public List<Ticket> getAllTickets();
	
	public void saveTicket(Ticket t) throws SQLException;
	
	public void updateStatus(Status st);
	
}
