package dataaccess;

import java.sql.SQLException;
import java.util.List;
import business.*;

public interface DataAccess {

	List<User> allUsers() throws SQLException;
	
	User login(String username, String pw) throws SQLException;
	
	List<Ticket> getAllTickets() throws SQLException;
	
	void saveTicket(Ticket t) throws SQLException;
	
	void updateStatus(Status st);

	List<Ticket> getClientTickets(User u) throws SQLException;
	
}
