package com.ugurhmz.relations.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmployeeInsertTest {

	public static void main(String[] args) {
		

		String urL ="jdbc:mysql://localhost:3306/jdbcexample";
		String dbName = "root";
		String password = "1994ugur";
		
		try {
			Connection connection = DriverManager.getConnection(urL, dbName, password);
			String sqlInsert = "INSERT INTO Employee (employeeName,monthlySalary, departmentId) VALUES (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(sqlInsert);
			statement.setString(1, "Burak Tosun");
			statement.setDouble(2, 9500);
			statement.setInt(3, 3);
			
			
			int affected = statement.executeUpdate();
			
			
			System.out.println("DB insert success : "+affected);
			connection.close();
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
	}
}
