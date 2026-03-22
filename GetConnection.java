package com.qsp.Employee_Management_System.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {

	private static final String URL="jdbc:postgresql://localhost:5432/employee-management-system-db";
	private static final String USER="postgres";
	private static final String PWD="12345";
	
	public static Connection getConnectionObject() {
		
		
			try {
				Class.forName("org.postgresql.Driver");
				Connection con= DriverManager.getConnection(URL,USER,PWD);
				 System.out.println("Database Connected Successfully");
				return con;
				  
			} 
			 catch (Exception e) {
				
				e.printStackTrace();
			}
			
			return null;
			
	
		
		
	}
}
