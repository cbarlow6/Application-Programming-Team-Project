package teamProject;


import java.util.Optional;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

public class AdminSuccess extends Application {
	
	public Stage window;
	static HomePage test;
	Scene scene, scene2, scene3;

	public static void main(String[] args) {
		launch(args);
		
		try {
			test = new HomePage();
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        

		Label adminPage = new Label("Admin Control Pannel");
		adminPage.setFont(new Font("Cambria", 25));
		adminPage.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(adminPage, 2, 0);
		
	    Button searchFlight = new Button (" Search Flight ");
	    GridPane.setConstraints(searchFlight, 3, 8);
	   
	    searchFlight.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
	
		    	
		    	try {
			    		BookingPage bp1 = new BookingPage();
			    		bp1.start(primaryStage);
			    	}
		    	
		    	catch (Exception e) {
		    		System.out.println(e);
		    	}
		    	
			}
	    	
	    }
	    		    		
	    		);
	    
	    Button viewCustomers = new Button ("   View Users   ");
	    GridPane.setConstraints(viewCustomers, 3, 10);
	    
	    viewCustomers.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
				AdminTableView atv = new AdminTableView();
		    	try {
		    		
		    		TableView<Object> tableView = new TableView<Object>();
		    		
		    		System.out.println("*******");
		    		atv.buildData(tableView);
		    		
		    		Stage stage = new Stage();
		    		
		    		
		    		//tableview = new TableView<Object>();
		    		//atv.buildData();
					stage.setWidth(650);
					stage.setHeight(450);
					stage.setTitle("Airline Reservations");
					stage.setResizable(true);
					
					Scene scene = new Scene(tableView);
					tableView.setStyle("-fx-background-color: lightskyblue");
					stage.setScene(scene);
					
					try {
						stage.show();
						
						stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
							
							@Override
							public void handle(WindowEvent event) {
							try {
								
								System.out.println("hi");
								
								
								
							}
							
							catch (Exception a) {
								System.out.println(a);
							}
								
							}
						});
					}
					catch (Exception e) {
						System.out.print(e);
					}
				
		            stage.show();
		    		
		            
		    		
		    	}
		    	
		    	catch (Exception e) {
		    		System.out.println(e);
		    	}
		    	
			}
	    	
	    }
	    		    		
	    		);
	    
	    Button addFlight = new Button ("   Add Flight    ");
	    GridPane.setConstraints(addFlight, 3, 12);
	    
	    addFlight.setOnAction(new EventHandler<ActionEvent> () {
			@Override
			public void handle(ActionEvent event) {
		    	
		    	try {
		    		
		    		BookingPage nay = new BookingPage ();
		    		
			    		nay.start(primaryStage);
			    		
		    		
		    	}
		    	
		    	catch (Exception e) {
		    		System.out.println(e);
		    	}
		    	
			}
	    	
	    }
	    		    		
	    		);
	    Button deletFlight = new Button (" Delete Flight  ");
	    GridPane.setConstraints(deletFlight, 3, 14);
	   
		
	    Button logOut = new Button ("     Log out      ");
	    GridPane.setConstraints(logOut, 3, 16);
	    logOut.setOnAction(new EventHandler<ActionEvent> () {

			@Override
			public void handle(ActionEvent event) {
			
			try {	

              HomePage cbf = new HomePage ();
              cbf.start(primaryStage);
             
		        
			}
			catch (Exception e) {
	    		System.out.println(e);
	    	}
			}
	    	
	    });

	    
	    grid.getChildren().addAll(adminPage, viewCustomers, addFlight, deletFlight, logOut);
	    
	    grid.setStyle("-fx-background-color: lightskyblue");
	    scene = new Scene(grid, 650, 450);
	    
	   
		    window.setScene(scene);
			window.setTitle("Airline Reservation System");
		    window.show();
	}
	
	
	
	

		
	

}
