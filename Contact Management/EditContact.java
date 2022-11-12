package contact_management;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EditContact extends Contact {

	public void name() throws SQLException {
		
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
        String number = input.next();
        System.out.println("Enter the new Name");
        input.nextLine();
        String newName = input.nextLine();
        statement.executeUpdate("UPDATE Contact SET Name="+"'"+newName+"'"+" WHERE Phone_Number="+number);
        System.out.println("Updated Successfully");
		
	}
	public void phoneNumber() throws SQLException {
		
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
        String number = input.next();
        System.out.println("Enter the new Phone Number");
        String newNumber = input.next();
        statement.executeUpdate("UPDATE Contact SET Phone_Number="+newNumber+" WHERE Phone_Number="+number);
        System.out.println("Updated Successfully");
		
	}
	public void relationship() throws SQLException {
		
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
        String number = input.next();
        System.out.println("Enter the new Relationship");
        input.nextLine();
        String newRelationship = input.nextLine();
        statement.executeUpdate("UPDATE Contact SET Relationship="+"'"+newRelationship+"'"+" WHERE Phone_Number="+number);
        System.out.println("Updated Successfully");
		
	}
	public void favourite() throws SQLException {
		
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
        String number = input.next();
        System.out.println("0)Remove Favourite \n1)Add Favourite");
        int favourite = input.nextInt();
        statement.executeUpdate("UPDATE Contact SET Favourite="+favourite+" WHERE Phone_Number="+number);
        System.out.println("Updated Successfully");
		
	}
	public void city() throws SQLException {
		
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
        String number = input.next();
        System.out.println("Enter the new City");
        String newCity = input.next();
        statement.executeUpdate("UPDATE Contact SET City="+"'"+newCity+"'"+" WHERE Phone_Number="+number);
        System.out.println("Updated Successfully");
		
	}
	public void dob() throws SQLException {
		
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
        String number = input.next();
        System.out.println("Enter the new DOB");
        String newDob = input.next();
        statement.executeUpdate("UPDATE Contact SET DOB="+"'"+newDob+"'"+" WHERE Phone_Number="+number);
        System.out.println("Updated Successfully");
		
	}
	public void email() throws SQLException {
		
		Connection connection = connectDB();
		Statement statement = connection.createStatement();
		System.out.println("Enter the Phone Number");
        String number = input.next();
        System.out.println("Enter the new Email Id");
        String newEmail = input.next();
        statement.executeUpdate("UPDATE Contact SET Email="+"'"+newEmail+"'"+" WHERE Phone_Number="+number);
        System.out.println("Updated Successfully");
		
	}
}
