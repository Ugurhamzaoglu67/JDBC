package com.ugurhmz.stock.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ugurhmz.stock.database.Utilities;
import com.ugurhmz.stock.entity.Product;

public class ProductManager {

	
	// INSERT  
	public boolean insert(Product product) throws ClassNotFoundException {
		
		int affected = 0;
		
		try {
			Connection connection = Utilities.getConnection();
			
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
