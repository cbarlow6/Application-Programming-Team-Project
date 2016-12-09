package teamProject;

import java.sql.*;



public class TestRunTables {
	
	public static void main(String[] args) {
		
		try{

			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cis3270","root","coded112");
		
			Statement statement = connection.createStatement();
			
			ResultSet resultSet = statement.executeQuery("select * from user");
			
			while(resultSet.next())
				System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(5)
				 + "\t" + resultSet.getString(6) + "\t" + resultSet.getString(7) + "\t" + resultSet.getString(8) + "\t" + resultSet.getString(9)  + "\t" + resultSet.getString(10) + "\t" 
						+ resultSet.getString(11) + "\t" + resultSet.getString(12));
			connection.close();
		}
		
		catch(Exception test) {
			System.out.println("I caught an exception" + test);
		}
	}

}
