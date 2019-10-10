package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToOracle {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "system";
	private String password = "OracleSQL123";
	private Connection connection;
	
	public Connection connect() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Error during Oracle driver loading\n" + e);
		} catch (SQLException e) {
			System.out.println("Error during the Oracle network establishment\n" + e);
		}
		
		return connection;
	}
	
}
