package teamProject;

import java.sql.*;
public class NewCreateTable {
	
	public static void main(String[] args) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270","root","coded112");
		
		//Create a statement
		Statement myStmt = connection.createStatement();
		
		//Drop table
		
		//String dropCustomer = "DROP TABLE CUSTOMER";
		//String dropAdmin= "DROP TABLE ADMIN";
		//String dropBooking= "DROP TABLE BOOKING";
		//String dropUser = "DROP TABLE USER";
		//String dropFlights = "DROP TABLE FLIGHTS";
		
		//myStmt.executeUpdate(dropAdmin);
		//myStmt.executeUpdate(dropBooking);
		//myStmt.executeUpdate(dropFlights);
		//myStmt.executeUpdate(dropUser);
		//myStmt.executeUpdate(dropCustomer);
		
		//Create user table
		String USER = "CREATE TABLE USER (userName VARCHAR(30) NOT NULL PRIMARY KEY, firstName VARCHAR(30) NOT NULL,"
				+"lastName VARCHAR(30) NOT NULL, address VARCHAR(30) NOT NULL, city VARCHAR(30) NOT NULL,"
				+"state VARCHAR(30) NOT NULL, zip VARCHAR(30) NOT NULL, password VARCHAR(30) NOT NULL,"
				+ "email VARCHAR(30) NOT NULL, SSN VARCHAR(30) NOT NULL, securityQuestion VARCHAR(30) NOT NULL,"
				+ "user_isAdmin VARCHAR(10) NOT NULL) ENGINE=INNODB";
		
		myStmt.executeUpdate(USER);
		System.out.println("User table created");
				
		//Create customer table
		/*String CUSTOMER = "CREATE TABLE CUSTOMER(cust_userName VARCHAR(30) NOT NULL, user_userName VARCHAR(30) NOT NULL, customerLevel VARCHAR(30) NOT NULL,"
				+"PRIMARY KEY (cust_userName), INDEX(user_userName),"
				+"FOREIGN KEY (user_userName) REFERENCES USER(userName))ENGINE=INNODB";
		
		myStmt.executeUpdate(CUSTOMER);
		System.out.println("Customer table created");*/
				
		//Create admin table
		String ADMIN = "CREATE TABLE ADMIN(admin_userName VARCHAR(30) NOT NULL, user_userName VARCHAR(30) NOT NULL, privilegeLevel INT NOT NULL,"
				+ "PRIMARY KEY(admin_userName), INDEX (user_userName),"
				+ "FOREIGN KEY (user_userName) REFERENCES USER(userName)) ENGINE=INNODB";
		
		myStmt.executeUpdate(ADMIN);
		System.out.println("Admin table created") ;
			
		//Create flights table
		String FLIGHTS = "CREATE TABLE FLIGHTS(flightId INTEGER PRIMARY KEY, departCity VARCHAR(50) NOT NULL,"
				+"arrivalCity VARCHAR(50) NOT NULL, departDate DATE NOT NULL, arrivalDate DATE NOT NULL,"
				+"departTime TIME NOT NULL, arrivalTime TIME NOT NULL, maxPassengers INTEGER NOT NULL)";
				
				myStmt.executeUpdate(FLIGHTS);
				System.out.println("Flights table created");
		
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
