package ui;
	

import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.mysql.cj.conf.ConnectionUrl.Type;

import business.Agent;
import business.Client;
import business.Manager;
import business.Ticket;
import business.User;
import dataaccess.DataAccess;
import dataaccess.DataAccessFacade;

//import com.sun.org.apache.xpath.internal.functions.FuncStartsWith;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;



public class UIColection  {

	

	
	
	public static Scene formScene(Ticket t) {
		
		
		Label label= new Label("Ticket");
		label.setStyle("-fx-font-size:16");
	
		
		Label label2 = new Label("Ticket Id: ");
		label2.setStyle("-fx-font-size:16");
		Label labelb2 = new Label(t.getId()+"");

		Label label3 = new Label("Title: ");
		label3.setStyle("-fx-font-size:16");
		Label labelb3 = new Label(t.getTitle());
		

		Label label4 = new Label("Descriptin: ");
		label3.setStyle("-fx-font-size:16");

		TextArea labelb4=new TextArea(t.getDescription());
		labelb4.setDisable(true);


		 
		
		Separator separator = new Separator(Orientation.HORIZONTAL);
		
		Label label5 = new Label("Assigned TO: ");
		label5.setStyle("-fx-font-size:16");
		
		
		Label labelb5 = new Label();
		if(t.getAgent()!=null)
		labelb5.setText(t.getAgent().getFirstName()+" "+t.getAgent().getLastName());
		

		Label label6 = new Label("Assigned By: ");
		label6.setStyle("-fx-font-size:16");
		Label labelb6 = new Label("548744");
		
		

		Label label7 = new Label("Status: ");
		label7.setStyle("-fx-font-size:20");
		Label labelb7 = new Label("Open");
		

		Label label8 = new Label("Solution: ");
		label8.setStyle("-fx-font-size:16");
		
		TextArea labelb8=new TextArea();
		if(t.getSolution()!=null)
		labelb8.setText(t.getSolution());	
		labelb8.setDisable(true);
		labelb8.setStyle("-fx-text-color:red");
		
		GridPane gridPane = new GridPane();
		

		gridPane.add(label2, 0, 1, 1, 1);
		gridPane.add(label3, 0, 2, 1, 1);
		
		
		gridPane.add(labelb2, 1, 1, 1, 1);
		gridPane.add(labelb3, 1, 2, 1, 1);
		
		
		gridPane.add(label4, 0, 3, 1, 1);
		gridPane.add(labelb4, 0, 4, 2, 1);
		
		gridPane.add(separator, 0, 5, 1, 1);
		

		gridPane.add(label5, 0, 6, 1, 1);
		gridPane.add(label6, 0, 7, 1, 1);
		gridPane.add(label7, 0, 8, 1, 1);
		gridPane.add(label8, 0, 9, 1, 1);
		
		gridPane.add(labelb5, 1, 6, 1, 1);
		gridPane.add(labelb6, 1, 7, 1, 1);
		gridPane.add(labelb7, 1, 8, 1, 1);
		gridPane.add(labelb8, 0, 10, 2, 1);
		
	
		
	
		Button btn1 = new Button("Close");
		//btn.setOnAction(e -> System.out.println("Click"));

		Button btn2 = new Button("Cancel");
		//btn.setOnAction(e -> System.out.println("Click"));

		HBox buttonBox = new HBox(15);     // sets spacing
		buttonBox.getChildren().addAll(btn1,btn2);
		buttonBox.setAlignment(Pos.TOP_RIGHT);
		
		
		VBox vbox1 = new VBox(15);     // sets spacing
		vbox1.getChildren().addAll(label);
		vbox1.setAlignment(Pos.TOP_LEFT);
		
		
		VBox vbox2 = new VBox(15);     // sets spacing
		vbox2.getChildren().addAll(vbox1, gridPane, buttonBox);
		vbox2.setAlignment(Pos.TOP_RIGHT);
		vbox2.setPadding(new Insets(15));
		
		
		
		
		return new Scene(vbox2);
	}
	
	
	
	
	
	
	public static Scene adminScene() {
		
		
		Label label= new Label("Admin Panal");
		label.setStyle("-fx-font-size:20");
		label.setPadding(new Insets(20));
	
		

		 TableView<TicketView> tableView = new TableView<TicketView>();

		 TableColumn<TicketView, String> Column1 = new TableColumn<>("Title");
		 Column1.setCellValueFactory(new PropertyValueFactory<>("title"));

		 TableColumn<TicketView, String> Column2 = new TableColumn<>("Description");
		 Column2.setCellValueFactory(new PropertyValueFactory<>("description"));
	

		    tableView.getColumns().add(Column1);
		    tableView.getColumns().add(Column2);
		 
		    
		    
		 Session.user.getTickets().stream().forEach(t->{
			 	tableView.getItems().add(new TicketView(t.getTitle(), t.getDescription()));
		 	});
		 
		 
		 
	 tableView.setPlaceholder(new Label("No ticket to display"));
	 tableView.setMinWidth(450);
		 

		//PropertyValueFactory<Object, Object> factory = new PropertyValueFactory<>("firstName");
		 
		 TableViewSelectionModel<TicketView> selectionModel = tableView.getSelectionModel();
		 
		// set selection mode to only 1 row
		 selectionModel.setSelectionMode(SelectionMode.SINGLE);
		 

		
		Button btn1 = new Button("View Detail");
		Button btn2 = new Button("Assign");
		
		
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        try {
	        	Stage secondaryStage=new Stage();
	        	secondaryStage.setScene(UIColection.formScene(Session.user.getTickets().get(selectionModel.getSelectedIndex())));
	        	secondaryStage.setResizable(false);
	        	secondaryStage.setTitle("MIU help desk");
	        	secondaryStage.show();
	        	
	        }
	    	catch (ArrayIndexOutOfBoundsException e)
	    	{
	    		alert("select a ticket");
	    	} 
	        	
	        	
	        }
	    });
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        try {
	        	Stage secondaryStage=new Stage();
	        	secondaryStage.setScene(UIColection.assignScene(Session.user.getTickets().get(selectionModel.getSelectedIndex())));
	        	secondaryStage.setResizable(false);
	        	secondaryStage.setTitle("MIU help desk");
	        	secondaryStage.show();
	        	
	        }
	    	catch (ArrayIndexOutOfBoundsException e)
	    	{
	    		alert("select a ticket");
	    	} 	
	        	
	        	
	        }
	    });
		
		HBox buttonBox = new HBox(15);     // sets spacing
		buttonBox.getChildren().addAll(btn1,btn2);
		buttonBox.setAlignment(Pos.TOP_RIGHT);
		
	
		
		VBox vbox1 = new VBox(15);     // sets spacing
		vbox1.getChildren().addAll(tableView,buttonBox);
		vbox1.setPadding(new Insets(20));
	
		Button btn3 = new Button("Manage Tickets");
		Button btn4 = new Button("Manage Clients");
		Button btn5 = new Button("Manage Ajents");
		
		VBox vbox2 = new VBox(15);     // sets spacing
		vbox2.setStyle("-fx-background-color: #eeeeee;");
		vbox2.getChildren().addAll(btn3,btn4,btn5);
		vbox2.setPadding(new Insets(20));
		
		HBox finalBox = new HBox(15);     // sets spacing
		finalBox.getChildren().addAll(vbox2,vbox1);
		finalBox.setAlignment(Pos.TOP_LEFT);
		
		
		VBox vbox3 = new VBox(15);     // sets spacing
		
		vbox3.getChildren().addAll(label, finalBox);
		
		
		return new Scene(vbox3);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
public static Scene clientScene() {
		
		
		Label label= new Label("Client Panel");
		label.setStyle("-fx-font-size:20");
		// Open tickets
		
		
		
		
		 TableView<TicketView> tableView = new TableView<TicketView>();

		 TableColumn<TicketView, String> Column1 = new TableColumn<>("Title");
		 Column1.setCellValueFactory(new PropertyValueFactory<>("title"));

		 TableColumn<TicketView, String> Column2 = new TableColumn<>("Description");
		 Column2.setCellValueFactory(new PropertyValueFactory<>("description"));
	

		    tableView.getColumns().add(Column1);
		    tableView.getColumns().add(Column2);
		 
		    
		    
		 Session.user.getTickets().stream().forEach(t->{
			 	tableView.getItems().add(new TicketView(t.getTitle(), t.getDescription()));
		 	});
		 
		 
		 
	 tableView.setPlaceholder(new Label("No ticket to display"));
		 

		//PropertyValueFactory<Object, Object> factory = new PropertyValueFactory<>("firstName");
		 
		 TableViewSelectionModel<TicketView> selectionModel = tableView.getSelectionModel();
		 
		// set selection mode to only 1 row
		 selectionModel.setSelectionMode(SelectionMode.SINGLE);
		 
		 
		 
		// selectionModel.clearSelection();
		 
		List<String> l=new ArrayList<String>();
		l.add("one tws");
		l.add("Tne tws");
		l.add("Thne tws");
		l.add("Foune tws");

	
		
		
		//HBox finalList=new HBox(tableView);
		
		Button btn1 = new Button("View Detail");
		Button btn2 = new Button("Creat New");
		
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	try {
            	Stage secondaryStage=new Stage();
            	secondaryStage.setScene(UIColection.formScene(Session.user.getTickets().get(selectionModel.getSelectedIndex())));
            	secondaryStage.setResizable(false);
            	secondaryStage.setTitle("MIU help desk");
            	secondaryStage.show();
            	}
            	catch (ArrayIndexOutOfBoundsException e)
            	{
            		alert("select a ticket");
            	}            	
            	
            	
            }
        });
		
		
		
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	
            	
            
            	Stage secondaryStage=new Stage();
            	secondaryStage.setScene(UIColection.createScene());
            	secondaryStage.setResizable(false);
            	secondaryStage.setTitle("MIU help desk");
            	secondaryStage.show();
            	
            	
            	
            	
            }
        });
		
		HBox buttonBox = new HBox(15);     // sets spacing
		buttonBox.getChildren().addAll(btn1,btn2);
		buttonBox.setAlignment(Pos.TOP_RIGHT);
		
	
		
		VBox vbox1 = new VBox(15);     // sets spacing
		vbox1.getChildren().addAll(label,tableView,buttonBox);
		vbox1.setPadding(new Insets(20));
	
		
	
		
		
		
		return new Scene(vbox1, 400, 600);
	}
	
	
	
public static Scene ajentScene() {
	
	
	Label label= new Label("Assigned Tickets");
	label.setStyle("-fx-font-size:20");
	// Open tickets
	
	
	

	ListView<HBox> ticketListView= new ListView<HBox>();////
	 TableView<TicketView> tableView = new TableView<TicketView>();

	 TableColumn<TicketView, String> Column1 = new TableColumn<>("Title");
	 Column1.setCellValueFactory(new PropertyValueFactory<>("title"));

	 TableColumn<TicketView, String> Column2 = new TableColumn<>("Description");
	 Column2.setCellValueFactory(new PropertyValueFactory<>("description"));


	    tableView.getColumns().add(Column1);
	    tableView.getColumns().add(Column2);
	 
	    
	    
	 Session.user.getTickets().stream().forEach(t->{
		 	tableView.getItems().add(new TicketView(t.getTitle(), t.getDescription()));
	 	});
	 
	 
	 tableView.setPlaceholder(new Label("No ticket to display"));
	 
	 TableViewSelectionModel<TicketView> selectionModel = tableView.getSelectionModel();
	 

	 selectionModel.setSelectionMode(SelectionMode.SINGLE);
	 

	 
	List<String> l=new ArrayList<String>();
	l.add("one tws");
	l.add("Tne tws");
	l.add("Thne tws");
	l.add("Foune tws");

	for (Iterator<String> iterator = l.iterator(); iterator.hasNext();) {
		HBox i=new HBox(12);
		Label li= new Label(iterator.next());
		HBox i2=new HBox(12);
		Label li2= new Label("on");

		i2.setAlignment(Pos.BASELINE_RIGHT);
		i2.setStyle("-fx-background-color: #0000ff;"+"-fx-width:100%");
		i2.getChildren().addAll(li2);
		
		i.getChildren().addAll(li,i2);
		
		ticketListView.getItems().add(i);
		
	}
	
	
	//HBox finalList=new HBox(tableView);
	
	Button btn1 = new Button("View Detail");
	Button btn2 = new Button("Solve");
	
	btn1.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        try {
        	Stage secondaryStage=new Stage();
        	secondaryStage.setScene(UIColection.formScene(Session.user.getTickets().get(selectionModel.getSelectedIndex())));
        	secondaryStage.setResizable(false);
        	secondaryStage.setTitle("MIU help desk");
        	secondaryStage.show();
        	
        }
    	catch (ArrayIndexOutOfBoundsException e)
    	{
    		alert("select a ticket");
    	} 
        	
        	
        }
    });
	
	btn2.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
        try {
        	Stage secondaryStage=new Stage();
        	secondaryStage.setScene(UIColection.solutionScene(Session.user.getTickets().get(selectionModel.getSelectedIndex())));
        	secondaryStage.setResizable(false);
        	secondaryStage.setTitle("MIU help desk");
        	secondaryStage.show();
        	
        }
    	catch (ArrayIndexOutOfBoundsException e)
    	{
    		alert("select a ticket");
    	} 	
        	
        	
        }
    });
	
	HBox buttonBox = new HBox(15);     // sets spacing
	buttonBox.getChildren().addAll(btn1,btn2);
	buttonBox.setAlignment(Pos.TOP_RIGHT);
	

	
	VBox vbox1 = new VBox(15);     // sets spacing
	vbox1.getChildren().addAll(label,tableView,buttonBox);
	vbox1.setPadding(new Insets(20));

	

	
	
	
	return new Scene(vbox1, 400, 600);
}




	
	

	
	public static Scene solutionScene(Ticket t) {
		
		
		Label label= new Label("Solution");
		label.setStyle("-fx-font-size:20");
	
		
		
		
		TextArea textarea=new TextArea(t.getId()+"");


		 
	
		
		Button btn1 = new Button("Solve");
		Button btn2 = new Button("Calncel");
		
		
		
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	       
	        	t.setSolution(textarea.getText());
	        	try {
					new DataAccessFacade().solveTicket(t);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        	  Stage stage = (Stage) btn2.getScene().getWindow();
	        	  stage.close();
	        	
	        	
	        }
	    });
		
		
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	       
	        	  Stage stage = (Stage) btn2.getScene().getWindow();
	        	  stage.close();
	        	
	        	
	        }
	    });
		
		HBox buttonBox = new HBox(15);     // sets spacing
		buttonBox.getChildren().addAll(btn1,btn2);
		buttonBox.setAlignment(Pos.TOP_RIGHT);
		
	
		
		VBox vbox1 = new VBox(15);     // sets spacing
		vbox1.getChildren().addAll(label,textarea,buttonBox);
		vbox1.setPadding(new Insets(20));
	
		
	
		
		
		
		return new Scene(vbox1);
	}
	
	
	
	public static Scene createScene() {
		
		
		Label label= new Label("Create Ticke");
		label.setStyle("-fx-font-size:20");
	
		
		
		TextField textField= new TextField("Title");
		TextArea textarea=new TextArea("Description");


		 
	
		
		Button btn1 = new Button("Create");
		Button btn2 = new Button("Calncel");
		
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	        	
	        	Ticket t=new Ticket(0,textField.getText(), textarea.getText(), Session.user);
	        	try {
					new DataAccessFacade().saveTicket(t);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	        	
	        	 Stage stage = (Stage) btn2.getScene().getWindow();
	        	  stage.close();
	        	  alert("Ticket Registerd!! we will contact you soon",AlertType.INFORMATION);
	        	
	        	
	        }

			
	    });
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	       
	        	  Stage stage = (Stage) btn2.getScene().getWindow();
	        	  stage.close();
	        	
	        	
	        }
	    });
		HBox buttonBox = new HBox(15);     // sets spacing
		buttonBox.getChildren().addAll(btn1,btn2);
		buttonBox.setAlignment(Pos.TOP_RIGHT);
		
	
		
		VBox vbox1 = new VBox(15);     // sets spacing
		vbox1.getChildren().addAll(label,textField,textarea,buttonBox);
		vbox1.setPadding(new Insets(20));
	
		
	
		
		
		
		return new Scene(vbox1);
	}
	
	
	
	
	
	
	

	

	public static Scene loginScene(Stage secondaryStage) {
		
		
	
		
		Label label= new Label("Log in");
		label.setStyle("-fx-font-size:20");
	
		
		TextField txtInput = new TextField("User Name");
		
		PasswordField pasInput= new PasswordField();
		Button btn = new Button("Log in");
		btn.setOnAction(new EventHandler<ActionEvent>() {
	            @Override
	            public void handle(ActionEvent event) {
	            	
	            	try {
						//User u=d.login(txtInput.getText().toString(),pasInput.getText().toString());
	            	
	            		DataAccess d=new DataAccessFacade();
	            		
	            		User u=d.login("addisu", "damena");
	            		Session.user=u;
	            		String s1=u.getClass().toString();
	            		System.out.println();
						if(s1.equals("class business.Manager")) {
							
							secondaryStage.setScene(UIColection.adminScene());
							
						}
						else if(s1.equals("class business.Client")) {
							
							secondaryStage.setScene(UIColection.clientScene());
							
							
						}
					    else if(s1.equals("class business.Agent")) {
					    	
					    	secondaryStage.setScene(UIColection.ajentScene());
					    }
						else {
							    System.out.println("No user type");
							    Session.user=null;
						}
						
					} catch (SQLException e) {
						System.out.println(e.getMessage());
					}
	            	
	            	secondaryStage.setResizable(false);
	            	secondaryStage.setTitle("MIU help desk");
	            	secondaryStage.show();
	            	
	            	
	            	
	            	
	            }
	        });
		VBox vbox1 = new VBox(15);     // sets spacing
		vbox1.getChildren().addAll(label);
		vbox1.setAlignment(Pos.TOP_LEFT);
		vbox1.setPadding(new Insets(15));
		
		
		VBox vbox2 = new VBox(15);     // sets spacing
		vbox2.getChildren().addAll(vbox1,txtInput, pasInput, btn);
		vbox2.setAlignment(Pos.TOP_RIGHT);
		vbox2.setPadding(new Insets(15));
		
		
		
		
		return new Scene(vbox2,400,250);
	}
	
	
	

	








	public static Scene assignScene(Ticket t) {
		
		
	
		
		Label label= new Label("Assign ticket");
		label.setStyle("-fx-font-size:20");
	
	
		Label labeld= new Label("Department");
		 ComboBox<String> comboBox = new ComboBox<String>();

	        comboBox.getItems().add("Mentainance");
	        comboBox.getItems().add("It support");
	        comboBox.getItems().add("Security");
	        
	        ListView<String> listView = new ListView<String>();
	        
	        List <Agent>indexAgent = new ArrayList<Agent>();
	   
	        
	     
	        
	        	
	        try {
				new DataAccessFacade().getAllAgents().stream()
							.forEach(a->listView.getItems().add(a.getFirstName()+" "+a.getLastName()));
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			


	    	HBox departmentbox = new HBox(15);     // sets spacing
	    	departmentbox.getChildren().addAll(labeld,comboBox);
	    	departmentbox.setAlignment(Pos.TOP_RIGHT);
			
		
		Button btn1 = new Button("Assign");
		Button btn2 = new Button("Calncel");
		
		btn1.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	       try {
	    	   List <Agent>myagents = new ArrayList<Agent>();
	    	   myagents=new DataAccessFacade().getAllAgents();
	        	t.setAgent(myagents.get(listView.getSelectionModel().getSelectedIndex()));
	        	try {
					new DataAccessFacade().solveTicket(t);
				} catch (SQLException e) {
					e.printStackTrace();
				}
	        	
	        	  Stage stage = (Stage) btn2.getScene().getWindow();
	        	  stage.close();
	    	}
        	catch (ArrayIndexOutOfBoundsException | SQLException e)
        	{
        		alert("select a ticket");
        	}  
	        	
	        }
	    });
		
		
		
		
		
		
		btn2.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent event) {
	       
	        	  Stage stage = (Stage) btn2.getScene().getWindow();
	        	  stage.close();
	        	
	        	
	        }
	    });
		
		
		
		
		HBox buttonBox = new HBox(15);     // sets spacing
		buttonBox.getChildren().addAll(btn1,btn2);
		buttonBox.setAlignment(Pos.TOP_RIGHT);
		
		VBox vbox1 = new VBox(15);     // sets spacing
		vbox1.getChildren().addAll(label,departmentbox);
		vbox1.setAlignment(Pos.TOP_LEFT);
		vbox1.setPadding(new Insets(15));
		
		
		VBox vbox2 = new VBox(15);     // sets spacing
		vbox2.getChildren().addAll(vbox1, listView, buttonBox);
		vbox2.setAlignment(Pos.TOP_RIGHT);
		vbox2.setPadding(new Insets(15));
		
		
		
		
		return new Scene(vbox2,400,300);
	}
	
	
	
	private static void alert (Object object) {
		Alert a = new Alert(AlertType.WARNING); 
		a.setContentText(object+"");
		 a.show(); 
	}

	
	private static void alert(Object object, AlertType i) {
		Alert a = new Alert(i); 
		a.setContentText(object+"");
		 a.show(); 
		
	}

	
}
