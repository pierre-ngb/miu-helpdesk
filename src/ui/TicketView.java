package ui;

public class TicketView {
	   private String title = null;
	    private String description = null;
	    private String status=null;

	    
	    public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getTitle() {
			return title;
		}

		public String getDescription() {
			return description;
		}

		public TicketView(String title, String description,String status) {
	        this.title = title;
	        this.description = description;
	        this.status = status;
	        
	    }

	    public String getFirstTitle() {
	        return title;
	    }

	   

	    public String getLastDescription() {
	        return description;
	    }
	  

}
