package com.cmarcello.experiment;

import java.sql.Connection;
import java.sql.DriverManager;

public class Teste {

	public static void main(String[] args) {
		
		// setup connection variables
		String user = "postgres";
		String pass = "admin";
		String jdbcUrl = "jdbc:postgresql://localhost:5432/web_customer_tracker?useSSL=false";
		String driver = "org.postgresql.Driver";
		
		// get connection to database
		try {			
			Class.forName(driver);			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);			
			myConn.prepareStatement("select * from customer").executeQuery();			
			System.out.println("Success!");			
			myConn.close();			
		}
		catch (Exception exc) {
			exc.printStackTrace();					
		}
	}

}
