package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.ConnectToOracle;
import com.model.JobOpening;
import com.model.User;

public class JobOpeningDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public JobOpeningDAO(){
		this.connection = new ConnectToOracle().connect();
	}
	
	public void createNewJobOpening(JobOpening jobopening) {
		sql = "INSERT INTO jobopening VALUES (job_id.nextval,?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, jobopening.getTitle());
			ps.setString(2, jobopening.getOverview());
			ps.setString(3, jobopening.getCountry());
			ps.setString(4, jobopening.getCity());
			ps.setString(5, jobopening.getAddress());
			ps.setString(6, jobopening.getDescription());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert Job Opening on Oracle\n" + e);
		} 
	}
	
	public List<JobOpening> retrieveJobOpening(){
		List<JobOpening> jobs = new ArrayList<>();
		sql = "SELECT * FROM jobopening";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				jobs.add(new JobOpening(rs.getInt("job_id"),rs.getString("jobname"),rs.getString("overview"),rs.getString("country"),rs.getString("city"),rs.getString("address"),rs.getString("jobdescription")));
			}
		} catch (SQLException e) {
			System.out.println("Error during retrievement of Job Openings on Oracle\n" + e);
		} 
		return jobs;
	}
	
	public JobOpening retrieveJobToUpdate(int job_id) {
		JobOpening job = new JobOpening();
		sql="SELECT job_id, jobname, overview, country, city , address, jobdescription FROM jobopening WHERE job_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, job_id);
			rs = ps.executeQuery();
			if(rs.next()) job = new JobOpening(rs.getInt("job_id"),rs.getString("jobname"),rs.getString("overview"),rs.getString("country"),rs.getString("city"),rs.getString("address"),rs.getString("jobdescription"));
		}catch(SQLException e) {
			System.out.println("Error during retrieving job opening on Oracle on line 61\n" + e);
		}
		return job;
	}
	
	public void updateJobOpening(JobOpening jobopening) {
		sql = "UPDATE jobopening SET jobname = ?, overview = ?, country = ?, city = ?, address = ? ,jobdescription = ? WHERE job_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1,jobopening.getTitle());
			ps.setString(2, jobopening.getOverview());
			ps.setString(3, jobopening.getCountry());
			ps.setString(4, jobopening.getCity());
			ps.setString(5, jobopening.getAddress());
			ps.setString(6, jobopening.getDescription());
			ps.setInt(7, jobopening.getJo_code());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update of Job Openings on Oracle\n" + e);
		} 
	}
	
	public void deleteJobOpening(int jo_code) {
		sql = "DELETE FROM jobopening WHERE job_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during delete Job Opening on Oracle\n" + e);
		}
	}
	
	public boolean jobOpeningExists(int jo_code) {
		boolean exists = false;
		sql = "SELECT * FROM jobopeningform WHERE jo_code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			rs = ps.executeQuery();
			if(rs.next()) exists = true;
		}catch(SQLException e) {
			System.out.println("Error during retrievement of job opening exists on Oracle\n"+e);
		} 
		return exists;
	}
	
	public boolean userAlreadyApplied(int jo_code, String email) {
		boolean exists = false;
		sql = "SELECT * from user_jobopening WHERE user_jobopening.jo_code = ? AND user_jobopening.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.setString(2, email);
			rs = ps.executeQuery();
			if(rs.next()) exists = true;
		}catch(SQLException e) {
			System.out.println("Error retrieving user already applied to job opening on Oracle\n" + e);
		} 
		return exists;
	}
	
	public String retrieveNameJobOpening(int jo_code) {
		String jobname = null;
		sql = "SELECT jobopening.jobname FROM jobopening WHERE jobopening.job_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			rs = ps.executeQuery();
			if(rs.next()) jobname = rs.getString("jobname");
		}catch(SQLException e) {
			System.out.println("Error during retrieving job name on Oracle\n" + e);
		} 
		return jobname;
	}
	
	public void applyFeedback(int jo_code, int user_id, String message_feedback) {
		sql = "INSERT INTO user_jobopening_feedback VALUES((SELECT user_jobopening.job_id FROM user_jobopening WHERE user_jobopening.job_id = ?),(SELECT user_jobopening.user_id FROM user_jobopening WHERE user_jobopening.user_id = ?),?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.setInt(2, user_id);
			ps.setString(3, message_feedback);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert feedback to user on Oracle\n" + e);
		} 
	}
	
	public boolean feedbackAlreadyApplied(int jo_code, String email) {
		boolean already_applied = false;
		sql = "SELECT feedback_message FROM user_jobopening_feedback WHERE user_jobopening_feedback.jo_code = ? AND user_jobopening_feedback.email = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.setString(2, email);
			rs = ps.executeQuery();
			if(rs.next()) already_applied = true;
		}catch(SQLException e) {
			System.out.println("Erron during retrievement of feedback already applied on Oracle\n" + e);
		} 
		return already_applied;
	}
	
	public List<User> usersApplied(int jo_code){
		List<User> usersapplied = new ArrayList<>();
		sql = "SELECT userform.user_id,userform.firstname, userform.lastname, userform.email, userform.born_date, userform.phone, userform.accesspassword FROM user_jobopening INNER JOIN userform ON userform.user_id = user_jobopening.user_id WHERE job_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			rs = ps.executeQuery();
			while(rs.next()) {usersapplied.add((new User(rs.getInt("user_id"),rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getDate("born_date"),rs.getString("phone"),rs.getString("accesspassword"))));}
		}catch(SQLException e) {
			System.out.println("Error during retrieve users applied on job on job method on Oracle\n" + e);
		}
		return usersapplied;
	}
	
	public void setFeedbacktoRefusedUsers(int jo_code, User user) {
		sql = "INSERT INTO user_jobopening_feedback VALUES((SELECT user_jobopening.jo_code FROM user_jobopening WHERE user_jobopening.jo_code = ? AND user_jobopening.email = ?),(SELECT user_jobopening.email FROM user_jobopening WHERE user_jobopening.email = ? AND user_jobopening.jo_code = ?),?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, jo_code);
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getEmail());
				ps.setInt(4, jo_code);
				ps.setString(5, "Your resume at all was not able to select in this job :(. Try again later on other opportunities!");
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during insert feedback to refused users on Oracle\n" + e);
			}
	}
	
	public void userApply(int jo_code, int user_id) {
		sql = "INSERT INTO user_jobopening VALUES (?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.setInt(2, jo_code);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during register user into a job opening on Oracle\n" + e);
		}  
	}
	
	public void userDeleteFeedbacks(int user_id) {
		sql = "DELETE FROM user_jobopening_feedback WHERE user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during delete feedbacks on Oracle\n");
		}
	}
}
