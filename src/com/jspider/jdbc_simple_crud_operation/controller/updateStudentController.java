package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class updateStudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter student id to update Email");
		int id = scanner.nextInt();
		System.out.println("Enter new Email to update");
		String email = scanner.next();
		//Connection con = null;
		try {
			//step 1  load /register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2 create connection
			
			String url = "jdbc:mysql://localhost:3306/jdbc-10am";
			String user = "root";
			String pass = "harshit";
			
			 Connection con = DriverManager.getConnection(url,user,pass);
			
			//Step 3 Create statement
			
			Statement st = con.createStatement();
			
			//Step-4 executeQuery
			
			String updateStudentEmailQuery = "update student set email='"+email+"' where id ="+id;
			int a = st.executeUpdate(updateStudentEmailQuery);
			if(a==1) {
				System.out.println("Data--Updated--");
			}else {
				System.out.println("======Given id is not present=======");
			}
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
