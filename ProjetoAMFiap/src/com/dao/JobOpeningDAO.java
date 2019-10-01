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
	private final String refuseFeedback = "Your resume at all was not able to select in this job :(. Try again later on other opportunities!";
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public JobOpeningDAO(){
		this.connection = new ConnectToOracle().connect();
	}
	
	public void createNewJobOpening(JobOpening jobopening) {
		sql = "INSERT INTO jobopeningform VALUES (?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jobopening.getJo_code());
			ps.setString(2, jobopening.getName());
			ps.setString(3, jobopening.getDescription());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert Job Opening on Oracle\n" + e);
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
	}
	
	public List<JobOpening> retrieveJobOpening(){
		List<JobOpening> jobs = new ArrayList<>();
		sql = "SELECT * FROM jobopeningform";
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				jobs.add(new JobOpening(rs.getInt("jo_code"),rs.getString("jobname"),rs.getString("jobdescription")));
			}
			
		} catch (SQLException e) {
			System.out.println("Error during retrievement of Job Openings on Oracle\n" + e);
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
		return jobs;
	}
	
	public void updateJobOpening(JobOpening jobopening) {
		sql = "UPDATE jobopeningform SET jobopeningform.jo_code = ?, jobopeningform.jobname = ?, jobopeningform.jobdescription = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jobopening.getJo_code());
			ps.setString(2, jobopening.getName());
			ps.setString(3, jobopening.getDescription());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update of Job Openings on Oracle\n" + e);
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
	}
	
	public void deleteJobOpening(int jo_code) {
		sql = "DELETE FROM jobopeningform WHERE jo_code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during delete Job Opening on Oracle\n" + e);
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
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
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
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
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
		return exists;
	}
	
	public String retrieveNameJobOpening(int jo_code) {
		String jobname = null;
		sql = "SELECT jobopeningform.jobname FROM jobopeningform WHERE jobopeningform.jo_code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			rs = ps.executeQuery();
			if(rs.next()) jobname = rs.getString("jobname");
		}catch(SQLException e) {
			System.out.println("Error during retrieving job name on Oracle\n" + e);
		} finally {
			try {
				if(rs==null) {
				ps.close();
				}
			}catch(SQLException e) {}
		}
		return jobname;
	}
	
	public void applyFeedback(int jo_code, String email, String message_feedback) {
		sql = "INSERT INTO user_jobopening_feedback VALUES((SELECT user_jobopening.jo_code FROM user_jobopening WHERE user_jobopening.jo_code = ?),(SELECT user_jobopening.email FROM user_jobopening WHERE user_jobopening.email = ?),?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.setString(2, email);
			ps.setString(3, message_feedback);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert feedback to user on Oracle\n" + e);
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
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
		} finally {
			try {
				ps.close();
			}catch(SQLException e) {}
		}
		return already_applied;
	}
	
	public void setFeedbacktoRefusedUsers(int jo_code, List<User> users) {
		sql = "INSERT INTO user_jobopening_feedback VALUES((SELECT user_jobopening.jo_code FROM user_jobopening WHERE user_jobopening.jo_code = ? AND user_jobopening.email = ?),(SELECT user_jobopening.email FROM user_jobopening WHERE user_jobopening.email = ? AND user_jobopening.jo_code = ?),?);";
		for (User user : users) {
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, jo_code);
				ps.setString(2, user.getEmail());
				ps.setString(3, user.getEmail());
				ps.setInt(4, jo_code);
				ps.setString(5, refuseFeedback);
				connection.commit();
			}catch(SQLException e) {
				System.out.println("Error during insert feedback to refused users on Oracle\n");
			}finally {
				try {
					ps.close();
				}catch(SQLException e) {}
			}
		}
	}
}
