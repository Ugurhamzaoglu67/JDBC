package com.ugurhmz.jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateJdbc {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/jdbcexample";
		String dbName = "root";
		String  password="1994ugur";
		
		
		try {
			Connection connection = DriverManager.getConnection(url,dbName, password);
			String sql = "UPDATE Product set productName=?, salesPrice=? WHERE productId=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, "DELL Laptop");
			statement.setDouble(2, 6500);
			statement.setLong(3, 2);
			
			int affected = statement.executeUpdate();
			
			
			
			
			System.out.println("affected : "+affected);
			
			
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
