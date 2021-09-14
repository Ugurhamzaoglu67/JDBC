package com.ugurhmz.jdbc.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionJdbc {

	public static void main(String[] args)  {
	
		
		String url = "jdbc:mysql://localhost:3306/jdbcexample";
		String dbName = "root";
		String password = "1994ugur";
		

		try {
			Connection connection = DriverManager.getConnection(url, dbName, password);
			String sql = "INSERT INTO Product(productName, salesPrice) VALUES(?,?)";
			
			
			// TRANSACTION Baþlattýk.
			connection.setAutoCommit(false);
			 
			
			// INSERT PRODUCT 1 
			PreparedStatement statement1 = connection.prepareStatement(sql);
			statement1.setString(1,"Samsung S10");
			statement1.setDouble(2, 10500);
			
			int affected1 = statement1.executeUpdate();
			System.out.println("Affected1 : "+affected1);
			

			
			
			// INSERT PRODUCT 2
			PreparedStatement statement2 = connection.prepareStatement(sql);
			statement2.setString(1, "Samsung S9");
			statement2.setDouble(2, 9500);
			
			int affected2 = statement2.executeUpdate();
			System.out.println("Affected2 : "+affected2);
			
			
			
			
			// INSERT PRODUCT 3
			PreparedStatement statement3 = connection.prepareStatement(sql);
			statement3.setString(1, "Samsung S5");
			statement3.setDouble(2, 5500);
			
			int affected3 = statement3.executeUpdate();
			System.out.println("Affected3 : "+affected3);
			
			
			
			connection.commit();
			connection.close();
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
		
	}

}
