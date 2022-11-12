package controller;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.CustomerDetails;
import model.DBConnection;
import model.DBQueries;

public class CustomerDataProcess {
	
	DBQueries queries = new DBQueries();
	public void storeData(CustomerDetails customer) {
		
		try {
			PreparedStatement statement = DBConnection.connectDB().prepareStatement(queries.getNew_user());
			statement.setString(1, customer.getFirst_name());
			statement.setString(2, customer.getLast_name());
			statement.setString(3, customer.getAddress());
			statement.setString(4, customer.getCity());
			statement.setInt(5, customer.getPincode());
			statement.setLong(6, customer.getPhone_number());
			statement.setString(7, customer.getMail_id());
			statement.setString(8, customer.getPassword());
			
			statement.executeUpdate();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}

}
