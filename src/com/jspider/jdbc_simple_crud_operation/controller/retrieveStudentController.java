package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class retrieveStudentController {
public static void main(String[] args) {
	 Connection con = null;
//	Scanner sc = new Scanner(System.in);
//	int id = sc.nextInt();
	try {
		//step-1 load /register driver
		
         //		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// we can load as well as register the driver
		
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// register the driver is good practice because in it only single exception occurs
		
		//Step-2
		
		String url = "jdbc:mysql://localhost:3306/jdbc-10am";
		String user = "root";
		String pass = "harshit";
		con = DriverManager.getConnection(url,user,pass);
		
		//Step-3 
		
		Statement st = con.createStatement();
		
		//step-4  
		
		String retrieveStudentQuery = "select * from student";
		ResultSet a = st.executeQuery(retrieveStudentQuery);
		
		while(a.next()) { 
		int Id = a.getInt("id");
		String name = a.getString("name");
		String email = a.getString("email");
		long phone = a.getLong("phone");
		
		System.out.println("Student Id  "+ Id);
		System.out.println("Student name  "+ name);
		System.out.println("Student email  "+ email);
		System.out.println("Student phone  "+ phone);
		
		System.out.println("..................");
		}
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		try {
			con.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
}
