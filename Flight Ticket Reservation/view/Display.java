package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import model.DataBase;
import model.FlightDetails;
import model.PassengerDetails;

public class Display {
	
	Set<Entry<Integer, FlightDetails>> entrySet = DataBase.flight.entrySet();
	
	public void displayFlightList() {
		
		System.out.println("Flight Details");
		System.out.println("--------------");
		for(Entry<Integer, FlightDetails> flight : entrySet) {
			
			System.out.println("Flight Number : "+flight.getValue().getFlightNumber());
			System.out.println("Flight Name : "+flight.getValue().getFlightName());
			System.out.println("Flight Depature Time : "+flight.getValue().getDepartureTime());
			System.out.println("Flight Arrival Time : "+flight.getValue().getArrivalTime());
			System.out.println("Flight Routes : "+flight.getValue().getFlightRoutes());
			System.out.println("Total Seats : "+flight.getValue().getTotalSeats());
			System.out.println("Fare : "+flight.getValue().getFare());
			System.out.println();
			
		}	
	}
	
	public void displaySelectedFlights(List<Integer> flightNumber) {
		
		System.out.println("Flight Details");
		System.out.println("--------------");
		for(int flight : flightNumber) {
			for(Entry<Integer, FlightDetails> flightDetails : entrySet) {
				
				if(flightDetails.getKey()==flight) {
					System.out.println("Flight Number : "+flightDetails.getValue().getFlightNumber());
					System.out.println("Flight Name : "+flightDetails.getValue().getFlightName());
					System.out.println("Flight Depature Time : "+flightDetails.getValue().getDepartureTime());
					System.out.println("Flight Arrival Time : "+flightDetails.getValue().getArrivalTime());
					System.out.println("Flight Routes : "+flightDetails.getValue().getFlightRoutes());
					System.out.println("Total Seats : "+flightDetails.getValue().getTotalSeats());
					System.out.println("Fare : "+flightDetails.getValue().getFare());
					System.out.println();
					break;
				}
				
			}
		}	
	}
	
	public void displayPassengerDetails() {
		
		int passengerId = 1;
		for(PassengerDetails passenger : DataBase.passenger) {
			
			System.out.println("Passenger "+passengerId+++" Details");
			System.out.println("-------------------");
		    System.out.println("Flight Number : "+passenger.getFlightNumber());
		    System.out.println("User ID : "+passenger.getUserId());
		    System.out.println("PNR Number : "+PassengerDetails.getPnrNo());
		    System.out.println("Name : "+passenger.getName());
		    System.out.println("Age : "+passenger.getAge());
		    System.out.println("Gender : "+passenger.getGender());
		    System.out.println();
		
		}
	}
	
	public void displayTicket(int pnrNumber) {
		
		List<PassengerDetails> ticket = new ArrayList<>();
		int flightNumber = 0, passengerNumber =1;
		ticket = DataBase.passengerInfo.get(pnrNumber);
		for(PassengerDetails passenger : ticket) {
			
			flightNumber = passenger.getFlightNumber();
			System.out.println("Passenger "+passengerNumber+++" Details");
			System.out.println("-------------------");
			System.out.println("PNR Number : "+PassengerDetails.getPnrNo());
			System.out.println("Name : "+passenger.getName());
			System.out.println("Age : "+passenger.getAge());
			System.out.println("Gender : "+passenger.getGender());
			System.out.println();
		
		}
		System.out.println("Flight Details");
		System.out.println("--------------");
		System.out.println("Flight Number : "+DataBase.flight.get(flightNumber).getFlightNumber());
		System.out.println("Flight Name : "+DataBase.flight.get(flightNumber).getFlightName());
		System.out.println("Flight Departure Time : "+DataBase.flight.get(flightNumber).getDepartureTime());
		System.out.println("Flight Arrival Time : "+DataBase.flight.get(flightNumber).getArrivalTime());
		System.out.println("Flight Routes : "+DataBase.flight.get(flightNumber).getFlightRoutes());
		System.out.println("Total Fare : "+(DataBase.flight.get(flightNumber).getFare())*(passengerNumber-1));
		System.out.println();
		
	}
}
