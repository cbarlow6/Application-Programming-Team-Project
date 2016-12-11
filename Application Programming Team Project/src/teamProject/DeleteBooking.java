package teamProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DeleteBooking {
	public static void main(String [] args){
		String url = "jdbc:mysql://localhost:3306/project";
		String user = "root";
		String password = "Mb7z!LEr2:";		
				
				try{
					//Get a connection to the database
					Connection myconn = DriverManager.getConnection(url, user, password);
					
					//Create a statement
					Statement myStmt = myconn.createStatement();
					
					
					//DELETE STATEMENT
					String sql = "delete from booking where userName ='wransom' and flightId = '745'";
					int rowAffected = myStmt.executeUpdate(sql);
					System.out.println("Rows affected " + rowAffected);
					System.out.println("Delete complete");
					
					
					//Execute SQL query
					ResultSet result = myStmt.executeQuery("select * from booking");
					
					//Process the result set
					while(result.next()){
						System.out.print(result.getString("flightId"));
						System.out.print(", ");
						System.out.println(result.getString("userName"));
					}
													
					
				}	
				catch (Exception ex){
					ex.printStackTrace();
				}
				
				
			}
		}

