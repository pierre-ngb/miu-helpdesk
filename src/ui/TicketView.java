package ui;

public class TicketView {
	   private String title = null;
	    private String description = null;

	    
	    public TicketView(String title, String description) {
	        this.title = title;
	        this.description = description;
	        
	    }

	    public String getFirstTitle() {
	        return title;
	    }

	   

	    public String getLastDescription() {
	        return description;
	    }
	  

}
