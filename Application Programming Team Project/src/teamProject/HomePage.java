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

public class HomePage extends Application {
	
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


//	public void runAnotherApp(Class<? extends Application> BookingPage) throws Exception {
//		Application app2 = BookingPage.newInstance();
//		Stage anotherStage = new Stage();
//		app2.start(anotherStage);
//	
//	}
//	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;

		
		GridPane grid = new GridPane();
		grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        
		Label customerLogin = new Label("Customer Login");
		customerLogin.setFont(new Font("Cambria", 25));
		customerLogin.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(customerLogin, 1, 0);	


		
		Label nameLabel = new Label("Username:");
		nameLabel.setFont(new Font("Cambria", 15));
		nameLabel.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(nameLabel, 0, 5);
	
		TextField nameInput = new TextField ();
		nameInput.setPromptText("username");
		GridPane.setConstraints(nameInput, 1, 5);
	
		
		Label passLabel = new Label("Password:");
		passLabel.setFont(new Font("Cambria", 15));
		passLabel.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(passLabel, 0, 6);
		
		TextField passInput = new TextField ();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 6);
		
	    Button loginButton = new Button ("Login");
	    GridPane.setConstraints(loginButton, 1, 8);
	   
	    
	    	loginButton.setOnAction(new EventHandler<ActionEvent> () {
				@Override
				public void handle(ActionEvent event) {
			    	String username = nameInput.getText();
			    	String password = passInput.getText();
			    	
			    	try {
			    		if (UserAndDatabase.validate(username, password)){

			    			System.out.println("Match!");
				    		window.close();
				    		BookingPage bp = new BookingPage();
				    		bp.start(primaryStage);
				    	}
						
				    	else {
				    		//JFrame frame = new JFrame();
				    		Alert alert = new Alert(AlertType.WARNING);
				    		alert.setTitle("Invalid password");
				    		alert.showAndWait();
				    		nameInput.setText("");
							passInput.setText("");
				    	}
			    		
			    		//BookingPage.main(new String [] {});
			    		
			    //		BookingPage bp = new BookingPage();
			    //		bp.start(primaryStage);
			    	}
			    	
			    	catch (Exception e) {
			    		System.out.println(e);
			    	}
			    	
				}
		    	
		    }
		    		    		
		    		);
	    
	    
	    
	    Button notRegistered = new Button ("Not registered?");
	    GridPane.setConstraints(notRegistered, 2, 8);
	    
	    Button forgotPassword = new Button ("Forgot your password?");
	    GridPane.setConstraints(forgotPassword, 3, 8);
	    
		
		Label adminLogin = new Label("Admin Login");
		adminLogin.setFont(new Font("Cambria", 25));
		adminLogin.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(adminLogin, 1, 14);	
		
		
		Label adminUsername = new Label("Username:");
		adminUsername.setFont(new Font("Cambria", 15));
		adminUsername.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(adminUsername, 0, 19);
	
		TextField adminUsernameInput = new TextField ();
		adminUsernameInput.setPromptText("username");
		GridPane.setConstraints(adminUsernameInput, 1, 19);
	
		
		Label adminPassword = new Label("Password:");
		adminPassword.setFont(new Font("Cambria", 15));
		adminPassword.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(adminPassword, 0, 20);
		
		TextField adminPasswordInput = new TextField ();
		adminPasswordInput.setPromptText("password");
		GridPane.setConstraints(adminPasswordInput, 1, 20);
		
	    Button adminLoginButton = new Button ("Login");
	    GridPane.setConstraints(adminLoginButton, 1, 22);

	    grid.getChildren().addAll(customerLogin, nameLabel, nameInput, passLabel, passInput, loginButton, 
	    notRegistered, forgotPassword, adminLogin, adminUsername, adminUsernameInput, adminPassword, 
	    adminPasswordInput, adminLoginButton);
	    
	    grid.setStyle("-fx-background-color: lightskyblue");
	    scene = new Scene(grid, 650, 450);
	    
	    GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);

	    notRegistered.setOnAction(e -> window.setScene(scene2));
        
		Label firstName = new Label("First Name:");
		firstName.setFont(new Font("Cambria", 15));
		firstName.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(firstName, 0, 0);
		
		TextField firstNameInput = new TextField ();
		firstNameInput.setPromptText("first name");
		GridPane.setConstraints(firstNameInput, 1, 0);
		
		Label lastName = new Label("Last Name:");
		lastName.setFont(new Font("Cambria", 15));
		lastName.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(lastName, 0, 1);
		
		TextField lastNameInput = new TextField ();
		lastNameInput.setPromptText("last name");
		GridPane.setConstraints(lastNameInput, 1, 1);
		
		Label address = new Label("Street Address:");
		address.setFont(new Font("Cambria", 15));
		address.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(address, 0, 2);

		
		TextField addressInput = new TextField ();
		addressInput.setPromptText("street address");
		GridPane.setConstraints(addressInput, 1, 2);

		
		Label city = new Label("City:");
		city.setFont(new Font("Cambria", 15));
		city.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(city, 0, 3);

		
		TextField cityInput = new TextField ();
		cityInput.setPromptText("city");
		GridPane.setConstraints(cityInput, 1, 3);
		
		Label state = new Label("State:");
		state.setFont(new Font("Cambria", 15));
		state.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(state, 0, 4);

		
		TextField stateInput = new TextField ();
		stateInput.setPromptText("e.g. MN");
		GridPane.setConstraints(stateInput, 1, 4);
		
		
		Label zipcode = new Label("Zipcode:");
		zipcode.setFont(new Font("Cambria", 15));
		zipcode.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(zipcode, 0, 5);

		
		TextField zipcodeInput = new TextField ();
		zipcodeInput.setPromptText("zipcode");
		GridPane.setConstraints(zipcodeInput, 1, 5);
		
		Label userName = new Label("Username:");
		userName.setFont(new Font("Cambria", 15));
		userName.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(userName, 0, 6);

		
		TextField userNameInput = new TextField ();
		userNameInput.setPromptText("username");
		GridPane.setConstraints(userNameInput, 1, 6);
		
		Label password = new Label("Password:");
		password.setFont(new Font("Cambria", 15));
		password.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(password, 0, 7);

		
		TextField passwordInput = new TextField ();
		passwordInput.setPromptText("password");
		GridPane.setConstraints(passwordInput, 1, 7);
		
		Label emailAddress = new Label("Email:");
		emailAddress.setFont(new Font("Cambria", 15));
		emailAddress.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(emailAddress, 0, 8);

		
		TextField emailAddressInput = new TextField ();
		emailAddressInput.setPromptText("email address");
		GridPane.setConstraints(emailAddressInput, 1, 8);
		
		Label ssn = new Label("SSN:");
		ssn.setFont(new Font("Cambria", 15));
		ssn.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(ssn, 0, 9);

		
		TextField ssnInput = new TextField ();
		ssnInput.setPromptText("ssn");
		GridPane.setConstraints(ssnInput, 1, 9);
		
		Label securityQuestion = new Label("Security Question:");
		securityQuestion.setFont(new Font("Cambria", 15));
		securityQuestion.setTextFill(Color.web("#0076a3"));
		GridPane.setConstraints(securityQuestion, 0, 10);

		
		TextField securityQuestionInput = new TextField ();
		securityQuestionInput.setPromptText("security question");
		GridPane.setConstraints(securityQuestionInput, 1, 10);
		
		Button submit = new Button ("Submit");
	    GridPane.setConstraints(submit, 1, 11);
	    
	    Button returnToMenu = new Button ("Login");
	    GridPane.setConstraints(returnToMenu, 2, 11);
	    returnToMenu.setOnAction(e -> window.setScene(scene));
	    
		grid2.getChildren().addAll(firstName, firstNameInput, lastName, lastNameInput, address, addressInput, city, cityInput,  state, stateInput, zipcode, zipcodeInput, userName, userNameInput, password, passwordInput, emailAddress, emailAddressInput, ssn, ssnInput, securityQuestion, securityQuestionInput, submit, returnToMenu);

		grid2.setStyle("-fx-background-color: lightskyblue");
	     scene2 = new Scene(grid2, 650, 450);
	     
	     
		    GridPane grid3 = new GridPane();
			grid3.setPadding(new Insets(10, 10, 10, 10));
	        grid3.setVgap(8);
	        grid3.setHgap(10);

	        forgotPassword.setOnAction(e -> window.setScene(scene3));
	        
	        Label forgotUsername = new Label("Username:");
	        forgotUsername.setFont(new Font("Cambria", 15));
	        forgotUsername.setTextFill(Color.web("#0076a3"));
			GridPane.setConstraints(forgotUsername, 0, 0);
			
			TextField forgotUsernameInput = new TextField ();
			forgotUsernameInput.setPromptText("username");
			GridPane.setConstraints(forgotUsernameInput, 1, 0);
			
			Label retrieveSecurityQuestion = new Label("Security Question:");
			retrieveSecurityQuestion.setFont(new Font("Cambria", 15));
			retrieveSecurityQuestion.setTextFill(Color.web("#0076a3"));
			GridPane.setConstraints(retrieveSecurityQuestion, 0, 1);
			
			TextField retrieveSecurityQuestionInput = new TextField ();
			retrieveSecurityQuestionInput.setPromptText("security question");
			GridPane.setConstraints(retrieveSecurityQuestionInput, 1, 1);
	        	     
			Button retrievePassword = new Button ("Retrieve Password");
		    GridPane.setConstraints(retrievePassword, 1, 3);
		    
		    Button returnToLogin = new Button ("Return to Login");
		    GridPane.setConstraints(returnToLogin, 2, 3);
		    returnToLogin.setOnAction(e -> window.setScene(scene));
		    
		    grid3.getChildren().addAll(forgotUsername, forgotUsernameInput, retrieveSecurityQuestion, 
		    		retrieveSecurityQuestionInput, retrievePassword, returnToLogin);
		    
		    grid3.setStyle("-fx-background-color: lightskyblue");
		    scene3 = new Scene(grid3, 650, 450);
	     
		    window.setScene(scene);
			window.setTitle("Airline Reservation System");
		    window.show();
	}
	
	

		
	

}
