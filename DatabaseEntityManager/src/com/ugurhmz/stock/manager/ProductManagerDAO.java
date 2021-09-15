package com.ugurhmz.stock.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ugurhmz.stock.database.Utilities;
import com.ugurhmz.stock.entity.Product;

public class ProductManagerDAO {			// Data Access Object (DAO)

	
	
	// INSERT  		DTO
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
	
	
	
	
	
	// FIND BY ID					DTO
	public Product findById(long productId) throws ClassNotFoundException, SQLException {
		Product product = null;
		
		Connection connection = Utilities.getConnection();
		String sqlFindById = "SELECT * FROM Product WHERE productId=?";
		
		
			PreparedStatement statement = connection.prepareStatement(sqlFindById);
			statement.setLong(1, productId);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				product = new Product();
				product.setProductId(rs.getLong("productId"));
				product.setProductName(rs.getString("productName"));
				product.setSalesPrice(rs.getDouble("salesPrice"));
			} 
			
			
			connection.close();
		
		return product;
	}
	
	
	
	
	
	// UPDATE
	public boolean update(Product product) throws ClassNotFoundException {
		Connection connection = Utilities.getConnection();
		String sqlUpdate ="UPDATE Product SET productName=?, salesPrice=? WHERE productId=?";
		int affected = 0;
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlUpdate);
			statement.setString(1,product.getProductName());
			statement.setDouble(2,product.getSalesPrice());
			statement.setLong(3, product.getProductId());
			
			affected = statement.executeUpdate();
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return affected == 1 ? true : false;
	}
	
	
	
	
	
	
	
	// DELETE
	public boolean delete(long productId) throws ClassNotFoundException {
		Connection connection = Utilities.getConnection();
		int affected = 0;
		
		try {
			String sqlDelete = "DELETE  FROM Product WHERE productId=?";
			PreparedStatement statement = connection.prepareStatement(sqlDelete);
			statement.setLong(1, productId);
			
			affected = statement.executeUpdate();
			
			connection.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return affected == 1 ? true : false;
	}
	
	
	
	
	
	
	
	
	
	
}
