package contact_management;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
	
	Scanner input = new Scanner(System.in);
	public static void main(String[] args) throws SQLException {
	
		Main main = new Main();
		main.contactDetails();
		
	}
	private void contactDetails() throws SQLException {
		
		Contact contact = new Contact();
	    System.out.println("Choose the option \n1)Add new Contact \n2)Edit Contact \n3)Delete Contact \n4)Search Contact \n5)Show Contact \n6)Exit");
	    int userChoice = input.nextInt();
	    
	    switch(userChoice) {
	    case 1 : contact.addNewContact();
	             break;
	    case 2 : contact.editContact();
                 break;
	    case 3 : contact.deleteContact();
	    	     break;
	    case 4 : contact.searchContact();
        		 break;
	    case 5 : contact.showContact();
        		 break;
	    case 6 : System.out.println("Thank you!!!");
	             break;
	    default : System.out.println("Invalid Input");
	    	      contactDetails();
                  break;
	    }
	}
}
