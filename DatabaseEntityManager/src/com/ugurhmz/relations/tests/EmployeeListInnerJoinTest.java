package com.ugurhmz.relations.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ugurhmz.stock.database.Utilities;

public class EmployeeListInnerJoinTest {

	public static void main(String[] args) throws ClassNotFoundException  {
		
		
		
		try {
			Connection connection = Utilities.getConnection();
			String sqlInnerJoin = "select employeeId, employeeName, monthlySalary, Employee.departmentId, departmentName \r\n"
					+ "	FROM Employee\r\n"
					+ "	inner join Department\r\n"
					+ "		on Employee.departmentId = Department.departmentId";
			
			PreparedStatement statement = connection.prepareStatement(sqlInnerJoin);
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				long employeeId = rs.getInt("employeeId");
				String employeeName = rs.getString("employeeName");
				double monthlySalary = rs.getDouble("monthlySalary");
				long departmentId = rs.getInt("departmentId");
				String departmentName = rs.getString("departmentName");
				
				System.out.printf("%10d %-20s %10.2f %10d %s \r\n",
						employeeId,employeeName,monthlySalary,departmentId, departmentName);
			}
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		
		
	}
}
