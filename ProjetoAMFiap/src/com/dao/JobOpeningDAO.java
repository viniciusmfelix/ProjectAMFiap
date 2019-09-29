package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.ConnectToOracle;
import com.model.JobOpening;

public class JobOpeningDAO {

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
		sql = "SELECT jobopeningform.jobname FROM jobopeningform WHERE jobopeningform.jo_code = ?";
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
}
