package business;
import dataaccess.DataAccess.*;
import java.util.List;
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
		//saveTicket(this);
	}
	
	void setAgent(Agent a) {
		agent = a;
		//updateTicket(this);
	}
	Agent getAgent() {return agent;}
	void setManager(Manager m) {manager = m ;}
	Manager getManager() {return manager;}
	void setStatus(Status s) {status =s;}
	Status getStatus() {return status;}
	void setSolution(String solution) {this.solution = solution;}
	String getSolution() {return solution;}
}
