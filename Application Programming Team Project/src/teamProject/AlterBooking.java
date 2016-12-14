package teamProject;

	import java.sql.Connection;
	import java.sql.DriverManager;
	//import java.sql.ResultSet;
	import java.sql.Statement;

		public class AlterBooking {
			public static void main(String [] args){
				String url = "jdbc:mysql://localhost:3306/project";
				String user = "root";
				String password = "Mb7z!LEr2:";		
				
				try{
					//Get a connection to the database
					Connection myconn = DriverManager.getConnection(url, user, password);
					
					//Create a statement
					Statement myStmt = myconn.createStatement();
					
					//Alter statement
					
					String sql = "ALTER TABLE booking DROP COLUMN bookingId";
							
				
				myStmt.executeUpdate(sql);
				System.out.println("Insert complete");								
					
					String sql2 ="ALTER TABLE booking ADD bookingId INT UNSIGNED NOT NULL AUTO_INCREMENT,"
							+ "ADD PRIMARY KEY (bookingId)";
					
					myStmt.executeUpdate(sql2);
					System.out.println("Insert complete");
				}	
				catch (Exception ex){
					ex.printStackTrace();
				}
				
				
			}
		}

