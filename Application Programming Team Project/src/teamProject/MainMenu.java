package teamProject;

//import javafx.event.ActionEvent;
import javafx.application.Application;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
//import javafx.scene.layout.VBox;
//import javafx.scene.control.Label;

public class MainMenu extends Application {
	
	Stage window;
	//Scene mainMenu, loginPage;
	
	Button button;
	
	public static void main(String[] args){
	launch(args);
}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		window.setTitle("Main Menu");
		
		button = new Button("Click me");
		button.setOnAction(e -> AlertBox.display("Register", "Registration Successful"));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		Scene mainMenu = new Scene(layout, 300, 250);
		
		window.setScene(mainMenu);
		window.show();
		
		
		
		/*primaryStage.setTitle("Flight");
		
		button = new Button();
		button.setText("Click me");
		button.setOnAction(e -> System.out.println("clicked"));	
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Scene scene = new Scene(layout, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.show();*/
		
		
		
	}




	
}
