package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToOracle {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl";
	private String usuario = "rm81247";
	private String senha = "200499";
	private Connection connection;
	
	public Connection connect() {
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			System.out.println("Error during Oracle driver loading\n" + e);
		} catch (SQLException e) {
			System.out.println("Error during the Oracle network establishment\n" + e);
		}
		
		return connection;
	}
}
