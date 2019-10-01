package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.ConnectToOracle;
import com.model.Feedbacks;
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
		sql = "INSERT INTO userform VALUES (?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getTelephone());
			ps.setString(5, user.getPassword());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert User on Oracle\n" + e);
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
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
		} finally {
			try {
				if(rs == null) {
					ps.close();	
				}
			}catch(SQLException e) {}
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
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
		return aux;
	}
	
	public void userApply(int jo_code, String email) {
		sql = "INSERT INTO user_jobopening VALUES (?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.setString(2, email);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during register user into a job opening on Oracle\n" + e);
		}  finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
	}
	
	public boolean userExists(String email) {
		boolean exists = false;
		sql = "SELECT * FROM userform WHERE userform.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()){
				exists = true;
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement of user exists method on Oracle\n" + e);
		}  finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
		return exists;
	}
	
	public List<Feedbacks> retrieveFeedbacks(String email){
		List<Feedbacks> feedbacks = new ArrayList<>();
		sql = "SELECT user_jobopening_feedback.jo_code, user_jobopening_feedback.feedback_message FROM user_jobopening_feedback WHERE user_jobopening_feedback.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				feedbacks.add(new Feedbacks(rs.getInt("jo_code"),rs.getString("feedback_message")));
			}
		}catch(SQLException e) {
			System.out.println("Error during retrieving feedbacks on Oracle\n" + e);
		}  finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
		return feedbacks;
	}
}
