package teamProject;

import java.time.LocalDateTime;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ComparableBooking extends Booking implements Comparable<ComparableBooking>{

	
	ComparableBooking(int bookingId, LocalDateTime bookingDate, String userName, int flightId) {
		super(bookingId, bookingDate,userName, flightId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(ComparableBooking o) {
		// TODO Auto-generated method stub
		if(getFlightId() ==(getFlightId())){
			display("Error", "Duplicate Flight Booking");
		}
		
		
		return 0;
	}

	
//class AlertBox {

		public void display(String title, String message){
			Stage window = new Stage();
			
			window.initModality(Modality.APPLICATION_MODAL);
			window.setTitle(title);
			window.setMinWidth(300);
			
			Label label = new Label();
			label.setText(message);
			Button closeButton = new Button("Close the window");
			closeButton.setOnAction(e -> window.close());
			
			VBox layout = new VBox(10);
			layout.getChildren().addAll(label, closeButton);
			layout.setAlignment(Pos.CENTER);
			
			Scene scene = new Scene(layout);
			window.setScene(scene);
			window.showAndWait();
			
			
			
		}

}
 