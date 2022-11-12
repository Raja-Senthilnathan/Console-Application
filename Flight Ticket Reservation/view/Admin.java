package view;

import java.util.ArrayList;
import java.util.List;

import controller.AdminController;
import model.FlightDetails;

public class Admin extends Display{
	
	AdminController adminController;
	HomePage homePage;
	FlightDetails flightDetails;
	
	public void logIn() {
		
		adminController = new AdminController();
		System.out.println("Enter your four digit Pin");
		int pin = Main.scanner.nextInt();
		if(adminController.adminLogIn(pin)) {
			adminPanel();
		}
		else {
			System.err.println("Invalid Credentials");
			logIn();
		}
		
	}
	
	public void adminPanel() {
		
		homePage = new HomePage();
		System.out.println("Choose the Option");
		System.out.println("-----------------");
		System.out.println("0)Log Out \n1)Add Flight \n2)Remove Flight \n3)View Flight Details \n4)View Passenger Details");
		int adminOption = Main.scanner.nextInt();
		switch(adminOption) {
		case 0 : homePage.signIn();
		         break;
		case 1 : addFlight();
			     break;
		case 2 : removeFlight();
		         break;
		case 3 : viewFlight();
		         break;
		case 4 : viewPassenger();
		         break;
		default : System.err.println("Invalid Input");
		          adminPanel();
		          break;     
		}
		
	}

	private void addFlight() {
		
		adminController = new AdminController();
		List<String> routes = new ArrayList<>();
		
		System.out.println("Enter the Flight Number");
		int flightNumber = Main.scanner.nextInt();
		
		System.out.println("Enter the Flight Name");
		String flightName = Main.scanner.next();
		
		System.out.println("Enter the Flight Departure Time");
		String departureTime = Main.scanner.next();
		
		System.out.println("Enter the Flight Arrival Time");
		String arrivalTime = Main.scanner.next();
		
		System.out.println("Enter the Number of Flight Routes");
        int noOfRoutes = Main.scanner.nextInt();
        
        System.out.println("Enter the Flight Routes");
		for(int index=0; index<noOfRoutes; index++) {
			routes.add(Main.scanner.next());
		}
		
		System.out.println("Enter the Total Number of Seats");
		int totalSeats = Main.scanner.nextInt();
		
		System.out.println("Enter the Fare");
		double fare = Main.scanner.nextDouble();
		
		flightDetails = new FlightDetails(flightNumber, flightName, departureTime, arrivalTime, routes, totalSeats, fare);
		adminController.addFlightDetails(flightDetails);
		System.out.println("New Flight is Added Successfully");
		adminPanel();
		
	}

	private void removeFlight() {
		 
		 adminController = new AdminController();
	     displayFlightList();
	     System.out.println("Choose the Flight Number");
	     int flightNumber = Main.scanner.nextInt();
	     adminController.removeFlightDetails(flightNumber);
	     System.out.println("Successfully Removed the Flight");
	     adminPanel();
	     
	}

	private void viewFlight() {
		
		displayFlightList();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
		}
		adminPanel();
	}

	private void viewPassenger() {
		
		displayPassengerDetails();
		adminPanel();
		
	}

}
