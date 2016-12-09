package teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserAndDatabase {
	
	public static int save(String userName, String firstName, String lastName, String address, String city, String state, String zip, String password, String email, String SSN, String securityQuestion){
		int status=0;
		try{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user(userName,firstName,lastName, address, city, state, zip, password, email, SSN, securityQuestion) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,userName);
			ps.setString(2,firstName);
			ps.setString(3,lastName);
			ps.setString(4,address);
			ps.setString(5,city);
			ps.setString(6,state);
			ps.setString(7,zip);
			ps.setString(8,password);
			ps.setString(9,email);
			ps.setString(10,SSN);
			ps.setString(11,securityQuestion);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	
	public static boolean validate (String userName, String password){
		boolean status = false;
		
		try{
			Connection con=DatabaseConnection.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user where userName=? and password=?");
			ps.setString(1,userName);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
