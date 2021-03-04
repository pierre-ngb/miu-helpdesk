package dataaccess;

import java.sql.Connection;
import java.util.List;

<<<<<<< HEAD
import business.Parameters;
import business.Ticket;
import business.User;
import javafx.scene.control.Alert;
=======
import business.Status;
import business.Ticket;
import business.User;
>>>>>>> 3f76646e4c971f88b84eeec6c7d5648ffe416c79

public class DataAccessFacade implements DataAccess{

	@Override
	public List<User> allUsers() {
		return null;
	}

	@Override
	public User login(String username, String pw) {
		return null;
	}

	@Override
	public List<Ticket> getAllTickets() {
		return null;
	}

	@Override
	public void saveTicket(Ticket t) {
		
	}

	@Override
	public void updateStatus(Status st) {
		
	}


	

	
}
