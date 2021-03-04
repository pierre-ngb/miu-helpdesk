package business;

import java.util.ArrayList;
import java.util.List;

public class Agent extends User{
	
	List<Ticket> myTickets;
	
	public Agent( ) {
		myTickets = new ArrayList<Ticket>();
	}
	
	public Agent(String u,String f, String l) {
		this.setFirstName(f);
		this.setLastName(l);
		this.setUserName(u);
		myTickets = new ArrayList<Ticket>();
	}
	public void assignTicket(Ticket t) {
		myTickets.add(t);
	}
	
	

	@Override
	public List<Ticket> getTickets() {
		// TODO Auto-generated method stub
		return myTickets;
	}

	
}
