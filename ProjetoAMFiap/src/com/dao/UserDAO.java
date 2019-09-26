package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnection.ConnectToOracle;
import com.model.User;

public class UserDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public UserDAO() {
		this.connection = new ConnectToOracle().connect();
	}
	
	public void userRegister(User user) {
		sql = "INSERT INTO userform VALUES (?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getTelephone());
			ps.setString(5, user.getPassword());
			ps.setInt(6, 0);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert User on Oracle\n" + e);
		}
	}
	
	public ResultSet userLogin(String email, String password) {
		sql = "SELECT email, accesspassword FROM userform WHERE email = ? AND accesspassword = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println("Error during retrievement User on Oracle\n" + e);
		}
		return rs;
	}
	
	public String retrieveName(String email) {
		String aux = null;
		sql = "SELECT userform.firstname FROM userform WHERE email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				aux = rs.getString("firstname");
			} else {
				System.out.println("Email not associate with any register.");
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement name User on Oracle\n" + e);
		}
		return aux;
	}
}
