 package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dbconnection.ConnectToOracle;
import com.model.AcademicTraining;
import com.model.Bio;
import com.model.ExtracurricularCourse;
import com.model.Goal;
import com.model.Language;
import com.model.Location;
import com.model.Profession;
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
	
	public void updateGoals(Goal goals) {
		sql = "UPDATE goals SET goals.goal = ? WHERE goals.goal_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, goals.getGoals());
			ps.setInt(2, goals.getUser_id());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update Goals on Oracle\n" + e);
		}
	}
	
	public void setAcademicTraining(List<AcademicTraining> acad_train) {
		Iterator<AcademicTraining> iterator = acad_train.iterator();
		while(iterator.hasNext()) {
			AcademicTraining at = iterator.next();
			sql = "INSERT INTO academictraining VALUES (?,?,?,?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, at.getUser_id());
				ps.setDate(2, at.getStart_date());
				ps.setDate(3, at.getEnd_date());
				ps.setString(4,at.getInstitution());
				ps.setString(5, at.getCourse());
				ps.setString(6, at.getDescription());
				ps.execute();
			}catch(SQLException e){
				System.out.println("Error during inserting academictraining on Oracle\n" + e + "\nOn loop: " + at.toString());
			}
		}
	}
	
	public void updateAcademicTraining(AcademicTraining acad_train,String old_course) {
		sql = "UPDATE academictraining SET start_date = ?, end_date = ?,institution = ?, course = ?, at_description = ? WHERE at_id = ? AND course = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setDate(1, acad_train.getStart_date());
			ps.setDate(2, acad_train.getEnd_date());
			ps.setString(3, acad_train.getInstitution());
			ps.setString(4, acad_train.getCourse());
			ps.setInt(5, acad_train.getUser_id());
			ps.setString(6, old_course);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update Academic Training on Oracle\n" + e);
		}
	}
	
	public void setProfessionalExperience(List<ProfessionalExperience> prof_exp) {
		Iterator<ProfessionalExperience> iterator = prof_exp.iterator();
		while(iterator.hasNext()) {
			ProfessionalExperience at = iterator.next();
			sql = "INSERT INTO professionalexperience VALUES (?,?,?,?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, at.getUser_id());
				ps.setString(2,at.getJobtitle());
				ps.setString(3, at.getEmployer());
				ps.setDate(4, at.getStart_date());
				ps.setDate(5, at.getEnd_date());
				ps.setString(6, at.getJobdescription());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during inserting professionalexperience on Oracle\n" + e + "\nOn loop: " + at.toString());
			}
		}
	}
	
	public void updateProfessionalExperience(ProfessionalExperience prof_exp, String old_job, String old_employer) {
		sql = "UPDATE academictraining SET jobtitle = ?, employer = ?, start_date = ?, end_date = ?,job_description = ? WHERE pe_id = ? AND jobtitle = ? AND employer = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, prof_exp.getJobtitle());
			ps.setString(2, prof_exp.getEmployer());
			ps.setDate(3, prof_exp.getStart_date());
			ps.setDate(4, prof_exp.getEnd_date());
			ps.setString(5, prof_exp.getJobdescription());
			ps.setInt(6, prof_exp.getUser_id());
			ps.setString(7, old_job);
			ps.setString(8, old_employer);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update Professional Experience on Oracle\n" + e);
		}
	}
	
	public void setLanguages(List<Language> lang) {
		for (Language language : lang) {
			System.out.println(language.toString());
		}
		Iterator<Language> iterator = lang.iterator();
		while(iterator.hasNext()) {
			Language at = iterator.next();
			sql = "INSERT INTO languages VALUES(?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, at.getUser_id());
				ps.setString(2, at.getLanguage());
				ps.setString(3, at.getLevel());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during inserting languages on Oracle\n" + e + "\nOn loop: " + at.toString());
			}
		}
	}
	
	public void updateLanguage(Language language, String old_lang) {
		sql = "UPDATE languages SET lang = ?, lang_level = ? WHERE lang_id = ? AND lang = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, language.getLanguage());
			ps.setString(2, language.getLevel());
			ps.setInt(3, language.getUser_id());
			ps.setString(4, old_lang);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update Languages on Oracle\n" + e);
		}
	}
	
	public void setExtracurricularCourses(List<ExtracurricularCourse> ext_crs) {
		Iterator<ExtracurricularCourse> iterator = ext_crs.iterator();
		while(iterator.hasNext()) {
			ExtracurricularCourse at = iterator.next();
			sql = "INSERT INTO extracurricularcourses VALUES(?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, at.getUser_id());
				ps.setString(2, at.getCourse());
				ps.setString(3, at.getLevel());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during inserting extracurricular courses on Oracle\n" + e + "\nOn loop: " + at.toString());
			}
		}
	}
	
	public void updateExtracurricularCourse(ExtracurricularCourse course, String old_course) {
		sql = "UPDATE extracurricularcourses SET extc_course = ?, course_level = ? WHERE ec_id = ? AND extc_course = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, course.getCourse());
			ps.setString(2, course.getLevel());
			ps.setInt(3, course.getUser_id());
			ps.setString(4, old_course);
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update extracurricular courses on Oracle\n" + e);
		}
	}
	
	public void setLocation(Location location) {
		sql = "INSERT INTO locations VALUES (?,?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, location.getUser_id());
			ps.setString(2, location.getCountry());
			ps.setString(3, location.getAddress());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert location on Oracle\n" + e);
		}
	}
	
	public void updateLocation(Location location) {
		sql = "UPDATE locations SET locations.country = ?, locations.address = ? WHERE locations.location_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, location.getCountry());
			ps.setString(2, location.getAddress());
			ps.setInt(3, location.getUser_id());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update locations on Oracle\n" + e);
		}
	}
	
	public void setBio(Bio bio) {
		sql = "INSERT INTO bio VALUES (?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, bio.getUser_id());
			ps.setString(2, bio.getDescription());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert bio on Oracle\n" + e);
		}
	}
	
	public void updateBio(Bio bio) {
		sql = "UPDATE bio SET bio_description = ? WHERE bio_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, bio.getDescription());
			ps.setInt(2, bio.getUser_id());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update bio on Oracle\n" + e);
		}
	}
	
	public void setProfession(Profession profession) {
		sql = "INSERT INTO profession VALUES (?,?)";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, profession.getUser_id());
			ps.setString(2, profession.getProfession());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during insert profession on Oracle\n" + e);
		}
	}
	
	public void updateProfession(Profession profession) {
		sql = "UPDATE profession SET profession.profession_name = ? WHERE profession_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, profession.getProfession());
			ps.setInt(2, profession.getUser_id());
			ps.execute();
		}catch(SQLException e) {
			System.out.println("Error during update profession on Oracle\n" + e);
		}
	}
	
	public Goal retrieveGoal(int user_id) {
		Goal goal = new Goal();
		sql = "SELECT goals.goal FROM goals WHERE goal_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
				if(rs.next()) {
					goal = new Goal(user_id, rs.getString("goal"));
					}
			}catch(SQLException e) {
				System.out.println("Error retrieving user academic training on Oracle\n" + e);
			}
		return goal;
	}
	
	public List<AcademicTraining> retrieveAcademicTraining(int user_id){
		List<AcademicTraining> academy_list = new ArrayList<>();
		sql = "SELECT academictraining.start_date, academictraining.end_date, academictraining.institution, academictraining.course, academictraining.at_description FROM academictraining WHERE at_id = ?";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					academy_list.add(new AcademicTraining(user_id, rs.getDate("start_date"), rs.getDate("end_date"),rs.getString("institution"), rs.getString("course"),rs.getString("description")));
					}
			}catch(SQLException e) {
				System.out.println("Error retrieving user academic training on Oracle\n" + e);
			}
		return academy_list;
	}
	
	public List<ProfessionalExperience> retrieveProfessionalExperience(int user_id){
		List<ProfessionalExperience> profession_list = new ArrayList<>();
		sql = "SELECT professionalexperience.jobtitle, professionalexperience.employer, professionalexperience.start_date, professionalexperience.end_date, professionalexperience.job_description FROM professionalexperience WHERE pe_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				profession_list.add(new ProfessionalExperience(user_id, rs.getString("jobtitle"), rs.getString("employer"),rs.getDate("start_date"), rs.getDate("end_date"),rs.getString("job_description")));
				}
		}catch(SQLException e) {
			System.out.println("Error retrieving user professional experiences on Oracle\n" + e);
		}
		return profession_list;
	}
	
	public List<Language> retrieveLanguage(int user_id){
		List<Language> lang_list = new ArrayList<>();
		sql = "SELECT languages.lang, languages.lang_level FROM languages WHERE lang_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				lang_list.add(new Language(user_id, rs.getString("lang"),rs.getString("lang_level")));
				}
		}catch(SQLException e) {
			System.out.println("Error retrieving user languages on Oracle\n" + e);
		}
		return lang_list;
	}
	
	public List<ExtracurricularCourse> retrieveExtracurricularCourse(int user_id){
		List<ExtracurricularCourse> extracrcl_list = new ArrayList<>();
		sql = "SELECT extracurricularcourses.extc_course, extracurricularcourses.course_level FROM extracurricularcourses WHERE ec_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				extracrcl_list.add(new ExtracurricularCourse(user_id, rs.getString("extc_course"),rs.getString("couse_level")));
				}
		}catch(SQLException e) {
			System.out.println("Error retrieving user extracurricular courses on Oracle\n" + e);
		}
		return extracrcl_list;
	}
	
	public Location retrieveLocation(int user_id) {
		Location location = new Location();
		sql = "SELECT locations.country, locations.address FROM locations WHERE location_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
				if(rs.next()) {
					location = new Location(user_id, rs.getString("country"), rs.getString("address"));
					}
			}catch(SQLException e) {
				System.out.println("Error retrieving user location on Oracle\n" + e);
			}
		return location;
	}
	
	public Bio retrieveBio(int user_id) {
		Bio bio = new Bio();
		sql = "SELECT bio.bio_description FROM bio WHERE bio.bio_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) bio = new Bio(user_id,rs.getString("bio_description"));
		}catch(SQLException e) {
			System.out.println("Error during retrievement of bio on Oracle\n" + e);
		}
		return bio;
	}
	
	public Profession retrieveProfession(int user_id) {
		Profession profession = new Profession();
		sql = "SELECT profession.profession_name FROM profession WHERE profession_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) profession = new Profession(user_id, rs.getString("profession_name"));
		}catch(SQLException e) {
			System.out.println("Error during retrieve profession on Oracle\n" + e);
		}
		return profession;
	}
	
	public boolean professionExists(int user_id) {
		boolean exists = false;
		sql = "SELECT * FROM profession WHERE profession_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) exists = true;
		}catch(SQLException e) {
			System.out.println("Error during verification if profession exists on Oracle\n" + e);
		}
		return exists;
	}
	
	public boolean locationExists(int user_id) {
		boolean exists = false;
		sql = "SELECT * FROM locations WHERE location_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) exists = true;
		}catch(SQLException e) {
			System.out.println("Error during verification if location exists on Oracle\n" + e);
		}
		return exists;
	}
	
	public boolean bioExists(int user_id) {
		boolean exists = false;
		sql = "SELECT * FROM bio WHERE bio_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			if(rs.next()) exists = true;
		}catch(SQLException e) {
			System.out.println("Error during verification if bio exists on Oracle\n" + e);
		}
		return exists;
	}
	
	public Resume retrieveResume(Goal goal, List<AcademicTraining> academy_list, List<ProfessionalExperience> profession_list, List<Language> lang_list, List<ExtracurricularCourse> extracrcl_list, Location location, Bio bio, Profession profession) {
		return new Resume(goal,academy_list,profession_list,lang_list,extracrcl_list,location,bio,profession);
	}

	public boolean resumeExists(int user_id) {
		boolean exists = false;
		sql = "SELECT userform.firstname, userform.lastname, userform.email, userform.born_date, userform.phone, academictraining.start_date \"academy_start_date\", academictraining.end_date \"academy_end_date\", academictraining.institution, academictraining.course, academictraining.at_description, professionalexperience.jobtitle, professionalexperience.employer, professionalexperience.start_date \"job_start_date\", professionalexperience.end_date \"job_end_date\", professionalexperience.job_description,languages.lang, extracurricularcourses.extc_course FROM userform INNER JOIN academictraining ON academictraining.at_id = userform.user_id INNER JOIN professionalexperience ON professionalexperience.pe_id = userform.user_id INNER JOIN languages ON lang_id = userform.user_id INNER JOIN extracurricularcourses ON extracurricularcourses.ec_id = userform.user_id WHERE userform.user_id = ?";
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
