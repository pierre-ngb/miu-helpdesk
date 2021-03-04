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
	private int id;
	
	private String ownerId;///////////////////
	
	public Ticket(int id,String title,	String description,User c) {
		this.id=id;
		this.title = title;
		this.description = description;
		this.client = (Client) c;	
	}
	
	public Ticket(int id,String title,	String description,Agent c) {
		this.id=id;
		this.title = title;
		this.description = description;
		this.agent =  c;	
		
	}
	

	
     public Ticket(int id, String title, String description, String c) {
    	 this.id=id;
 		this.title = title;
 		this.description = description;
 		this.ownerId = c;	
	}

	public int getId() {
    	 return this.id;
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
	
	public void setAgent(Agent agent) {
		this.agent=agent;
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
