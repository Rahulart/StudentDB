package com.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	protected static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/rahul";
		String username="root";
		String password="rahul"; 
		Connection con = DriverManager.getConnection(url,username,password);
		
		return con;
	}
}
