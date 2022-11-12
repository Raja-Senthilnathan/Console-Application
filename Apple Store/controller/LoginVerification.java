package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.DBConnection;
import model.DBQueries;

public class LoginVerification {
	
	DBQueries queries = new DBQueries();
	int original_id;
	String original_password;
	public boolean verification(int customer_id, String password) {
		
		try {
			PreparedStatement statement = DBConnection.connectDB().prepareStatement(queries.getLogin_verification());
			statement.setInt(1, customer_id);
			
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				original_id = result.getInt(1);
				original_password = result.getString(2);
			}
			if(original_id==customer_id && original_password.equals(password)) {
				return true;
			}
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
