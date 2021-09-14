package com.ugurhmz.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertJdbc {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/jdbcexample";
		String dbName = "root";
		String  password="1994ugur";
		
		try {
			Connection connection = DriverManager.getConnection(url,dbName, password);
			String sql = "INSERT INTO Product(productName,salesPrice) VALUES(?,?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, "LCD TV");
			statement.setDouble(2, 800);
			
			int affected = statement.executeUpdate();
			
			System.out.println("affected : "+affected);
			
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
		
	}
}
