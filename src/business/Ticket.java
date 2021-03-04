package business;

public class Ticket {
	String title;
	String description;
	Client client;
	Agent agent ;
	Manager manager;
	Status status;
	String solution;
	public Ticket(String title,	String description,Client c) {
		this.title = title;
		this.description = description;
		this.client = c;		
	}
	
	void setAgent(Agent a) {
		agent = a;
	}
	void setManager(Manager m) {
		manager = m ;
	}
	void setStatus(Status s) {
		status =s;
	}
	void setSolution(String solution) {
		this.solution = solution;
	}
	
}
