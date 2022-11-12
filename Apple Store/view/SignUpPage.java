package view;

import java.util.Scanner;

import controller.CustomerDataProcess;
import model.CustomerDetails;

public class SignUpPage {
	
	Scanner sc = new Scanner(System.in);
	CustomerDetails customer;
	CustomerDataProcess data = new CustomerDataProcess();
	
	public void signUp() {
		
		System.out.println("Enter your First Name");
		String first_name = sc.next();
		
		System.out.println("Enter your Last Name");
		String last_name = sc.next();
		
		sc.nextLine();
		System.out.println("Enter your Door Number & Street");
		String address = sc.nextLine();
		
		System.out.println("Enter your city");
		String city = sc.next();
		
		System.out.println("Enter your pincode");
		int pincode = sc.nextInt();
		
		System.out.println("Enter your Phone Number");
		long phone_number = sc.nextLong();
		
		System.out.println("Enter your Mail ID");
		String mail_id = sc.next();
		
		System.out.println("Enter Your Password");
		String password = sc.next();
		
		customer = new CustomerDetails(first_name, last_name, address, city, pincode, phone_number, mail_id, password);
		data.storeData(customer);
		
	}
	
}
