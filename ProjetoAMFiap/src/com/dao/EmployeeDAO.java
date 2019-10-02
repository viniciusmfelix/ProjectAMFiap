package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.ConnectToOracle;
import com.model.Employee;
import com.model.User;

public class EmployeeDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public EmployeeDAO() {
		this.connection = new ConnectToOracle().connect();
	}
	
	public void employeeRegister(Employee employee) {
		sql = "INSERT INTO employeeform VALUES (?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, employee.getEmployee_code());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getLastname());
			ps.setString(4, employee.getEmail());
			ps.setString(5, employee.getPassword());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert Employee on Oracle\n" + e);
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) { /* ignored */}
		    }
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
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) { /* ignored */}
		    }
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
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		return rs;
	}
	
	public String retrieveName(int employee_code) {
		String aux = null;
		sql = "SELECT employeeform.firstname FROM employeeform WHERE employeeform.employee_code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, employee_code);
			rs = ps.executeQuery();
			if(rs.next()) {
				aux = rs.getString("firstname");
			} else {
				System.out.println("Code not associate with any register.");
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement name User on Oracle\n" + e);
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		return aux;
	}
	
	public List<User> retrieveUsersApplied(int jo_code) {
		List<User> users_applied = new ArrayList<>();
		sql = "SELECT * FROM user_jobopening JOIN resumeform ON resumeform.email_user = user_jobopening.email JOIN userform ON userform.email = user_jobopening.email WHERE user_jobopening.jo_code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			rs = ps.executeQuery();
			while(rs.next()) {
				users_applied.add(new User(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("phone")));
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement of applied users on Oracle\n"+e);
		} finally {
		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (ps != null) {
		        try {
		            ps.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		    if (connection != null) {
		        try {
		            connection.close();
		        } catch (SQLException e) { /* ignored */}
		    }
		}
		return users_applied;
	}
}
