package teamProject;
import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;

public class FlightAdd {
	public static void main(String [] args){

		addFlight();
	}
	
	
	public static void addFlight(){						
		//String url = "jdbc:mysql://localhost:3306/project";
		//String user = "root";
		//String password = "Mb7z!LEr2:";		
		
		
		try{
			//Get a connection to the database
			Connection myconn = DatabaseConnection.getConnection();
			
			//Create a statement
			Statement myStmt = myconn.createStatement();
			
			// Flights insert statements
			String sqlFlights = "insert into flights"
					+ "(flightId, departCity, arrivalCity,departDate, arrivalDate, departTime, arrivalTime, maxPassengers)"
					+"VALUES (623,'Los Angeles, CA', 'Atlanta, GA', '2016-12-30', '2016-12-30', '12:30:00', '16:30:00', 100)";
					//+"(745, 'Atlanta, GA', 'Miami, FL', '2016-12-17', '2016-12-17', '14:45:00', '16:00:00', 150),"
					//+"(414, 'New York, NY', 'Atlanta, GA', '2016-12-16', '2016-12-16', '12:00:00', '14:05:00', 90)";
			
			myStmt.executeUpdate(sqlFlights);
			System.out.println("Flight insert complete");
			
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




