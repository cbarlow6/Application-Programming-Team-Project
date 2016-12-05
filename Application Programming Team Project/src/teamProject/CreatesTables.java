package teamProject;
import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.ResultSet;
import java.sql.Statement;
//import java.time.LocalDate;
//import java.time.LocalTime;

public class CreatesTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "Mb7z!LEr2:";		
		
		try{
		//Get a connection to the database
		Connection myconn = DriverManager.getConnection(url, user, password);
		
		//Create a statement
		Statement myStmt = myconn.createStatement();
		
		//Drop table
		//String DROP = "DROP TABLE FLIGHTS";
		//myStmt.executeUpdate(DROP);
		
		//Create user table
				/*String USER = "CREATE TABLE USER (userName VARCHAR(30) PRIMARY KEY, firstName VARCHAR(30) NOT NULL,"
						+"lastName VARCHAR(30) NOT NULL, address VARCHAR(30) NOT NULL, city VARCHAR(30) NOT NULL,"
						+"zip VARCHAR(30) NOT NULL, state VARCHAR(30) NOT NULL, password VARCHAR(30) NOT NULL,"
						+ "email VARCHAR(30) NOT NULL, SSN VARCHAR(30) NOT NULL, securityQuestion VARCHAR(30) NOT NULL,"
						+ "userType VARCHAR(30) NOT NULL)";
				
				myStmt.executeUpdate(USER);
				System.out.println("User table created");*/
				
		//Create customer table
				/*String CUSTOMER = "CREATE TABLE CUSTOMER (userName VARCHAR(30) PRIMARY KEY, customerLevel VARCHAR(30) NOT NULL,"
						+ "FOREIGN KEY(userName) REFERENCES USER(userName))";
				
				myStmt.executeUpdate(CUSTOMER);
				System.out.println("Customer table created");
				
		//Create admin table
		String ADMIN = "CREATE TABLE ADMIN(userName VARCHAR(30) PRIMARY KEY, privilegeLevel INT NOT NULL,"
				+ "FOREIGN KEY(userName) REFERENCES USER(userName))";
		
		myStmt.executeUpdate(ADMIN);
		System.out.println("Admin table created");
			
		//Create flights table
		String FLIGHTS = "CREATE TABLE FLIGHTS(flightId INTEGER PRIMARY KEY, departureCity VARCHAR(50) NOT NULL,"
				+"arrivalCity VARCHAR(50) NOT NULL, departureDate DATETIME NOT NULL, arrivalDate DATETIME NOT NULL,"
				+"departureTime DATETIME NOT NULL, arrivalTime DATETIME NOT NULL, numberOfPassengers INTEGER NOT NULL)";
				
				myStmt.executeUpdate(FLIGHTS);
				System.out.println("Flights table created");*/		
		
		//Create booking table
			String BOOKING = "CREATE TABLE BOOKING(bookingId INT PRIMARY KEY,"
					+"bookingDate DATETIME NOT NULL, userName VARCHAR(30) NOT NULL, flightId INT NOT NULL,"
					+"FOREIGN KEY(userName) REFERENCES USER(userName), "
					+ "FOREIGN KEY(flightId) REFERENCES FLIGHTS(flightId))";
		
				myStmt.executeUpdate(BOOKING);
				System.out.println("BOOKING table created");
		
	}
	
	catch (Exception ex){
		ex.printStackTrace();
	}
	
	
}

	}


