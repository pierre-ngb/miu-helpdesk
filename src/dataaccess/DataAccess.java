package dataaccess;

import java.util.List;
import business.*;

public interface DataAccess {

	public List<User> allUsers();
	
	public User login(String username, String pw);
	
	public List<Ticket> getAllTickets();
	
	public void saveTicket(Ticket t);
	
	public void updateStatus(Status st);
	
}
