package controller;

import model.DataBase;
import model.FlightDetails;

public class AdminController {
	
	DataBase dataBase;
	
	public boolean adminLogIn(int pin) {
		
		int logInPin = 1357;
		return logInPin==pin ? true : false;
		
	}

	public void addFlightDetails(FlightDetails flightDetails) {
		
		dataBase = new DataBase();
		dataBase.flightDataBase(flightDetails);
		
	}

	public void removeFlightDetails(int flightNumber) {
		
		DataBase.flight.remove(flightNumber);
		
	}
	
}
