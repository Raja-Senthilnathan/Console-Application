package view;

import java.util.Scanner;

import controller.LoginVerification;

public class LogInPage {

	Scanner sc = new Scanner(System.in);
	LoginVerification verify = new LoginVerification();
	PlaceOrder order = new PlaceOrder();

	public void logIn() {

		System.out.println("Enter your Customer ID");
		int customer_id = sc.nextInt();

		System.out.println("Enter your Password");
		String password = sc.next();

		if (verify.verification(customer_id, password)) {
			order.productCategory(customer_id);
		} else {
			System.err.println("Invalid Credentials");
		}

	}

}
