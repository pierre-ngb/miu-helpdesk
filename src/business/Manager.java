package business;

import java.util.ArrayList;
import java.util.List;

public class Manager extends User{
	private List<Ticket> myTickets = new ArrayList<>();
	
	@Override
	public
	List<Ticket> getTickets() {
		
		return myTickets;
	}
	

}
