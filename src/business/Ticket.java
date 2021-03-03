package business;

public class Ticket {
	String title;
	String description;
	Client client;
	
	public Ticket(String title,	String description,Client c) {
		this.title = title;
		this.description = description;
		this.client = c;
		
	}
}
