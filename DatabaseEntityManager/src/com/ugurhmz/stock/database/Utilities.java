package com.ugurhmz.stock.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utilities {

	public static 	String url = "jdbc:mysql://localhost:3306/jdbcexample";
	public static   String userName = "root";
	public static   String password = "1994ugur";
	public static Connection connection = null;
	
	
	
	// Get Connection
	public static Connection getConnection() throws ClassNotFoundException {
		
			Class.forName("com.mysql.jdbc.Driver");
		
			try {
				connection = DriverManager.getConnection(url, userName, password);
				System.out.println("Db access...");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return connection;
	}
}
