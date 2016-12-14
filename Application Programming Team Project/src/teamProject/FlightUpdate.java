package teamProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class FlightUpdate {
	public static void main(String [] args){
		updateFlight();
	}
		
	public static void updateFlight(){						
		
		try{
			//Get a connection to the database
			Connection myconn = DatabaseConnection.getConnection();
			
			//Create a statement
			Statement myStmt = myconn.createStatement();
			
			//UPDATE STATEMENT
			String sql = "update flights "
					+ "set flightID = '236'"
					+ "where flightID='623'";
		
			myStmt.executeUpdate(sql);
			System.out.println("Update complete");
											
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


