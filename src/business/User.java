package business;

import java.util.List;

public abstract class User {
	
	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private List<Ticket> tickets;
	
	public User() {}
	
	public User(String f, String l, String u, String p) {
		firstName = f;
		lastName = l;
		userName = u;
		password = p;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public abstract List<Ticket> getTickets();
	

}
