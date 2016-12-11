package teamProject;

	import java.sql.Connection;
	import java.sql.ResultSet;
	import javafx.application.Application;
	import javafx.beans.property.SimpleStringProperty;
	import javafx.beans.value.ObservableValue;
	import javafx.collections.FXCollections;
	import javafx.collections.ObservableList;
	import javafx.scene.Scene;
	import javafx.scene.control.TableColumn;
	import javafx.scene.control.TableColumn.CellDataFeatures;
	import javafx.scene.control.TableView;
	import javafx.stage.Stage;
	import javafx.util.Callback;

	public class AdminTableView extends Application {
		
		Stage window;
		private ObservableList<Object> data;
		private TableView<Object> tableview;
		//private String row;
		public static void main(String[] args) {
			launch(args);
		}

		//Database connection
		@SuppressWarnings("unchecked")
		public void buildData(){
			Connection con;
			
			//Select all users
			data = FXCollections.observableArrayList();
			try{
				con = DatabaseConnection.getConnection();
				String sql = "select * from admin";
			//ResultSet
				ResultSet result = con.createStatement().executeQuery(sql);
			
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
			tableview = new TableView<Object>();
			buildData();
			stage.setWidth(500);
			stage.setTitle("Airline Reservations");
			stage.setResizable(true);
			
			Scene scene = new Scene(tableview);
			stage.setScene(scene);
			stage.show();
		}
				
}
