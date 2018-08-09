package com.revature.sql;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
	
	//Database template
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:oracle:thin:@[your hostname]:1521:orcl";
		String username = "admin";
		String password = "";
		return DriverManager.getConnection(url,username,password);
	}
	//DONT PUSH CONNECTION.PROPERTIES FILE
	public static Connection getConnectionFromFile(String filename) throws SQLException, IOException {
		Properties prop = new Properties();
		InputStream in = new FileInputStream(filename);
		prop.load(in);
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		return DriverManager.getConnection(url, username, password);
	}
}
