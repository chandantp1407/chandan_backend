package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRecord {
	private	static Connection connection;
	private static Scanner sc=new Scanner(System.in);
	public static void main(String[] args)  {
		StudentRecord studentRecord=new StudentRecord();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sa123");

			System.out.println("Want to see Student Data base!!");
			System.out.println("Press one for inserting records:");
			System.out.println("Press Two for Select all records:");

			System.out.println("Enter the choice :");
			int choice=sc.nextInt();
			switch (choice) {
			case 1: {
				studentRecord.insertRecords();
				break;
			}
			case 2:{
				studentRecord.selectRecord();
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	private void insertRecords() throws SQLException {
		String query="insert into Student values(?,?,?,?)";
		PreparedStatement pre=connection.prepareStatement(query);

		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Id");
		pre.setInt(1, sc.nextInt());
		System.out.println("Enter the Student Name:");
		pre.setString(2, sc.next());
		System.out.println("Enter the Student Percentage:");
		pre.setDouble(3, sc.nextDouble());
		System.out.println("Enter the Student Address:");
		pre.setString(4, sc.next());

		int rs=pre.executeUpdate();
		if(rs!=0)
			System.out.println("Record inserted Successfully");
		connection.close();
	}
	
	private void selectRecord() {

	}
}
