package teamProject;


import java.util.Optional;
import javafx.application.Application;
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

public class CustomerSuccess extends Application {
	
	Stage window;
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
        

		Label customerPage = new Label("Customer  Pannel");
		customerPage.setFont(new Font("Cambria", 25));
		customerPage.setTextFill(Color.web("#0076a3"));
		
		GridPane.setConstraints(customerPage, 2, 0);
		
	    Button searchFlight = new Button ("  Search Flight ");
	    GridPane.setConstraints(searchFlight, 4, 8);
	   
	    searchFlight.setOnAction(new EventHandler<ActionEvent> () {

			@Override
			public void handle(ActionEvent event) {
			
			try {	

              SearchFlight cbf = new SearchFlight ();
              cbf.start(primaryStage);
             
		        
			}
			catch (Exception e) {
	    		System.out.println(e);
	    	}
			}
	    	
	    });
	    
	    Button bookFlight = new Button ("   Book Flight    ");
	    GridPane.setConstraints(bookFlight,4, 10);
	    bookFlight.setOnAction(new EventHandler<ActionEvent> () {

			@Override
			public void handle(ActionEvent event) {
			
			try {	

              CustomerBookFlight cbf = new CustomerBookFlight ();
              cbf.start(primaryStage);
             
		        
			}
			catch (Exception e) {
	    		System.out.println(e);
	    	}
			}
	    	
	    });
	    Button deleteBooking = new Button ("Delete Booking");
	    GridPane.setConstraints(deleteBooking,4, 12);
	    
	    Button logOut = new Button ("      Log out       ");
	    GridPane.setConstraints(logOut, 4, 14);
	    
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
	   
	

	    grid.getChildren().addAll(customerPage, searchFlight, bookFlight, deleteBooking, logOut);
	    
	    grid.setStyle("-fx-background-color: lightskyblue");
	    scene = new Scene(grid, 650, 450);
	    
	    
	   
		    window.setScene(scene);
			window.setTitle("Airline Reservation System");
		    window.show();
	}
	
	

		
	

}
