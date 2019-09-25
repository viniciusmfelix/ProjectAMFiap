package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbconnection.ConnectToOracle;
import com.model.Employee;

public class EmployeeDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public EmployeeDAO() {
		this.connection = new ConnectToOracle().connect();
	}
	
	public void employeeRegister(Employee employee) {
		sql = "INSERT INTO employeeform VALUES (?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, employee.getEmployee_code());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getLastname());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.setInt(6, 1);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert Employee on Oracle\n" + e);
		}
	}
	
	public ResultSet employeeLogin(int employee_code, String password) {
		sql = "SELECT employee_code, accesspassword FROM employeeform WHERE employee_code = ? AND accesspassword = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, employee_code);
			ps.setString(2, password);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println("Error during retrievement Employee on Oracle\n" + e);
		}
		return rs;
	}
	
	public ResultSet adminAuthentication(String adm_password) {
		sql = "SELECT employee_code, accesspassword FROM employeeform WHERE employee_code = 1 AND accesspassword = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, adm_password);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println("Error during ADM password authentication on Oracle\n" + e);
		}
		return rs;
	}
}
