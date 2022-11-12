package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static Connection connect = null;
	
public static Connection connectDB(){
	
	    try {
	    	if(connect==null)
			   connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/apple_store", "root", "Raja_@10");
	    	else
	    	   return connect;
		} 
	    catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connect;
	}
}
