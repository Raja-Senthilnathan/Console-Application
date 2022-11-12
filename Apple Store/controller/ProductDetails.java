package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import model.DBConnection;
import model.DBQueries;
import model.Products;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class ProductDetails {

	DBQueries queries = new DBQueries();

	public Map<Integer, String> productCategory() {

		Map<Integer, String> map = new LinkedHashMap<>();

		try {
			PreparedStatement statement = DBConnection.connectDB().prepareStatement(queries.getProduct_category());
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				map.put(result.getInt(1), result.getString(2));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return map;
	}

	public List<Products> productInfo(int category) {

		List<Products> productsList = new ArrayList<>();
		try {
			PreparedStatement statement = DBConnection.connectDB().prepareStatement(queries.getProduct_info());
			statement.setInt(1, category);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				productsList.add(new Products(result.getInt(1), result.getString(2), result.getDouble(3)));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return productsList;
	}
}
