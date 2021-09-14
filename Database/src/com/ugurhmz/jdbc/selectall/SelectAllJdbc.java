package com.ugurhmz.jdbc.selectall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SelectAllJdbc {

	public static void main(String[] args) throws ClassNotFoundException {
		
		//Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbcexample";
		String name = "root";
		String password = "1994ugur";
		
		try {
			Connection connection = DriverManager.getConnection(url, name, password);
			String sqlSelect = "SELECT * FROM Product";
			PreparedStatement statement = connection.prepareStatement(sqlSelect);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				long productId = rs.getLong("productId");
				String productName = rs.getString("productName");
				double salesPrice = rs.getDouble("salesPrice");
				
				System.out.printf("%10d  %-20s %10.2f \r\n",productId, productName, salesPrice);
			}
			
			
			
			
			
			connection.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
