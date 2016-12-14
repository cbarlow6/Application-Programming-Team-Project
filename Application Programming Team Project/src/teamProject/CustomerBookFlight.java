package teamProject;


import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Random;

import javax.swing.ImageIcon;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.*;

public class CustomerBookFlight extends Application {
	
	Button button, button2;
	Label label;
	TextField textField, textField2;
	CheckBox checkBox;
	RadioButton radioButton;
	ComboBox comboBox, comboBox2;
	DatePicker date, date2;
	private int f;
	private String u;
	

	
	public static void main(String[] args) {
		
		launch(args);	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Airline Reservation System");	
		button = new Button();
		button.setText("Book flight");
		button.setTranslateX(2);
		button.setTranslateY(100);

	
		button2 = new Button();
		button2.setText("Main menu");
		button2.setTranslateX(200);
		button2.setTranslateY(100);
		
		button2.setOnAction(new EventHandler<ActionEvent> () {

			@Override
			public void handle(ActionEvent event) {
			
			try {	

              CustomerSuccess cbfa = new CustomerSuccess ();
              cbfa.start(primaryStage);
             
		        
			}
			catch (Exception e) {
	    		System.out.println(e);
	    	}
			}
	    	
	    });
		
		GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        
       
        
       

        
		Label departure = new Label ("Depature Date ");
		departure.setFont(new Font("Cambria", 15));
		departure.setTextFill(Color.web("#0076a3"));
        
		TextField departureInput = new TextField ();
		departureInput.setPromptText("depature date");
		
		Label userName = new Label ("Username ");
		userName.setFont(new Font("Cambria", 15));
		userName.setTextFill(Color.web("#0076a3"));
        
		TextField userNameInput = new TextField ();
		userNameInput.setPromptText("enter username");

        
		
		Label flightId = new Label ("Flight ID ");
		flightId.setFont(new Font("Cambria", 15));
		flightId.setTextFill(Color.web("#0076a3"));
        
		TextField flightIdInput = new TextField ();
		flightIdInput.setPromptText("flight id");

      

        date = new DatePicker();
        date.setPromptText("Today's Date");
        date.setMaxWidth(165);
        
    
        
     
        
        grid.add(departure, 0, 28);
        grid.add(date, 1, 28);
   
        
        grid.add(userName, 0, 30);
        grid.add(userNameInput, 1, 30);
  
        
        grid.add(flightId, 0, 32);
        grid.add(flightIdInput, 1, 32);
        
//       int f = 0;
//   
//       try { if (UserAndDatabase.validateFlightId(Integer.parseInt(flightIdInput.getText()))){
//			  this.f = Integer.parseInt(flightIdInput.getText());
//		}
//		
//		else {
//			Alert a2 = new Alert(AlertType.ERROR);
//    		a2.setTitle("Error");
//    		a2.setContentText("Invalid FlightId");
//    		a2.showAndWait();
//		}
//       }
//       catch (Exception e) {
//    	   System.out.println(e);
//       }
//       
//       String u = "";
//       try { if (UserAndDatabase.validateUsername(userNameInput.getText())){
//			  this.u = userNameInput.getText();
//		}
//		
//		else {
//			Alert a2 = new Alert(AlertType.ERROR);
//   		a2.setTitle("Error");
//   		a2.setContentText("Invalid FlightId");
//   		a2.showAndWait();
//		}
//      }
//      catch (Exception e) {
//   	   System.out.println(e);
//      }

        button.setOnAction(new EventHandler<ActionEvent>() {
        	
        	int fid;
        	String u = "";
        	
			@Override
			public void handle(ActionEvent event) {
				
				  
				 
				   
			        if (UserAndDatabase.validateFlightId(Integer.parseInt(flightIdInput.getText())) && UserAndDatabase.validateUsername(userNameInput.getText())){
						  this.fid = Integer.parseInt(flightIdInput.getText());
						  this.u = userNameInput.getText();

					}
					
					else {
						Alert a2 = new Alert(AlertType.ERROR);
			    		a2.setTitle("Error");
			    		a2.setContentText("Check Flight number and/or Username Input");
			    		a2.showAndWait();
					}
			        
			        
			       
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
				Random rand = new Random();
				int  bookingId = rand.nextInt(5) + 1051;
				String bookingDate = ((TextField)date.getEditor()).getText();
				String userName = u;
				int flightId = fid;
                
				
				try {
					int i = UserAndDatabase.addBooking(bookingId, bookingDate, userName, flightId);
		    		if (i>0) {
		    		
		    			Alert reg = new Alert (AlertType.CONFIRMATION);

		    			reg.setTitle("Booking Sucess");
			    		reg.setContentText("Booking completed Successfully");
			    		reg.showAndWait();
			    		
		    		}
					
			    	else {
			    		Alert a1 = new Alert(AlertType.ERROR);
			    		a1.setTitle("Error");
			    		a1.setContentText("Booking Error");
			    		a1.showAndWait();
			    	}
				}
				catch (Exception e) {
					System.out.println(e);
				}
				
				
			}
		});
        
        

        StackPane layout = new StackPane();
		layout.getChildren().add(grid);
		layout.getChildren().add(button);
		layout.getChildren().add(button2);
		
		layout.setStyle("-fx-background-color: lightskyblue");

		 Scene scene = new Scene(layout, 650, 450);

		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
}
