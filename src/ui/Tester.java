package ui;

import java.sql.SQLException;

import business.User;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Tester {

	
	public static void main(String []a) {
		DataAccess d=new DataAccessFacade();
		try {
		Session.user=d.login("banchi", "damena");
		 Session.user.getTickets().stream().forEach(t->{
			 say(t);	
			 ///say(t.get()+" "+ t.getDescription()+" "+t.getStatus().toString());
		 	});
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

public static void say(Object o) {
	System.out.println(o);
}

}







/*
 
 
 	
		btn2.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	       
	        	  Stage stage = (Stage) btn2.getScene().getWindow();
	        	  stage.close();
	        	
	        	
	        }
	    });
 
 
 
 
 
 
 
 
 */
