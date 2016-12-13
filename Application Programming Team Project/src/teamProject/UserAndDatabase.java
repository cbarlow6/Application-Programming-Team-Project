package teamProject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserAndDatabase {

	public static int save(String userName, String firstName, String lastName, String address, String city,
			String state, String zip, String password, String email, String SSN, String securityQuestion) {
		int status = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into user(userName,firstName,lastName, address, city, state, zip, password, email, SSN, securityQuestion) values(?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, userName);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, address);
			ps.setString(5, city);
			ps.setString(6, state);
			ps.setString(7, zip);
			ps.setString(8, password);
			ps.setString(9, email);
			ps.setString(10, SSN);
			ps.setString(11, securityQuestion);
			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static boolean validate(String userName, String password) {
		boolean status = false;

		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where userName=? and password=?");
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

	public static String forgotPassword(String userName, String securityQuestion) {

		String pass = "";

		try {

			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where userName=? and securityQuestion=?");
			ps.setString(1, userName);
			ps.setString(2, securityQuestion);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Object o = rs.getString(8);
				pass = (String) o;
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}

		return pass;
	}
	
	public static int addFlight(int flightId, String departCity, String arrivalCity, String departDate, String arrivalDate, String departTime, String arrivalTime, String maxPassengers) {
		int status = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into flights(flightId, departCity, arrivalCity, departDate, arrivalDate, departTime, arrivalTime, maxPassengers) values(?,?,?,?,?,?,?,?)");
			ps.setInt(1, flightId);
			ps.setString(2, departCity);
			ps.setString(3, arrivalCity);
			ps.setString(4, departDate);
			ps.setString(5, arrivalDate);
			ps.setString(6, departTime);
			ps.setString(7, arrivalTime);
			ps.setString(8, maxPassengers);

			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public static boolean validateFlightId(int flightId) {
		boolean status = false;

		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from flights where flightId = ?");
			ps.setInt(1, flightId);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static boolean validateUsername(String userName) {
		boolean status = false;

		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from user where userName = ?");
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int addBooking(int bookingId, String bookingDate, String userName, int flightId) {
		int status = 0;
		try {
			Connection con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(
					"insert into booking(bookingId, bookingDate, userName, flightId) values(?,?,?,?)");
			ps.setInt(1, bookingId);
			ps.setString(2, bookingDate);
			ps.setString(3, userName);
			ps.setInt(4, flightId);

			status = ps.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
}
