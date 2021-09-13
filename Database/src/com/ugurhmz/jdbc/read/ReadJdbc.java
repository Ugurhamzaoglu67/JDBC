package com.ugurhmz.jdbc.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReadJdbc {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbcexample";
		String name = "root";
		String password = "1994ugur";
		
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			String sqlRead = "Select * FROM Product";
			Statement statement = connection.createStatement();
		
			ResultSet  resultSet = statement.executeQuery(sqlRead);
			
			
			
			// Dönen Sonuçlarý Türlerine Göre al.
			while(resultSet.next()) {
				long productId = resultSet.getLong("productId");
				String productName = resultSet.getString("productName");
				double salesPrice = resultSet.getDouble("salesPrice");
				System.out.println(productId+" "+productName+" "+salesPrice);
				
			}

			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
