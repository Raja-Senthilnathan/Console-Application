package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import model.UserDetails;
import model.DataBase;
import model.FlightDetails;
import model.PassengerDetails;

public class UserController {
	
    DataBase dataBase;
	
	public boolean userlogInCheck(int userId, String password) {
		
		if(DataBase.userInfo.containsKey(userId)) {
			if(DataBase.userInfo.get(userId).getPassword().equals(password)){
				return true;
			}
		}
	return false;	
	}
	
	public void userSignupUpdate(UserDetails userDetails) {
		
		dataBase = new DataBase();
		dataBase.customerDataBase(userDetails);
		
	}
	
	public List<Integer> flightRoutes(String from, String to) {
		
		List<Integer> flightNumber = new ArrayList<>();
		Set<Entry<Integer, FlightDetails>> entrySet = DataBase.flight.entrySet();
		for(Entry<Integer, FlightDetails> routes : entrySet) {
			if(routes.getValue().getFlightRoutes().contains(from) && routes.getValue().getFlightRoutes().contains(to)) {
				flightNumber.add(routes.getKey());
			}
		}
		return flightNumber;
	}
	
	public void passengers(PassengerDetails passengerDetails) {
		
		dataBase = new DataBase();
		dataBase.passengerList(passengerDetails);
		
	}
	
	public int userBooking() {
		
		dataBase = new DataBase();
		new PassengerDetails();
		dataBase.passengerDataBase();
		return PassengerDetails.getPnrNo();
		
	}
	
	public boolean pnrNumberChecking(int pnrNumber) {
		
		if(DataBase.passengerInfo.containsKey(pnrNumber)) {
			return true;
		}
		return false;
	}
	
	public void ticketCancellation(int pnrNumber) {
		
		DataBase.passengerInfo.remove(pnrNumber);
		
	}
	
}
