package com.ugurhmz.jdbc.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertJdbc {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/jdbcexample";
		String name = "root";
		String password = "1994ugur";
		
		try {
			Connection connection = DriverManager.getConnection(url,name,password);
			
			String insertSql = "INSERT INTO Product(productName,salesPrice) values('Iphone 7s',500)";
			Statement statement = connection.createStatement();
			
			
			int affected = statement.executeUpdate(insertSql);
			
			
			System.out.println("insert successfull, affected row : "+affected);
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
