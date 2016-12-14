package teamProject;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;

public class FlightDelete {
	
		public static void main(String [] args){
			deleteFlight();
		}
		
		
		public static void deleteFlight(){						
			
			try{
				//Get a connection to the database
				Connection myconn = DatabaseConnection.getConnection();
				
				//Create a statement
				Statement myStmt = myconn.createStatement();
				
				//DELETE STATEMENT
				String sql = "delete from flights where flightId='623'";
				int rowAffected = myStmt.executeUpdate(sql);
				System.out.println("Rows affected " + rowAffected);
				System.out.println("Delete complete");
				
				
				//Execute SQL query
				ResultSet result = myStmt.executeQuery("select * from flights");
				
				//Process the result set
				while(result.next()){
					System.out.print(result.getString("flightId"));
					System.out.print(", ");
					System.out.print(result.getString("departCity"));
					System.out.print(" to ");
					System.out.println(result.getString("arrivalCity"));
				}
				
				
					}	
					catch (Exception ex){
						ex.printStackTrace();
					}
					
					
				}
			
			
			
		}




