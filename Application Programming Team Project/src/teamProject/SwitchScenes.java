package teamProject;

//public class SwitchScenes {

//import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
//import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class SwitchScenes extends Application {
	
	//private static final Pos CENTER_LEFT = null;
	Stage window;
	Scene mainMenu, loginPage, register, customer, admin;
	
	Button button;
	Button loginButton = new Button("Go to Login Page");
	Button mainMenuButton = new Button("Return to Main Menu");
	Button registerButton = new Button("Register");
	Button customerButton = new Button("Customer");
	Button adminButton = new Button("Admin");
	Button returnMain = new Button("Return to Main Menu");
	Button returnMain2 = new Button("Return to Main Menu");
	Button returnMain3 = new Button("Return to Main Menu");
	
	
	public static void main(String[] args){
	launch(args);
}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		
		GridPane newgrid = new GridPane ();
		newgrid.setPadding(new Insets (10, 10, 10, 10));
		
		//newgrid.setConstraints(adminButton, 0, 8);
		
		//Login Button
		Label mainMenuLabel = new Label("Main Menu");
		//Button loginButton = new Button("Go to Login Page");
		loginButton.setOnAction(e ->window.setScene(loginPage));
		
		//Main Menu Layout
		VBox  mainMenuLayout = new VBox(20);
		mainMenuLayout.getChildren().addAll(mainMenuLabel, loginButton);
		mainMenu = new Scene(mainMenuLayout, 600, 300);
		
		//Return to Main Menu Button
		//Label label1 = new Label("Main Menu");
		//Button returnMain = new Button("Return to Main Menu");
		returnMain.setOnAction(e ->window.setScene(mainMenu));
		//Button returnMain2 = new Button("Return to Main Menu");
		returnMain2.setOnAction(e ->window.setScene(mainMenu));
		//Button returnMain3 = new Button("Return to Main Menu");
		returnMain3.setOnAction(e ->window.setScene(mainMenu));
				
		//Registration Page Layout
		VBox  registerLayout = new VBox(20);
		Label registerLabel = new Label("Register");
		registerLayout.getChildren().addAll(registerLabel, returnMain);
		register = new Scene(registerLayout, 600, 300);
		returnMain.setOnAction(e ->window.setScene(mainMenu));
		
		//Customer Page Layout
		VBox  customerLayout = new VBox(20);
		Label customerLabel = new Label("Customer");
		customerLayout.getChildren().addAll(customerLabel, returnMain2);
		customer = new Scene(customerLayout, 600, 300);
		returnMain2.setOnAction(e ->window.setScene(mainMenu));
				
		//Admin Page Layout
		VBox adminLayout = new VBox(20);
		Label adminLabel = new Label("Admin");
		adminLayout.getChildren().addAll(adminLabel, returnMain3);
		admin = new Scene(adminLayout, 600, 300);
		returnMain3.setOnAction(e ->window.setScene(mainMenu));
		
		
		//Register and Main Menu Buttons
		Label loginLabel = new Label("Login Page");
		//Button mainMenuButton = new Button("Return to Main Menu");
		//Button registerButton = new Button("Register");
		mainMenuButton.setOnAction(e ->window.setScene(mainMenu));
		registerButton.setOnAction(e ->window.setScene(register));
		customerButton.setOnAction(e ->window.setScene(customer));
		adminButton.setOnAction(e ->window.setScene(admin));
		
		
		
		//Login Page Layout
		StackPane loginLayout  = new StackPane();
		loginLayout.getChildren().addAll(loginLabel, mainMenuButton, registerButton, customerButton, adminButton);
		StackPane.setAlignment(loginLabel, Pos.TOP_CENTER);
		StackPane.setAlignment(mainMenuButton, Pos.TOP_RIGHT);
		StackPane.setAlignment(registerButton, Pos.CENTER);
		StackPane.setAlignment(customerButton, Pos.CENTER_RIGHT);
		StackPane.setAlignment(adminButton, Pos.CENTER_LEFT);
		loginPage = new Scene(loginLayout, 600, 300);
			
		window.setScene(mainMenu);
		window.setTitle("Flight Reservation System");
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

