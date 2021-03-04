package business;

public class Parameters {

	private String username;
	private String password;
	private String dbURL;
	private String driverDB;
	
	public Parameters(String username, String password, String dbURL, String driverDB) {

		this.username = username;
		this.password = password;
		this.dbURL = dbURL;
		this.driverDB = driverDB;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getDbURL() {
		return dbURL;
	}

	public String getDriverDB() {
		return driverDB;
	}
	
	
	
}
