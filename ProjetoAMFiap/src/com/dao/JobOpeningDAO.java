package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			System.out.println("Erro ao cadastrar vaga no banco\n" + e);
		}
	}
	
	public void deleteJobOpening(int jo_code) {
		sql = "DELETE FROM jobopeningform WHERE jobopening_code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Erro ao excluir vaga no banco\n" + e);
		}
	}
}
