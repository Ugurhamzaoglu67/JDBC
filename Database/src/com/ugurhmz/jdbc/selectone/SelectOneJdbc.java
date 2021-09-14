package com.ugurhmz.jdbc.selectone;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectOneJdbc {

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbcexample";
		String name = "root";
		String password = "1994ugur";
		
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			
			String sqlSelectOne = "SELECT * FROM Product WHERE productId=?";
			PreparedStatement statement = connection.prepareStatement(sqlSelectOne);
			statement.setLong(1, 4); // id -> 4 olaný getir
			
			ResultSet rs = statement.executeQuery();
			
			// Gelen verinin bilgileri
			if(rs.next()) {
				long productId = rs.getLong("productId");
				String productName = rs.getString("productName");
				double salesPrice = rs.getDouble("salesPrice");
				
				System.out.println("Product ID : "+productId);
				System.out.println("Product Name : "+productName);
				System.out.println("Product Sales Price : "+salesPrice);
			} else {
				System.out.println("There is not found");
			}
			
			
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
