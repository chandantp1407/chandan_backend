package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDB {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("load and registerDriver succesfully");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "Sa123");
		System.out.println("Connection established successfully");
//		String query="insert into Student values(1,'chandan','88.2','mysore')";
//		Statement st=con.createStatement();
//		int count=st.executeUpdate(query);
		
		
		String query="insert into Student values(?,?,?,?)";
		PreparedStatement pre=con.prepareStatement(query);
		
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

		con.close();
	}
}
