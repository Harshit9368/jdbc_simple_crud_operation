package com.jspider.jdbc_simple_crud_operation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentInsertController {
	public static void main(String[] args) {
		Connection con = null;
		try {
			//step 1  load /register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step 2 create connection
			
			String url = "jdbc:mysql://localhost:3306/jdbc-10am";
			String user = "root";
			String pass = "harshit";
			
			con = DriverManager.getConnection(url,user,pass);
			
			//Step 3 Create statement
			
			Statement st = con.createStatement();
			
			//Step-4 executeQuery
			
			String insertStudentQuery = "insert into student(id,name,email,phone) values (421,'Amit','Amit@gmail',9876543209)";
			st.execute(insertStudentQuery);
		}catch(ClassNotFoundException | SQLException e) {
			//TODO Auto-generator catch block
			e.printStackTrace();
		}finally {
			try {
				//step-5 close connection
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}

}
