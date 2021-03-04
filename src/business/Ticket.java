package business;
import dataaccess.DataAccess.*;
import java.util.List;
public class Ticket {
	private String title;
	private String description;
	private Client client;
	private Agent agent ;
	private Manager manager;
	private Status status;
	private String solution;
	
	public Ticket(String title,	String description,Client c) {
		this.title = title;
		this.description = description;
		this.client = c;	
		//saveTicket(this);
	}
	
	void setAgent(Agent a) {
		agent = a;
		//updateTicket(this);
	}
	public String getTitle() {
		return title;
	}	
	public String getDescription() {
		return description;
	}
	public Agent getAgent() {
		return agent;
	}
	public void setManager(Manager m) {
		manager = m ;
	}
	public Manager getManager() {
		return manager;
	}
	public void setStatus(Status s) {
		status =s;
	}
	public Status getStatus() {
		return status;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public String getSolution() {
		return solution;
	}

	public Client getClient() {
		return client;
	}

	@Override
	public String toString() {
		return "Ticket [title=" + title + ", description=" + description + ", status=" + status + "]";
	}
	
	
	
}
