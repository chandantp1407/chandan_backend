package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeDB {
	private	static Connection connection;
	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		EmployeeDB employeeDB=new EmployeeDB();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sa123");

			System.out.println("Want to see Employee Data base!!");
			System.out.println("Press one for inserting employee records:");
			System.out.println("Press Two for Select Employee by Id:");
			System.out.println("Press Three for Select all employees:");
			System.out.println("Press Four for update employee fields:");
			System.out.println("Press five for delete employees");

			System.out.println("Enter the choice :");
			int choice=sc.nextInt();
			switch (choice) {
			case 1: {
				employeeDB.insertEmployee();
				break;
			}
			case 2:{
				employeeDB.selectEmployeeById();
				break;
			}
			case 3:{
				employeeDB.selectAllEmployees();
				break;
			}
			case 4:{
				employeeDB.updateEmployeeFields();
				break;
			}
			case 5:{
				employeeDB.deleteEmployee();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}


	private void insertEmployee() throws SQLException {
		String query="insert into Employee values(?,?,?,?)";
		PreparedStatement pre=connection.prepareStatement(query);
		while(true) {
			System.out.println("Enter the Employee Id:");
			pre.setInt(1, sc.nextInt());
			System.out.println("Enter the Employee Name:");
			pre.setString(2, sc.next());
			System.out.println("Enter the Employee Salary:");
			pre.setDouble(3, sc.nextDouble());
			System.out.println("Enter the Employee Department:");
			pre.setString(4, sc.next());

			int rs=pre.executeUpdate();
			if(rs!=0)
				System.out.println("Record inserted Successfully");
			System.out.println("want to add more employee records:");

			String value=sc.next();
			if(value.equalsIgnoreCase("no"))
				break;
		}
		connection.close();
	}
	private void selectEmployeeById() throws SQLException {
		String query="select * from employee where id=?";
		System.out.println("Enter the employee Id :");
		int id=sc.nextInt();
		PreparedStatement pre=connection.prepareStatement(query);
		pre.setInt(1, id);
		ResultSet res=pre.executeQuery();
		while(res.next()) {
			int empId=res.getInt("id");
			String name=res.getString("name");
			double sal=res.getDouble("sal");
			String dept=res.getString("dept");
			System.out.println("EmployeeId: "+empId+" EmployeeName: "+name+" EmployeeSal: "+sal+" EmployeeDept: "+dept);
		}
		connection.close();
	}
	private void selectAllEmployees()throws SQLException {
		String query="select * from employee ";
		Statement st=connection.createStatement();
		ResultSet res=st.executeQuery(query);
		while(res.next()) {
			int empId=res.getInt("id");
			String name=res.getString("name");
			double sal=res.getDouble("sal");
			String dept=res.getString("dept");
			System.out.println("EmployeeId: "+empId+" EmployeeName: "+name+" EmployeeSal: "+sal+" EmployeeDept: "+dept);

		}
		connection.close();
	}

	private void updateEmployeeFields() throws SQLException {
		String query="select * from employee where id=?";
		System.out.println("Enter the employeeId to update:");
		int id=sc.nextInt();
		PreparedStatement pre=connection.prepareStatement(query);
		pre.setInt(1, id);
		ResultSet res=pre.executeQuery();
		while(res.next()) {
			int empId=res.getInt("id");
			String name=res.getString("name");
			double sal=res.getDouble("sal");
			String dept=res.getString("dept");
			System.out.println("EmployeeId: "+empId+" EmployeeName: "+name+" EmployeeSal: "+sal+" EmployeeDept: "+dept);

		}
		String updateQuery="update Employee set";
		System.out.println("press one for update name:");
		System.out.println("press Two for update sal:");
		System.out.println("press Three for update dept:");
		System.out.println("Enter the choice:");
		int choice=sc.nextInt();
		switch (choice) {
		case 1: {
			System.out.println("Enter Name to update:");
			String newName=sc.next();
			updateQuery=updateQuery+" name = ? where id="+id;
			PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, newName);

			int result=preparedStatement.executeUpdate();

			if(result!=0)
				System.out.println("Name is updated successfully");
			else
				System.out.println(" Name is not updated");
			break;
		}
		case 2:{
			System.out.println("Enter salary to update:");
			double newSal=sc.nextDouble();
			updateQuery=updateQuery+" sal = ? where id="+id;
			PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setDouble(1, newSal);

			int result=preparedStatement.executeUpdate();

			if(result!=0)
				System.out.println("salary  updated successfully");
			else
				System.out.println(" Invalid empId");
			break;

		}
		case 3:{
			System.out.println("Enter Department to update:");
			String newDept=sc.next();
			updateQuery=updateQuery+" dept = ? where id="+id;
			PreparedStatement preparedStatement=connection.prepareStatement(updateQuery);
			preparedStatement.setString(1, newDept);

			int result=preparedStatement.executeUpdate();

			if(result!=0)
				System.out.println("department  updated successfully");
			else
				System.out.println(" Invalid empId");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + choice);
		
		}
		connection.close();
	}

	private void deleteEmployee() throws SQLException {

		String query="select * from employee ";
		Statement st=connection.createStatement();
		ResultSet res=st.executeQuery(query);
		while(res.next()) {
			int empId=res.getInt("id");
			String name=res.getString("name");
			double sal=res.getDouble("sal");
			String dept=res.getString("dept");
			System.out.println("EmployeeId: "+empId+" EmployeeName: "+name+" EmployeeSal: "+sal+" EmployeeDept: "+dept);

		}
		System.out.println("Enter Employee Id to delete record:");
		int id=sc.nextInt();
		String deleteQuery="delete from employee where id=?";
		PreparedStatement preparedStatement=connection.prepareStatement(deleteQuery);
		preparedStatement.setInt(1, id);

		int result=preparedStatement.executeUpdate();

		if(result!=0)
			System.out.println("One data deleted successfully!!");
		else
			System.out.println("Invalid employee id");
		connection.close();
	}


}
