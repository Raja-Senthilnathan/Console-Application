package view;

import model.FlightDetails;

public class HomePage {

	Admin admin = new Admin();
	UserSignUp userSignUp;
	UserLogIn userLogin;
	FlightDetails flightDetails;

	public void signIn() {
        
		userLogin = new UserLogIn();
		userSignUp = new UserSignUp();
		System.out.println("0)Exit \n1)Admin \n2)Existing User \n3)New User");
		int sign_in = Main.scanner.nextInt();
		switch (sign_in) {
		case 0:
			System.out.println("Thank You!!!");
			break;
		case 1:
			admin.logIn();
			break;
		case 2:
			userLogin.logIn();
			break;
		case 3:
			userSignUp.signUp();
			break;	
		default:
			System.err.println("Invalid Input");
			signIn();
		}
	}
	
}
