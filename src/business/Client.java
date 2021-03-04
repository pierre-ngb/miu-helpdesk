package business;

import java.util.ArrayList;
import java.util.List;

public class Client extends User {
	
	private List<Ticket> myTickets = new ArrayList<>();
//	
//	public void createTicket(String title, String description){
//		Ticket newTicket = new Ticket(title,description,this);
//		
	public Client() {
		super();
	}
	public List<Ticket> getTickets(){
		return myTickets;
	}
	public void addTicket(Ticket t) {
		myTickets.add(t);
	}
	
	

}
