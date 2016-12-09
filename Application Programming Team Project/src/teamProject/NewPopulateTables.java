package teamProject;

import java.sql.*;

public class NewPopulateTables {

	public static void main(String [] args){	
		
		try{
			//Get a connection to the database
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270","root","coded112");
			
			//Create a statement
			Statement myStmt = connection.createStatement();
			
			
			//User insert statement
			String sqlUser = "insert into user"
					+ "(userName, firstName,lastName, address, city, state, zip,"
					+ "password, email, SSN, securityQuestion, user_isAdmin)"
					+"values "
					+ "('dwaters37', 'DENNY', 'WATERS', '1465 SPENARD ROAD','South Lincoln','VT','05443',"
					+ "'ParTyAniMal','dwaters37@me.me', '564-453-0000', 'London', 'No'),"
					+"('ghubbard', 'GISELE', 'HUBBARD', '984 WRANGLERS WAY','ONLEY','VA','23418',"
					+ "'MOONbeam','ghubbard73@email.com', '433-11-1111', 'Summer vacation', 'No'),"	
					+"('wransom', 'WYNONA', 'RANSOM', '1757 WEST 2ND AVENUE', 'Rockhill Furnace', 'PA', '17249',"
					+"'j0BhUnt88', 'wransom@yahoo.com', '087-543-9999', 'Road Trip', 'Yes'),"
					+"('jonash', 'JONAS', 'HOSKINS', '74 WHISPERING BIRCH DRIVE','Boulevard', 'NY', '10474',"
					+"'hjonas1974', 'jonash88@email.com', '999-67-5432', 'Beach House', 'No'),"
					+ "('quinnhurd', 'QUINN', 'HURD', '377 BROOKWAY CIRCLE', 'Freetown Corners', 'NY', '13803',"
					+"'87yEs7gO', 'goquinn@email.com','222-88-6547', 'New York', 'Yes')";
			
			
			myStmt.executeUpdate(sqlUser);
			System.out.println("User insert complete");
				
			//Customer insert statement
			/*String sqlCustomer = "insert into customer"
					+ "(cust_userName, user_userName, customerLevel)"
					+"values ('dwaters37','dwaters37', 'Gold'),"
					+"('ghubbard','ghubbard', 'Gold'),"
					+"('wransom','wransom','Silver'),"
					+"('jonash','jonash', 'Bronze'),"
					+"('quinnhurd','quinnhurd', 'Silver')";
			
			myStmt.executeUpdate(sqlCustomer);
			System.out.println("Customer insert complete");*/
			
			//Admin insert statement
			String sqlAdmin = "insert into admin"
					+ "(admin_userName, user_userName, privilegeLevel)"
					+"VALUES ('wransom','wransom', 5),"
					+"('quinnhurd','quinnhurd', 3)";
			
			myStmt.executeUpdate(sqlAdmin);
			System.out.println("Admin insert complete");
			
			// Flights insert statements
			String sqlFlights = "insert into flights"
					+ "(flightId, departCity, arrivalCity,departDate, arrivalDate, departTime, arrivalTime, maxPassengers)"
					+"VALUES (534,'Miami, FL', 'New York, NY', '2016-12-15', '2016-12-15', '08:30:00', '10:00:00', 100),"
					+"(745, 'Atlanta, GA', 'Miami, FL', '2016-12-17', '2016-12-17', '14:45:00', '16:00:00', 150),"
					+"(414, 'New York, NY', 'Atlanta, GA', '2016-12-16', '2016-12-16', '12:00:00', '14:05:00', 90)";
			
			myStmt.executeUpdate(sqlFlights);
			System.out.println("Flight insert complete");
			
			// Booking insert statements
				String sqlBooking = "insert into booking"
						+ "(bookingId, bookingDate, username, flightId)"
						+"VALUES (1045,'2016-11-30', 'dwaters37', '534'),"
						+"(1044, '2016-12-01', 'jonash', '414')";
				
				myStmt.executeUpdate(sqlBooking);
				System.out.println("Booking insert complete");
		
		}	
		catch (Exception ex){
			ex.printStackTrace();
		}
		
		
	}
}
