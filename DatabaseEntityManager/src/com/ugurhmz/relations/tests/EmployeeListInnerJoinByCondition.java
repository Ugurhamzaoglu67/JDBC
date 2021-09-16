package com.ugurhmz.relations.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ugurhmz.stock.database.Utilities;

public class EmployeeListInnerJoinByCondition {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		/*MySQL Code
		 * 	
		  	use jdbcexample;

			select employeeId, employeeName, monthlySalary, Employee.departmentId, departmentName 
				FROM Employee
				inner join Department
					ON Employee.departmentId = Department.departmentId
			        WHERE Employee.departmentId=2
		  
		 * */
		
		

		
		try {
			Connection connection = Utilities.getConnection();
			String sql = "select employeeId, employeeName, monthlySalary, departmentName \r\n"
					+ "	FROM Employee\r\n"
					+ "	inner join Department\r\n"
					+ "		ON Employee.departmentId = Department.departmentId\r\n"
					+ "        WHERE Employee.departmentId=?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, 2);
			
			ResultSet rs = statement.executeQuery();
			
			
			while(rs.next()) {
				int employeeId = rs.getInt("employeeId");
				String employeeName = rs.getString("employeeName");
				double monthlySalary = rs.getDouble("monthlySalary");
				String departmentName = rs.getString("departmentName");
				

				System.out.printf("%10d %-20s %10.2f  %s \r\n",
						employeeId,employeeName,monthlySalary, departmentName);
			}
			
			
			
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
