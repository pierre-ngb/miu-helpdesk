package business;

import java.util.ArrayList;
import java.util.List;

public class Agent extends User{
	
	List<Ticket> myTickets;
	
	public Agent() {
		myTickets = new ArrayList<Ticket>();
	}
	
	public void assignTicket(Ticket t) {
		myTickets.add(t);
	}
	
	

	public List<Ticket> getMyTickets() {
		return myTickets;
	}

	
}
