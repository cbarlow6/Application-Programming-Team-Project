package teamProject;

import java.time.*;

public class Flight {
	private int flightId;
	private String departCity;
	private String arrivalCity;
	private LocalDate departDate;
	private LocalDate arrivalDate;
	private LocalTime departTime;
	private LocalTime arrivalTime;
	private int numberOfPassengers;
	
	public Flight(){
		
	}
	public Flight(int flightId){
		this.setFlightId(flightId);	
	}
	
	/**
	 * @return the departureCity
	 */
	public String getDepartCity() {
		return departCity;
	}
	/**
	 * @param departureCity the departureCity to set
	 */
	public void setDepartCity(String departCity) {
		this.departCity = departCity;
	}
	/**
	 * @return the arrivalCity
	 */
	public String getArrivalCity() {
		return arrivalCity;
	}
	/**
	 * @param arrivalCity the arrivalCity to set
	 */
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	/**
	 * @return the numberOfPassengers
	 */
	public int getNumberOfPassengers() {
		return numberOfPassengers;
	}
	/**
	 * @param numberOfPassengers the numberOfPassengers to set
	 */
	public void setNumberOfPassengers(int numberOfPassengers) {
		this.numberOfPassengers = numberOfPassengers;
	}
	/**
	 * @return the departureDate
	 */
	public LocalDate getDepartDate() {
		return departDate;
	}
	/**
	 * @param departureDate the departureDate to set
	 */
	public void setDepartDate(LocalDate departDate) {
		this.departDate = departDate;
	}
	/**
	 * @return the arrivalDate
	 */
	public LocalDate getArrivalDate() {
		return arrivalDate;
	}
	/**
	 * @param arrivalDate the arrivalDate to set
	 */
	public void setArrivalDate(LocalDate arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
	/**
	 * @return the departureTime
	 */
	public LocalTime getDepartTime() {
		return departTime;
	}
	/**
	 * @param departureTime the departureTime to set
	 */
	public void setDepartTime(LocalTime departTime) {
		this.departTime = departTime;
	}
	/**
	 * @return the arrivalTime
	 */
	public LocalTime getArrivalTime() {
		return arrivalTime;
	}
	/**
	 * @param arrivalTime the arrivalTime to set
	 */
	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
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
