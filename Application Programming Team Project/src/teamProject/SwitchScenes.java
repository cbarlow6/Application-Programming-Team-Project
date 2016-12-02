package teamProject;

//public class SwitchScenes {

//import javafx.event.ActionEvent;
import javafx.application.Application;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class SwitchScenes extends Application {
	
	Stage window;
	Scene mainMenu, loginPage, registration;
	
	Button button;
	
	public static void main(String[] args){
	launch(args);
}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		
		//Login Button
		Label label1 = new Label("Main Menu");
		Button loginbutton = new Button("Go to Login Page");
		loginbutton.setOnAction(e ->window.setScene(loginPage));
		
		//Main Menu Layout
		VBox  layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, loginbutton);
		mainMenu = new Scene(layout1, 600, 300);
		
		//Register and Main Menu Buttons
		Label label2 = new Label("Login Page");
		Button mainMenuButton = new Button("Return to Main Menu");
		Button registerButton = new Button("Register");
		mainMenuButton.setOnAction(e ->window.setScene(mainMenu));
		registerButton.setOnAction(e ->window.setScene(registration));
		
		//Login Page Layout
		StackPane layout2  = new StackPane();
		layout2.getChildren().addAll(label2, mainMenuButton, registerButton);
		loginPage = new Scene(layout2, 600, 300);
		
		
		//Registration Button
		/*Label label3 = new Label("Register");
		Button returnMainMenu = mainMenuButton;
		returnMainMenu.setOnAction(e ->window.setScene(mainMenu));
		
		//Register Page Layout
		StackPane layout3  = new StackPane();
		layout3.getChildren().addAll(label3, mainMenuButton, registerButton);
		registration = new Scene(layout2, 600, 300);*/
		
		
		
			
		window.setScene(mainMenu);
		window.setTitle("Main Menu");
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

