package contact_management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Contact {
	
	Scanner input = new Scanner(System.in);
	
	public Connection connectDB() throws SQLException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact_Management", "root", "Raja_@10");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addNewContact() throws SQLException {
			
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the name");
		String name = input.nextLine();
		System.out.println("Enter the Phone Number");
		String phoneNumber = input.next();
		System.out.println("Enter the Relationship");
		input.nextLine();
		String relationship = input.nextLine();
		System.out.println("That person is your favourite or not \n0)Not a Favourite \n1)Favourite");
		int favourite = input.nextInt();
		System.out.println("Enter the city");
		String city = input.next();
		System.out.println("Enter the Date of Birth \nIn this format DD-MM-YYYY");
		String dob = input.next();
		System.out.println("Enter the email id");
		String email = input.next();
		String query = String.format("INSERT INTO Contact VALUES(\"%s\",%s,\"%s\",%d,\"%s\",\"%s\",\"%s\")",name,phoneNumber,relationship,favourite,city,dob,email);
		statement.executeUpdate(query);
        System.out.println("Updated Successfully");
        
	}
	public void editContact() throws SQLException {
			
		System.out.println("What you want to edit \nChoose any one \n1)Name \n2)Phone Number \n3)Relationship \n4)Favourite \n5)City \n6)DOB \n7)Email");
		int userChoice = input.nextInt();
		EditContact edit = new EditContact();
		
		switch(userChoice) {
		case 1 : edit.name();
		         break;
		case 2 : edit.phoneNumber();
                 break;  
		case 3 : edit.relationship();
                 break;
		case 4 : edit.favourite();
                 break;
		case 5 : edit.city();
		         break;
		case 6 : edit.dob();
		         break;
		case 7 : edit.email(); 
		         break;
		default : System.out.println("Invalid input");
		          editContact();
		}
			
	}
	public void deleteContact() throws SQLException {
			
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
		String number = input.next();
		statement.executeUpdate("DELETE FROM Contact WHERE Phone_Number="+number);
		System.out.println("Deleted Successfully");
				
	}
	public void searchContact() throws SQLException {
			
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("1)Search by Name \n2)Search by Phone Number");
		int choice = input.nextInt();
		if(choice==1) {
			System.out.println("Enter the Name");
			input.nextLine();
			String name = input.nextLine();
			ResultSet result = statement.executeQuery("SELECT * FROM Contact WHERE Name LIKE '"+name+"%'");
			System.out.printf("%-17s%-14s%-14s%-11s%-12s%-12s%-32s\n","NAME", "PHONE NUMBER", "RELATIONSHIP", "FAVOURITE", "CITY", "DOB", "EMAIL");
			while(result.next()) {
				System.out.printf("%-17s%-14s%-14s%-11s%-12s%-12s%-32s\n",result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7));
			}
		}
		else if(choice==2) {
			System.out.println("Enter the Phone Number");
			String number = input.next();
			ResultSet result = statement.executeQuery("SELECT * FROM Contact WHERE Phone_Number LIKE '"+number+"%'");
			System.out.printf("%-17s%-14s%-14s%-11s%-12s%-12s%-32s\n","NAME", "PHONE NUMBER", "RELATIONSHIP", "FAVOURITE", "CITY", "DOB", "EMAIL");
			while(result.next()) {
				System.out.printf("%-17s%-14s%-14s%-11s%-12s%-12s%-32s\n",result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7));
			}
		}
		else {
			System.out.println("Invalid Input");
			searchContact();
		}
			
	}
	public void showContact() throws SQLException {
			
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery("SELECT * FROM Contact ORDER BY Name");
		System.out.printf("%-17s%-14s%-14s%-11s%-12s%-12s%-32s\n","NAME", "PHONE NUMBER", "RELATIONSHIP", "FAVOURITE", "CITY", "DOB", "EMAIL");
		while(result.next()) {
			System.out.printf("%-17s%-14s%-14s%-11s%-12s%-12s%-32s\n",result.getString(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5),result.getString(6),result.getString(7));
		}
	}
	}


