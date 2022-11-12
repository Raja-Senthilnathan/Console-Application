package view;

import java.util.ArrayList;
import java.util.List;

import controller.UserController;
import model.DataBase;
import model.PassengerDetails;

public class User extends Display{
	
	HomePage homePage;
	UserController userController;
	PassengerDetails passengerDetails;
	
	public void userOptions() {
		
		homePage = new HomePage();
		System.out.println("Choose the Option");
		System.out.println("-----------------");
		System.out.println("0)Log Out \n1)Booking \n2)View Ticket \n3)Cancel Ticket");
		int option = Main.scanner.nextInt();
		switch(option) {
		case 0 : homePage.signIn();
		         break;
		case 1 : booking();
			     break;
		case 2 : viewTicket();
			     break;
		case 3 : cancelTicket();
			     break; 
	    default : System.err.println("Invalid Input");
	              userOptions(); 
		}
		
	}
	
	public void booking() {
		
		userController = new UserController();
		List<Integer> flight = new ArrayList<>();
		System.out.println("Enter your User ID");
		int userId = Main.scanner.nextInt();
		System.out.println("From");
		String from = Main.scanner.next();
		System.out.println("To");
		String to = Main.scanner.next();
	    flight = userController.flightRoutes(from, to);
	    if(flight.isEmpty()) {
	    	
	    	System.out.println("That route is not available \nPlease Choose another route");
	    	booking();
	    	
		}
	    displaySelectedFlights(flight);
	    System.out.println("Enter the Flight Number");
	    int flightNumber = Main.scanner.nextInt();
	    System.out.println("Enter the Number of Passenger");
	    int noOfPassenger = Main.scanner.nextInt();
	    if(DataBase.flight.get(flightNumber).getTotalSeats()<noOfPassenger) {
	    	
	    	System.err.println(noOfPassenger+" Seats is not Available");
	    	System.out.println("Only "+DataBase.flight.get(flightNumber).getTotalSeats()+" Seats is Available");
	    	System.out.println("Enter the Number of Passenger");
	    	noOfPassenger = Main.scanner.nextInt();
	    	
	    }
	    else {
	    	
	    	int seats = DataBase.flight.get(flightNumber).getTotalSeats()-noOfPassenger;
	    	DataBase.flight.get(flightNumber).setTotalSeats(seats);
	    	
	    }
	    for(int index=1; index<=noOfPassenger; index++) {
	    	
	    	System.out.println("Enter Passenger "+index+" Details");
	    	System.out.println("Name");
	    	String name = Main.scanner.next();
	    	System.out.println("Age");
	    	byte age = Main.scanner.nextByte();
	    	System.out.println("Gender");
	    	String gender = Main.scanner.next();
	    	passengerDetails = new PassengerDetails(flightNumber, userId, name, age, gender);
	    	userController.passengers(passengerDetails);
	    
	    }
	    int pnrNo = userController.userBooking();
	    System.out.println("Total Fare : "+DataBase.flight.get(flightNumber).getFare()*noOfPassenger);
	    System.out.println("Your Ticket is Booked Successfully");
	    System.out.println("This is your PNR Number : "+pnrNo);
	    userOptions();
	    
	}
	
	public void viewTicket() {
		
		userController = new UserController();
		System.out.println("Enter Your PNR Number");
		int pnrNumber = Main.scanner.nextInt();
		if(!userController.pnrNumberChecking(pnrNumber)){
			System.err.println("Invalid PNR Number");
			cancelTicket();
		}
		displayTicket(pnrNumber);
		userOptions();
		
	}
	
	public void cancelTicket() {
		
		userController = new UserController();
		System.out.println("Enter your PNR Number");
		int pnrNumber = Main.scanner.nextInt();
		if(!userController.pnrNumberChecking(pnrNumber)){
			System.err.println("Invalid PNR Number");
			cancelTicket();
		}
		userController.ticketCancellation(pnrNumber);
		System.out.println("Your Ticket is Cancelled Successfully");
		userOptions();
		
	}

}
