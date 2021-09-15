package com.ugurhmz.stock.manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ugurhmz.stock.entity.Product;

public class ProductManager {

	
	// INSERT  
	public boolean insert(Product product) {
		
		
		String url = "jdbc:mysql://localhost:3306/jdbcexample";
		String dbName = "root";
		String password = "1994ugur";
		int affected = 0;
		
		try {
			Connection connection = DriverManager.getConnection(url, dbName, password);
			String sqlInsert = "INSERT INTO Product(productName, salesPrice) VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlInsert);
			
			statement.setString(1,product.getProductName());
			statement.setDouble(2, product.getSalesPrice());
			
			affected = statement.executeUpdate();
			
			connection.close();
			System.out.println("Insert success...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		return affected == 1 ? true : false;
		
	}
	
	
}
