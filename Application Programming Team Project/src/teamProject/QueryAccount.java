package teamProject;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.Statement;

public class QueryAccount {
	public static void main(String [] args){
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "Mb7z!LEr2:";		
				
		try{
			//Get a connection to the database
			Connection myconn = DriverManager.getConnection(url, user, password);
			
			//Create a statement
			Statement myStmt = myconn.createStatement();
				
			//Execute SQL query
			ResultSet result = myStmt.executeQuery("select * from booking inner join (user, flights)"
					+"on (user.userName = booking.userName AND flights.flightId = booking.flightId)");
					
			
			//Process the result set
			while(result.next()){
				System.out.println("Flight#   UserName   Passenger Name");
				System.out.print(result.getString("booking.flightId"));
				System.out.print("       ");
				System.out.print(result.getString("booking.userName"));
				System.out.print("     ");
				System.out.print(result.getString("firstName"));
				System.out.print(" ");
				System.out.println(result.getString("lastName"));
				System.out.println("------------------------------------");
				System.out.println("Depart Date/Time   Arrival Date/Time");
				System.out.print(result.getString("departDate"));
				System.out.print("              ");
				System.out.println(result.getString("arrivalDate"));
				System.out.print(result.getString("departTime"));
				System.out.print("                ");
				System.out.println(result.getString("arrivalTime"));
				System.out.println();
			}
											
			
		}	
		catch (Exception ex){
			ex.printStackTrace();
		}
		
		
	}
}

