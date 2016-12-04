package teamProject;

import javafx.event.ActionEvent;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;

public class MainMenu extends Application {
	
	Stage window;
	Scene mainMenu, loginPage;
	
	Button button;
	
	public static void main(String[] args){
	launch(args);
}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		window = primaryStage;
		
		Label label1 = new Label("Main Menu");
		Button button1 = new Button("Go to Login Page");
		button1.setOnAction(e ->window.setScene(loginPage));
		
		//Layout1
		VBox  layout1 = new VBox(20);
		layout1.getChildren().addAll(label1, button1);
		mainMenu = new Scene(layout1, 600, 300);
		
		//Button 2
		Button button2 = new Button("Return to Main Menu");
		button2.setOnAction(e ->window.setScene(mainMenu));
		
		//Layout 2
		StackPane layout2  = new StackPane();
		layout2.getChildren().add(button2);
		loginPage = new Scene(layout2, 600, 300);
		
		
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
