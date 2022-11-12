package view;

import controller.UserController;
import model.UserDetails;

public class UserSignUp {
	 
	    UserDetails userDetails;
	    UserController userController;
	    HomePage homePage;
	 
	public void signUp() {
		
		homePage = new HomePage();
		userController = new UserController();
		System.out.println("->Sign Up Page");
		System.out.println("--------------");
		System.out.println("Enter your First Name");
		String firstName = Main.scanner.next();
		
		System.out.println("Enter your Last Name");
		String lastName = Main.scanner.next();
		
		System.out.println("Enter your Phone Number");
		long phoneNumber = Main.scanner.nextLong();
		
		System.out.println("Enter your Mail ID");
		String mailId = Main.scanner.next();
		
		System.out.println("Enter your Password");
		String password = Main.scanner.next();
		
		userDetails = new UserDetails(firstName, lastName, phoneNumber, mailId, password);
		System.out.println("Your User ID is : "+UserDetails.getUserId());
		System.out.println("Your account has been created Successfully");
		userController.userSignupUpdate(userDetails);
		homePage.signIn();
		
	}

}
