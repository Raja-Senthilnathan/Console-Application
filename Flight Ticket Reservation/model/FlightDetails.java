package model;

import java.util.List;

public class FlightDetails {
	
	private int flightNumber;
	private String flightName;
	private String departureTime;
 	private String arrivalTime;
	private List<String> flightRoutes;
	private int totalSeats;
    private double fare;
    
    public FlightDetails(int flightNumber, String flightName, String departureTime, String arrivalTime, List<String> flightRoutes, int totalSeats, double fare) {
    	
    	this.flightNumber = flightNumber;
    	this.flightName = flightName;
    	this.departureTime = departureTime;
     	this.arrivalTime = arrivalTime;
    	this.flightRoutes = flightRoutes;
    	this.totalSeats = totalSeats;
        this.fare = fare;
    	
    }

	public int getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public List<String> getFlightRoutes() {
		return flightRoutes;
	}

	public void setFlightRoutes(List<String> flightRoutes) {
		this.flightRoutes = flightRoutes;
	}

	public int getTotalSeats() {
		return totalSeats;
	}

	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}

	public double getFare() {
		return fare;
	}

	public void setFare(double fare) {
		this.fare = fare;
	}

}
