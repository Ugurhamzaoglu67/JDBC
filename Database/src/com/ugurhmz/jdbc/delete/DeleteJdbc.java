package com.ugurhmz.jdbc.delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteJdbc {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url="jdbc:mysql://localhost:3306/jdbcexample";
		String dbName = "root";
		String  password="1994ugur";
		
		
		try {
			Connection connection = DriverManager.getConnection(url,dbName, password);
			String sqlDelete = "DELETE FROM Product WHERE productId=?";
			PreparedStatement statement = connection.prepareStatement(sqlDelete);
			
			statement.setLong(1, 3);	//id -> 3 olaný sil.
			int deletedCount = statement.executeUpdate();
			
					
			
			System.out.println("Deleted : "+deletedCount);
	
			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
