package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.ConnectToOracle;
import com.model.Feedback;
import com.model.User;

public class UserDAO {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;

	public UserDAO() {
		this.connection = new ConnectToOracle().connect();
	}
	
	public int returnUserId(String email) {
		int user_id = 0;
		sql = "SELECT userform.user_id FROM userform WHERE userform.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) user_id = Integer.parseInt(rs.getString("user_id"));
		}catch(SQLException e) {
			System.out.println("Error during retrievement of user ID on Oracle\n" + e);
		}
		return user_id;
	}
	
	public void userRegister(User user) {
		sql = "INSERT INTO userform VALUES (user_id.nextval,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, user.getFirstname());
			ps.setString(2, user.getLastname());
			ps.setString(3, user.getEmail());
			ps.setDate(4, user.getBorn_date());
			ps.setString(5, user.getTelephone());
			ps.setString(6, user.getPassword());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert User on Oracle\n" + e);
		} 
	}
	
	public ResultSet userLogin(String email, String password) {
		sql = "SELECT userform.email, userform.accesspassword FROM userform WHERE userform.email = ? AND userform.accesspassword = ?";
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
		sql = "SELECT userform.firstname FROM userform WHERE userform.email = ?";
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
	
	public void updateFirstName(String firstname, int user_id) {
		sql = "UPDATE userform SET userform.firstname = ? WHERE userform.user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, firstname);
			ps.setInt(2, user_id);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update last name on Oracle\n" + e);
		}
	}
	
	public void updateLastName(String lastname, int user_id) {
		sql = "UPDATE userform SET userform.lastname = ? WHERE userform.user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, lastname);
			ps.setInt(2, user_id);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update last name on Oracle\n" + e);
		}
	}
	
	public void updateBornDate(Date date, int user_id) {
		sql = "UPDATE userform SET userform.born_date = ? WHERE userform.user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setDate(1, date);
			ps.setInt(2, user_id);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update born date on Oracle\n" + e);
		}
	}
	
	public String retrieveLastName(String email) {
		String aux = null;
		sql = "SELECT userform.lastname FROM userform WHERE userform.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				aux = rs.getString("lastname");
			} else {
				System.out.println("Email not associate with any register.");
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement name User on Oracle\n" + e);
		} 
		return aux;
	}
	
	public String retrievePhone(String email) {
		String aux = null;
		sql = "SELECT userform.phone FROM userform WHERE userform.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				aux = rs.getString("phone");
			} else {
				System.out.println("Email not associate with any register.");
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement name User on Oracle\n" + e);
		} 
		return aux;
	}
	
	public String retrieveBornDate(int user_id) {
		String date = null;
		sql = "SELECT userform.born_date FROM userform WHERE userform.user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) date = new SimpleDateFormat("dd/MM/yyyy").format(rs.getDate("born_date")) ;
		}catch(SQLException e) {
			System.out.println("Error during retrievement date born User on Oracle\n" + e);
		} 
		return date;
	}
	
	public void userApply(int jo_code, int user_id) {
		sql = "INSERT INTO user_jobopening VALUES (?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.setInt(2, user_id);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during register user into a job opening on Oracle\n" + e);
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
		}  
		return exists;
	}
	
	public List<Feedback> retrieveFeedbacks(String email){
		List<Feedback> feedbacks = new ArrayList<>();
		sql = "SELECT user_jobopening_feedback.jo_code, user_jobopening_feedback.feedback_message FROM user_jobopening_feedback WHERE user_jobopening_feedback.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			if(rs.next()) {
				feedbacks.add(new Feedback(rs.getInt("jo_code"),rs.getString("feedback_message")));
			}
		}catch(SQLException e) {
			System.out.println("Error during retrieving feedbacks on Oracle\n" + e);
		}  
		System.out.println(feedbacks.toString());
		return feedbacks;
	}
}
