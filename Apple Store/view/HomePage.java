package view;

import java.util.Scanner;

public class HomePage {

	LogInPage login = new LogInPage();
	SignUpPage sign = new SignUpPage();
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		HomePage homePage = new HomePage();
		homePage.home();
	}

	public void home() {
		System.out.println("1)Log in \n2)Sign up \n3)Exit");
		int userInput = sc.nextInt();

		switch (userInput) {
		case 1:
			login.logIn();
			break;
		case 2:
			sign.signUp();
			break;
		case 3:
			System.out.println("Thank You!!!");
			break;
		default:
			System.err.println("Invalid Input");
			home();
		}
	}
}
