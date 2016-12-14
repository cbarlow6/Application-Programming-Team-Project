package teamProject;

	import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
	import javafx.application.Application;
	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.value.ObservableValue;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableColumn.CellDataFeatures;
	import javafx.scene.control.TableView;
	import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Callback;

	public class CustomerFlightView extends Application {
		
		Stage window;
		private ObservableList<Object> data;
		private TableView<Object> tableview;
		private String arrivalCity;
		private String departCity;
		//private String row;
		public static void main(String[] args) {
			launch(args);
		}
		
		//Database connection
		@SuppressWarnings("unchecked")
		public void buildData(String departCity, String arrivalCity){
			Connection con;
			
			//Select all users
			data = FXCollections.observableArrayList();
			try{
				con = DatabaseConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("select * from flights where departCity=? and arrivalCity=?");
			//ResultSet
				ps.setString(1, departCity);
				ps.setString(2, arrivalCity);
				ResultSet result = ps.executeQuery();
			
			//Add Table Column
			for(int i = 0; i < result.getMetaData().getColumnCount(); i++){
				final int j = i;
				TableColumn col= new TableColumn<>(result.getMetaData().getColumnName(i+1));
				
				col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList<String>,String>,ObservableValue<String>>(){
					public ObservableValue<String> call(CellDataFeatures<ObservableList<String>,String> param) {
						return new SimpleStringProperty(param.getValue().get(j).toString());
					}
				});
				tableview.getColumns().addAll(col);
				System.out.println("Column ["+i+"]");
			}
			while(result.next()){
				ObservableList<Object> row = FXCollections.observableArrayList();
				for(int i = 1; i <=result.getMetaData().getColumnCount(); i++){
					
				row.add(result.getString(i));
				}
			
			System.out.println("Row [1] added "+row);
			data.add(row);
			}
			tableview.setItems(data);
			}catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error Building Data");
			}
			
			
		}
		
		
		@Override
		public void start(Stage stage) throws Exception {
			
			String arrivalCity = this.arrivalCity;
			String departCity =  this.departCity;
			tableview = new TableView<Object>();
			buildData(  departCity, arrivalCity);
			stage.setWidth(650);
			stage.setHeight(450);
			stage.setTitle("Airline Reservations");
			stage.setResizable(true);
			
			Scene scene = new Scene(tableview);
			tableview.setStyle("-fx-background-color: lightskyblue");
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
			
			
			
		}
		
		
		
}