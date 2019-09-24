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
			System.out.println("Erro ao inserir no banco o form de USUARIO\n" + e);
		}
	}
	
	public ResultSet userLogin(String email, String password) {
		sql = "SELECT email, password FROM userform WHERE email = ? AND accesspassword = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println("Erro ao consultar o banco o form de USUARIO\n" + e);
		}
		return rs;
	}
}
