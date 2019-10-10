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
		sql = "INSERT INTO employeeform VALUES (employee_id.nextval,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,employee.getFirstname());
			ps.setString(2, employee.getLastname());
			ps.setString(3, employee.getEmail());
			ps.setDate(4, employee.getDate());
			ps.setString(5, employee.getPhone());
			ps.setString(6, employee.getPassword());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert Employee on Oracle\n" + e);
		}
	}
	
	public ResultSet employeeLogin(String email, String password) {
		sql = "SELECT email, accesspassword FROM employeeform WHERE email = ? AND accesspassword = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			System.out.println("Error during retrievement Employee on Oracle\n" + e);
		}
		return rs;
	}
	
	public boolean adminAuthentication(String adm_email,String adm_password) {
		boolean access_authorized = false;
		sql = "SELECT email, accesspassword FROM employeeform WHERE email = ? AND accesspassword = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, adm_email);
			ps.setString(2, adm_password);
			rs = ps.executeQuery();
			if(rs.next()) access_authorized = true;
		}catch(SQLException e) {
			System.out.println("Error during ADM password authentication on Oracle\n" + e);
		}
		return access_authorized;
	}
	
	public String retrieveName(String employee_email) {
		String aux = null;
		sql = "SELECT employeeform.firstname FROM employeeform WHERE employeeform.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, employee_email);
			rs = ps.executeQuery();
			if(rs.next()) {
				aux = rs.getString("firstname");
			} else {
				System.out.println("Code not associate with any register.");
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement name User on Oracle\n" + e);
		}
		return aux;
	}
	
}
