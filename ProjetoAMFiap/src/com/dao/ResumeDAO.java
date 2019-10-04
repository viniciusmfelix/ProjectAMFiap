package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dbconnection.ConnectToOracle;
import com.model.AcademicTraining;
import com.model.ExtracurricularCourse;
import com.model.Goal;
import com.model.Language;
import com.model.ProfessionalExperience;
import com.model.Resume;

public class ResumeDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public ResumeDAO() {
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
	
	public void setGoals(Goal goals) {
		sql = "INSERT INTO goals VALUES (?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, goals.getUser_id());
			ps.setString(2, goals.getGoals());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert goals on Oracle\n" + e);
		}
	}
	
	public void setAcademicTraining(AcademicTraining acad_train) {
		sql = "INSERT INTO academictraining VALUES (?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, acad_train.getUser_id());
			ps.setDate(2, acad_train.getStart_date());
			ps.setDate(3, acad_train.getEnd_date());
			ps.setString(4,acad_train.getInstitution());
			ps.setString(5, acad_train.getCourse());
			ps.execute();
		}catch(SQLException e){
			System.out.println("Error during inserting academictraining on Oracle\n" + e);
		}
	}
	
	public void setProfessionalExperience(ProfessionalExperience prof_exp) {
		sql = "INSERT INTO professionalexperience VALUES (?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, prof_exp.getUser_id());
			ps.setString(2,prof_exp.getJobtitle());
			ps.setString(3, prof_exp.getEmployer());
			ps.setDate(4, prof_exp.getStart_date());
			ps.setDate(5, prof_exp.getEnd_date());
			ps.setString(6, prof_exp.getJobdescription());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during inserting professionalexperience on Oracle\n" + e);
		}
	}
	
	public void setLanguages(Language lang) {
		sql = "INSERT INTO languages VALUES(?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, lang.getUser_id());
			ps.setString(2, lang.getLanguage_1());
			ps.setString(3, lang.getLanguage_2());
			ps.setString(4, lang.getLanguage_3());
			ps.setString(5, lang.getLanguage_4());
			ps.setString(6, lang.getLanguage_5());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during inserting professionalexperience on Oracle\n" + e);
		}
	}
	
	public void setExtracurricularCourses(ExtracurricularCourse ext_crs) {
		sql = "INSERT INTO extracurricularcourses VALUES(?,?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, ext_crs.getUser_id());
			ps.setString(2, ext_crs.getCourse_1());
			ps.setString(3, ext_crs.getCourse_2());
			ps.setString(4, ext_crs.getCourse_3());
			ps.setString(5, ext_crs.getCourse_4());
			ps.setString(6, ext_crs.getCourse_5());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during inserting professionalexperience on Oracle\n" + e);
		}
	}
	
	public List<Resume> retrieveUserResume(String email){
		List<Resume> resumes = new ArrayList<>();
		sql = "SELECT * FROM resumeform WHERE email_user = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			while(rs.next()) {
				resumes.add(new Resume(rs.getString("goal"),rs.getString("academic_training"),rs.getString("professional_experience"),rs.getString("languages"),rs.getString("extracurricular_courses")));
			}
		}catch(SQLException e) {
			System.out.println("Error retrieving user resume on Oracle\n" + e);
		}finally {
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
		return resumes;
	}

	public boolean resumeExists(int user_id) {
		boolean exists = false;
		sql = "SELECT goals.goal, academictraining.start_date \"start_date_academic\", academictraining.end_date \"end_date_academic\", academictraining.institution, professionalexperience.jobtitle, professionalexperience.employer, professionalexperience.start_date \"start_date_professional\", professionalexperience.end_date \"end_date_professional\", professionalexperience.job_description, languages.language_1, languages.language_2, languages.language_3, languages.language_4, languages.language_5, extracurricularcourses.course_1, extracurricularcourses.course_2, extracurricularcourses.course_3, extracurricularcourses.course_4, extracurricularcourses.course_5 FROM userform JOIN goals ON goals.goal_id = userform.user_id JOIN academictraining ON academictraining.at_id = userform.user_id JOIN professionalexperience ON professionalexperience.pe_id = userform.user_id JOIN languages ON languages.lang_id = userform.user_id JOIN extracurricularcourses ON extracurricularcourses.ec_id = userform.user_id WHERE userform.user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				exists = true;
			}
		}catch(SQLException e) {
			System.out.println("Error during check if resumeform exists on Oracle\n" + e);
		}
		return exists;
	}
}
