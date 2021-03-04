package dataaccess;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import business.*;


public class DataAccessFacade implements DataAccess{

	private Statement st = null;
	private ResultSet rs = null;
	private Connection c = ConnectionManager.getConnection();
	private String query = null;
	private PreparedStatement prepare;
	
	public List<User> allUsers() throws SQLException {
		List<User> users = new ArrayList<User>();
		query = "SELECT * FROM users";
		try {
			st = (Statement) c.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			throw new SQLException();
		}
		
		while(rs.next()) {
			
			if(rs.getString("userFlag").equals(Auth.CLIENT)) {
				users.add(new Client());
			}
			else if (rs.getString("userFlag").equals(Auth.AGENT)) {
				users.add(new Manager());
			}
			else {
				users.add(new Agent());
			}
			
		}
		st.close();
		return users;
	}

	@Override
	public User login(String username, String pw) throws SQLException {
		query = "SELECT * FROM user WHERE userName =? AND passWord=?";
		prepare = c.prepareStatement(query);
		prepare.setString(1, username);
		prepare.setString(2, pw);
		rs = prepare.executeQuery();
		User ur = null;
		if(rs.next()) {
			if(rs.getString("userFlag").equals("CLIENT")) {
				ur = new Client();
				ur.setUserName(username);
				ur.getTickets().addAll(getClientTickets(ur));
			}
			else if (rs.getString("userFlag").equals("AGENT")) {
				ur = new Agent();
				ur.setUserName(username);
				ur.getTickets().addAll(getAgentTickets((Agent) ur));
			}
			else {
				ur = new Manager();
				ur.setUserName(username);
				ur.getTickets().addAll(getAllTickets());
			}
		}
		rs.close();
		return ur;
	}

	@Override
	public
	List<Ticket> getAllTickets() throws SQLException {
		List<Ticket> tickets = new ArrayList<Ticket>();
		query = "SELECT * FROM ticket WHERE assignedTo = 0";
		prepare = c.prepareStatement(query);
		rs = prepare.executeQuery();
		while (rs.next()) {
			tickets.add(new Ticket(rs.getInt("ticketId"),rs.getString("title"), rs.getString("detail")
					, rs.getString("owner")));
		}
		return tickets;
	}

	public
	List<Agent> getAllAgents() throws SQLException {
		List<Agent> agents = new ArrayList<Agent>();
		query = "SELECT * FROM user WHERE userFlag = ?";
		prepare = c.prepareStatement(query);
		prepare.setString(1, "AGENT");
		rs = prepare.executeQuery();
		while (rs.next()) {
			agents.add(new Agent(rs.getString("userName"),rs.getString("firstName"),rs.getString("lastName")));
		}
		return agents;
	}

	
	
	
	@Override
	public void saveTicket(Ticket t) throws SQLException {
		query =  "INSERT INTO ticket (assignedTo,solution,status,title, detail, owner) ";
		query += "VALUES (0,'',1,?,?,?)";
		prepare = c.prepareStatement(query);
		prepare.setString(1, t.getTitle().toString());
		prepare.setString(2, t.getDescription());
		prepare.setString(3, t.getClient().getUserName());
		prepare.executeUpdate();
		prepare.close();
	}

	@Override
	public void updateStatus(Status st) {
		
		
	}

	@Override
	public List<Ticket> getClientTickets(User u) throws SQLException{
		List<Ticket> tickets = new ArrayList<Ticket>();
		query = "SELECT * FROM ticket WHERE owner =?";
		prepare = c.prepareStatement(query);
		prepare.setString(1, u.getUserName());
		rs = prepare.executeQuery();
		while (rs.next()) {
			tickets.add(new Ticket(rs.getInt("ticketId"),rs.getString("title"), rs.getString("detail")
					, u));
		}
		System.out.println(tickets.size());
		return tickets;
	}
	
	public List<Ticket> getAgentTickets(Agent u) throws SQLException{
		List<Ticket> tickets = new ArrayList<Ticket>();
		query = "SELECT * FROM ticket WHERE assignedTo =?";
		prepare = c.prepareStatement(query);
		prepare.setString(1, u.getUserName());
		rs = prepare.executeQuery();
		while (rs.next()) {
			tickets.add(new Ticket(rs.getInt("ticketId"),rs.getString("detail"), rs.getString("detail")
					,u));
		}
		return tickets;
	}

	
	public void solveTicket(Ticket t) throws SQLException{
		
		query = "UPDATE ticket set status=3, solution= ?, assignedTo =? WHERE ticketId =?";
		prepare = c.prepareStatement(query);
		prepare.setString(1, t.getSolution());
		prepare.setString(2, t.getAgent().getUserName());
		if(t.getAgent()!=null)
			prepare.setLong(3, t.getId());
		else
			prepare.setString(3, "0");
			
	    prepare.executeUpdate();
		
	}

	

	
}
