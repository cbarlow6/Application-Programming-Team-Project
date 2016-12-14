package teamProject;


import java.awt.EventQueue;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

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

public class BookingPage extends Application {
	
	Button button, button2;
	Label label;
	TextField textField, textField2;
	CheckBox checkBox;
	RadioButton radioButton;
	ComboBox comboBox, comboBox2;
	DatePicker date, date2;
	

	
	public static void main(String[] args) {
		
		launch(args);	
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Airline Reservation System");	
		button = new Button();
		button.setText("Add Flight");
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
		
		comboBox = new ComboBox ();
		comboBox.getItems().addAll(
				"Miami, FL", 
				"Atlanta, GA",
				"New York, NY"
				);
		
		comboBox2 = new ComboBox ();
		comboBox2.getItems().addAll(
				"New York, NY", 
				"Miami, FL",
				"Atlanta, GA"
				);
		
		GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));
        
        
       
        Label flyingFrom = new Label("Flying From ");
        flyingFrom.setFont(new Font("Cambria", 15));
        flyingFrom.setTextFill(Color.web("#0076a3"));
        
        Label flyingTo = new Label("Flying To ");
        flyingTo.setFont(new Font("Cambria", 15));
        flyingTo.setTextFill(Color.web("#0076a3"));
        
		Label arrival = new Label ("Arrival Date ");
		arrival.setFont(new Font("Cambria", 15));
		arrival.setTextFill(Color.web("#0076a3"));
        
		TextField arrivalInput = new TextField ();
		arrivalInput.setPromptText("arrival date");

        
		Label departure = new Label ("Depature Date ");
		departure.setFont(new Font("Cambria", 15));
		departure.setTextFill(Color.web("#0076a3"));
        
		TextField departureInput = new TextField ();
		departureInput.setPromptText("depature date");
		
		Label departureTime = new Label ("Departure Time ");
		departureTime.setFont(new Font("Cambria", 15));
		departureTime.setTextFill(Color.web("#0076a3"));
        
		TextField departureTimeInput = new TextField ();
		departureTimeInput.setPromptText("departure time");

        
		Label arrivalTime = new Label ("Arrival Time ");
		arrivalTime.setFont(new Font("Cambria", 15));
		arrivalTime.setTextFill(Color.web("#0076a3"));
        
		TextField arrivalTimeInput = new TextField ();
		arrivalTimeInput.setPromptText("arrival time");
		
		Label flightId = new Label ("Flight ID ");
		flightId.setFont(new Font("Cambria", 15));
		flightId.setTextFill(Color.web("#0076a3"));
        
		TextField flightIdInput = new TextField ();
		flightIdInput.setPromptText("flight id");

        
		Label numberOfPassenger = new Label ("No of Passenger(s) ");
		numberOfPassenger.setFont(new Font("Cambria", 15));
		numberOfPassenger.setTextFill(Color.web("#0076a3"));
        
		TextField numberOfPassengerInput = new TextField ();
		numberOfPassengerInput.setPromptText("how many passenger(s) ?");

        date = new DatePicker();
        date.setPromptText("Depature Date");
        date.setMaxWidth(165);
        
        date2 = new DatePicker();
        date2.setPromptText("Arrival Date");
        date2.setMaxWidth(165);
        
        grid.add(flyingFrom, 0, 0);
        grid.add(comboBox, 1, 0);
        grid.add(flyingTo, 2, 0);
        grid.add(comboBox2, 3, 0);
        
        grid.add(departure, 0, 28);
        grid.add(date, 1, 28);
        grid.add(arrival, 2, 28);
        grid.add(date2, 3, 28);
        
        grid.add(departureTime, 0, 30);
        grid.add(departureTimeInput, 1, 30);
        grid.add(arrivalTime, 2, 30);
        grid.add(arrivalTimeInput, 3, 30);
        
        grid.add(flightId, 0, 32);
        grid.add(flightIdInput, 1, 32);
        grid.add(numberOfPassenger, 2, 32);
        grid.add(numberOfPassengerInput, 3, 32);
        
        

        button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
				
				int flightId = Integer.parseInt(flightIdInput.getText()); 
				String departCity = comboBox.getValue().toString();
				String arrivalCity = comboBox2.getValue().toString();
				String departDate = ((TextField)date.getEditor()).getText();
				String arrivalDate = ((TextField)date2.getEditor()).getText();
				String departTime = departureTimeInput.getText();
				String arrivalTime = arrivalTimeInput.getText();
				String maxPassengers = numberOfPassengerInput.getText();

				try {
					int i = UserAndDatabase.addFlight(flightId, departCity, arrivalCity, departDate, arrivalDate, departTime, arrivalTime, maxPassengers);
		    		if (i>0) {
		    		
		    			Alert reg = new Alert (AlertType.CONFIRMATION);

		    			reg.setTitle("Registration Sucess");
			    		reg.setContentText("Flight Added Successfully");
			    		reg.showAndWait();
			    		
			    	}
					
			    	else {
			    		Alert a1 = new Alert(AlertType.ERROR);
			    		a1.setTitle("Error");
			    		a1.setContentText("Registration Error");
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
