package teamProject;

import java.time.LocalDateTime;

public class Booking {
	int bookingId;
	LocalDateTime bookingDate;
	String userName;
	int flightId;
	
	Booking(){
		
	}

	Booking(int bookingId, LocalDateTime bookingDate,String userName, int flightId){
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.userName = userName;
		this.flightId = flightId;
	}

	/**
	 * @return the bookingId
	 */
	public int getBookingId() {
		return bookingId;
	}

	/**
	 * @param bookingId the bookingId to set
	 */
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	/**
	 * @return the bookingDate
	 */
	public LocalDateTime getBookingDate() {
		return bookingDate;
	}

	/**
	 * @param bookingDate the bookingDate to set
	 */
	public void setBookingDate(LocalDateTime bookingDate) {
		this.bookingDate = bookingDate;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the flightId
	 */
	public int getFlightId() {
		return flightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

}	