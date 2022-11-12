package view;

import controller.UserController;

public class UserLogIn {
	
	UserController userControl;
	User user;
	
	public void logIn() {
		
		userControl = new UserController();
		user = new User();
		System.out.println("->Log In Page");
		System.out.println("-------------");
		System.out.println("Enter your User ID");
		int customerId = Main.scanner.nextInt();
		System.out.println("Enter your Password");
		String password = Main.scanner.next();
		if(userControl.userlogInCheck(customerId, password)) {
			user.userOptions();
		}
		else {
			System.err.println("Invalid Credentials");	
			logIn();
		}
	}

}
