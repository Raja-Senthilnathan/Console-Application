package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
	
	public static Map<Integer, UserDetails> userInfo = new HashMap<>();
	public static Map<Integer, FlightDetails> flight = new HashMap<>();
	public static List<PassengerDetails> passenger = new ArrayList<>();
	public static Map<Integer, List<PassengerDetails>> passengerInfo = new HashMap<>();
	
	public void customerDataBase(UserDetails userDetails) {
		
		userInfo.put(UserDetails.getUserId(), userDetails);

	}	
	
	public void flightDataBase(FlightDetails flightDetails) {
		
		flight.put(flightDetails.getFlightNumber(), flightDetails);
		
	}
	
	public void passengerList(PassengerDetails passengerDeatils) {
		
		passenger.add(passengerDeatils);
		
	}
	
	public void passengerDataBase() {
		
		passengerInfo.put(PassengerDetails.getPnrNo(), passenger);
		
	}

}
