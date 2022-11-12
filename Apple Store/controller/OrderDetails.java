package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import model.DBConnection;
import model.DBQueries;
import model.Products;

public class OrderDetails {

	DBQueries queries = new DBQueries();
	List<Products> show = new ArrayList<>();

	public List<Products> order(Map<Integer, Integer> orderedList) {

		for (int id : orderedList.keySet()) {
			try {
				PreparedStatement statement = DBConnection.connectDB().prepareStatement(queries.getShow_order());
				statement.setInt(1, id);
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					show.add(new Products(result.getInt(1), result.getString(2), result.getDouble(3)));
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return show;
	}
	
}
