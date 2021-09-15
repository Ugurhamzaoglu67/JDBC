package com.ugurhmz.stock.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
	
	
	
	// LIST ALL 
	public Set<Product> listAll() throws ClassNotFoundException{
		Set<Product> productList = new TreeSet<>();
		
		Connection connection = Utilities.getConnection();
		String sqlListAll = "SELECT * FROM  Product";
		try {
			PreparedStatement statement = connection.prepareStatement(sqlListAll);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();						// (1)  Nesne Oluþturdukl
				product.setProductId(rs.getLong("productId"));			// (2) Nesnenin deðerlerini set ettik.
				product.setProductName(rs.getString("productName"));
				product.setSalesPrice(rs.getDouble("salesPrice"));
				
				productList.add(product);								// (3) sonrada bu nesneyi HashSet'e ekledik.
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}
	
	
	
	
	
	// LIST ALL BY CONDITION
	public List<Product> listAllBySalesPriceGreaterThan(double salesPrice) throws ClassNotFoundException, SQLException{
		List<Product> productList = new ArrayList<>();
		Connection connection = Utilities.getConnection();
		String sqlListALl = " Select * FROM  Product WHERE salesPrice>=?";
		
		
		try {
			PreparedStatement statement = connection.prepareStatement(sqlListALl);
			statement.setDouble(1, salesPrice);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getLong("productId"));
				product.setProductName(rs.getString("productName"));
				product.setSalesPrice(rs.getDouble("salesPrice"));
				
				productList.add(product);
			}
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		connection.close();
		return productList;
	}
	
	
	
	
	
}














