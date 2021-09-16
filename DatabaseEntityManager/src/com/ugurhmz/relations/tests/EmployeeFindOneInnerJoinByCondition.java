package com.ugurhmz.relations.tests;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ugurhmz.stock.database.Utilities;

public class EmployeeFindOneInnerJoinByCondition {

	public static void main(String[] args) throws ClassNotFoundException {
		
		
		/*MySQL CODE 
		  
		  use jdbcexample;

			SELECT Employee.*, departmentName
				FROM Employee INNER JOIN Department
					ON Employee.departmentId = Department.departmentId
						WHERE employeeId=3;
		  
		  
		  */
		
		try  {
			
			Connection connection = Utilities.getConnection();
			/*String sqlFindOne= "SELECT Employee.*, departmentName\r\n"
					+ "				FROM Employee INNER JOIN Department\r\n"
					+ "					ON Employee.departmentId = Department.departmentId\r\n"
					+ "						WHERE employeeId=?;";*/
			
			String sqlFindOne = "SELECT * FROM EmployeeView WHERE employeeId=?";
			
			
			
			PreparedStatement statement = connection.prepareStatement(sqlFindOne);
			statement.setInt(1, 8);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				int employeeId = rs.getInt("employeeId");
				String employeeName = rs.getString("employeeName");
				double monthlySalary = rs.getDouble("monthlySalary");
				String departmentName = rs.getString("departmentName");
				
				System.out.println("\nID : "+employeeId+"\n"
								   +"Employee name : "+employeeName+"\n"+
								    "Monthly Salary : "+monthlySalary+"\n"+
								    "department name : "+departmentName);
				
				
			} else {
				System.out.println("EMP NOT FOUND !!!");
			}
				
			
			connection.close();
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		

	}

}
