package com.ugurhmz.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		Class.forName("com.mysql.jdbc.Driver"); 
		
		String url = "jdbc:mysql://localhost:3306/jdbcexample";
		String userName = "root";
		String password= "1994ugur";
		
		
		try {
			Connection connection = DriverManager.getConnection(url,userName,password);
			
			System.out.println("DB name : " + connection.getMetaData().getDatabaseProductName());
			
			
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
