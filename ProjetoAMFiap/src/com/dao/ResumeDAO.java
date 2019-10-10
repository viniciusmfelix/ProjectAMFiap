 package com.dao;

import java.sql.Connection;
import java.sql.Date;
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
import com.model.Language;
import com.model.Location;
import com.model.Profession;
import com.model.ProfessionalExperience;

public class ResumeDAO {
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public ResumeDAO() {
		this.connection = new ConnectToOracle().connect();
	}
	
	public int retrieveAcademicTrainingId(String institution, String course, int user_id) {
		int academic_id = 0;
		sql = "SELECT at_id FROM academictraining WHERE course = ? AND institution = ? AND user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, course);
			ps.setString(2, institution);
			ps.setInt(3, user_id);
			rs = ps.executeQuery();
			if(rs.next()) academic_id = rs.getInt("at_id");
			System.out.println(academic_id);
		}catch(SQLException e) {
			System.out.println("Error during retrieving academic training id on Oracle\n" + e);
		}
		return academic_id;
	}
	
	public void setAcademicTraining(List<AcademicTraining> acad_train) {
		Iterator<AcademicTraining> iterator = acad_train.iterator();
		while(iterator.hasNext()) {
			AcademicTraining at = iterator.next();
			sql = "INSERT INTO academictraining VALUES (at_id.nextval,?,?,?,?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setDate(1, at.getStart_date());
				ps.setDate(2, at.getEnd_date());
				ps.setString(3,at.getInstitution());
				ps.setString(4, at.getCourse());
				ps.setString(5, at.getDescription());
				ps.setInt(6, at.getUser_id());
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
	
	public List<AcademicTraining> retrieveAcademicTraining(int user_id){
		List<AcademicTraining> academy_list = new ArrayList<>();
		sql = "SELECT academictraining.start_date, academictraining.end_date, academictraining.institution, academictraining.course, academictraining.at_description FROM academictraining WHERE user_id = ?";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, user_id);
				rs = ps.executeQuery();
				while(rs.next()) {
					academy_list.add(new AcademicTraining(user_id, rs.getDate("start_date"), rs.getDate("end_date"),rs.getString("institution"), rs.getString("course"),rs.getString("at_description")));
					}
			}catch(SQLException e) {
				System.out.println("Error retrieving user academic training on Oracle\n" + e);
			}
		return academy_list;
	}
	
	public void deleteAcademicTraining(List<AcademicTraining> acad_train) {
		Iterator<AcademicTraining> at = acad_train.iterator();
		while(at.hasNext()) {
			AcademicTraining iterator = at.next();
			sql = "DELETE FROM academictraining WHERE at_id = ?";
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, iterator.getAt_id());
				System.out.println(iterator.getAt_id());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during delete academic training on Oracle\n" + e +" On loop: " + at.toString());
			}
		}
	}
	
	public int retrieveProfessionalExperienceId(String jobtitle, String employer, Date startdate, int user_id) {
		int professional_id = 0;
		sql = "SELECT pe_id FROM professionalexperience WHERE jobtitle = ? AND employer = ? AND start_date = ? AND user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, jobtitle);
			ps.setString(2, employer);
			ps.setDate(3, startdate);
			ps.setInt(4, user_id);
			rs = ps.executeQuery();
			if(rs.next()) professional_id = rs.getInt("pe_id");
		}catch(SQLException e) {
			System.out.println("Error during retrieving professional experience id on Oracle\n" + e);
		}
		return professional_id;
	}
	
	public void setProfessionalExperience(List<ProfessionalExperience> prof_exp) {
		Iterator<ProfessionalExperience> iterator = prof_exp.iterator();
		while(iterator.hasNext()) {
			ProfessionalExperience at = iterator.next();
			sql = "INSERT INTO professionalexperience VALUES (professional_id.nextval,?,?,?,?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1,at.getJobtitle());
				ps.setString(2, at.getEmployer());
				ps.setDate(3, at.getStart_date());
				ps.setDate(4, at.getEnd_date());
				ps.setString(5, at.getJobdescription());
				ps.setInt(6, at.getUser_id()); 
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during inserting professionalexperience on Oracle\n" + e + "\nOn loop: " + at.toString());
			}
		}
	}
	
	public void updateProfessionalExperience(List<ProfessionalExperience> prof_exp) {
		Iterator<ProfessionalExperience> at = prof_exp.iterator();
		while(at.hasNext()) {
			ProfessionalExperience iterator = at.next();
			sql = "UPDATE professionalexperience SET jobtitle = ?, employer = ?, start_date = ?, end_date = ?,job_description = ? WHERE pe_id = ? AND user_id = ?";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, iterator.getJobtitle());
				ps.setString(2, iterator.getEmployer());
				ps.setDate(3, iterator.getStart_date());
				ps.setDate(4, iterator.getEnd_date());
				ps.setString(5, iterator.getJobdescription());
				ps.setInt(6, iterator.getProfessional_id());
				ps.setInt(7, iterator.getUser_id());
				ps.execute();
				System.out.println("Agora aqui");
			}catch(SQLException e) {
				System.out.println("Error during update Professional Experience on Oracle\n" + e);
			}
		}
	}
	
	public List<ProfessionalExperience> retrieveProfessionalExperience(int user_id){
		List<ProfessionalExperience> profession_list = new ArrayList<>();
		sql = "SELECT professionalexperience.pe_id, professionalexperience.jobtitle, professionalexperience.employer, professionalexperience.start_date, professionalexperience.end_date, professionalexperience.job_description FROM professionalexperience WHERE user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				profession_list.add(new ProfessionalExperience(user_id, rs.getInt("pe_id"),rs.getString("jobtitle"), rs.getString("employer"),rs.getDate("start_date"), rs.getDate("end_date"),rs.getString("job_description")));
				}
		}catch(SQLException e) {
			System.out.println("Error retrieving user professional experiences on Oracle\n" + e);
		}
		return profession_list;
	}
	
	public void deleteProfessionalExperience(List<ProfessionalExperience> prof_exp) {
		Iterator<ProfessionalExperience> at = prof_exp.iterator();
		while(at.hasNext()) {
			sql = "DELETE FROM professionalexperience WHERE pe_id = ?";
			ProfessionalExperience iterator = at.next();
			try {
				ps = connection.prepareStatement(sql);
				ps.setInt(1, iterator.getProfessional_id());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during delete professional experience on Oracle\n" + e);
			}
		}
	}
	
	public int returnLangId(String lang, String level, int user_id) {
		int lang_id = 0;
		sql = "SELECT lang_id FROM languages WHERE lang = ? AND lang_level = ? AND user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, lang);
			ps.setString(2, level);
			ps.setInt(3, user_id);
			rs = ps.executeQuery();
			if(rs.next()) lang_id = rs.getInt("lang_id");
		}catch(SQLException e) {
			System.out.println("Error during retrieve lang id on Oracle\n" + e);
		}
		return lang_id;
	}
	
	public void setLanguages(List<Language> lang) {
		for (Language language : lang) {
			System.out.println(language.toString());
		}
		Iterator<Language> iterator = lang.iterator();
		while(iterator.hasNext()) {
			Language at = iterator.next();
			sql = "INSERT INTO languages VALUES(lang_id.nextval,?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, at.getLanguage());
				ps.setString(2, at.getLevel());
				ps.setInt(3, at.getUser_id());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during inserting languages on Oracle\n" + e + "\nOn loop: " + at.toString());
			}
		}
	}
	
	public List<Language> retrieveLanguage(int user_id){
		List<Language> lang_list = new ArrayList<>();
		sql = "SELECT languages.lang_id, languages.lang, languages.lang_level FROM languages WHERE user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				lang_list.add(new Language(user_id, rs.getInt("lang_id"),rs.getString("lang"),rs.getString("lang_level")));
				}
		}catch(SQLException e) {
			System.out.println("Error retrieving user languages on Oracle\n" + e);
		}
		return lang_list;
	}
	
	public void updateLanguage(List<Language> language) {
		Iterator<Language> at = language.iterator();
		while(at.hasNext()) {
			Language iterator = at.next();
			sql = "UPDATE languages SET lang = ?, lang_level = ? WHERE lang_id = ? AND user_id = ?";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, iterator.getLanguage());
				ps.setString(2, iterator.getLevel());
				ps.setInt(3, iterator.getLang_id());
				ps.setInt(4, iterator.getUser_id());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during update Languages on Oracle\n" + e);
			}
		}
	}
	
	public void deleteLanguage(List<Language> language, int user_id) {
		Iterator<Language> at = language.iterator();
		while(at.hasNext()) {
			Language iterator = at.next();
			sql = "DELETE FROM languages WHERE lang = ? AND lang_level = ? AND user_id = ?";
			System.out.println("Chegou");
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, iterator.getLanguage());
				ps.setString(2, iterator.getLevel());
				ps.setInt(3, user_id);
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during delete language on Oracle\n" + e);
			}
		}
	}
	
	public int returnSkillId(String skill, String level, int user_id) {
		int skill_id = 0;
		sql = "SELECT extracurricularcourses.ec_id FROM extracurricularcourses WHERE extc_course = ? AND course_level = ? AND user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, skill);
			ps.setString(2, level);
			ps.setInt(3, user_id);
			rs = ps.executeQuery();
			if(rs.next()) skill_id = rs.getInt("ec_id");
		}catch(SQLException e) {
			System.out.println("Error during retrieve skill id on Oracle\n" + e);
		}
		return skill_id;
	}
	
	public void setExtracurricularCourses(List<ExtracurricularCourse> ext_crs) {
		Iterator<ExtracurricularCourse> iterator = ext_crs.iterator();
		for (ExtracurricularCourse course : ext_crs) {
			System.out.println(course.toString());
		}
		while(iterator.hasNext()) {
			ExtracurricularCourse at = iterator.next();
			sql = "INSERT INTO extracurricularcourses VALUES(course_id.nextval,?,?,?)";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, at.getCourse());
				ps.setString(2, at.getLevel());
				ps.setInt(3, at.getUser_id());
				ps.execute();
				System.out.println("Chegou");
			}catch(SQLException e) {
				System.out.println("Error during inserting extracurricular courses on Oracle\n" + e + "\nOn loop: " + at.toString());
			}
		}
	}
	
	public List<ExtracurricularCourse> retrieveExtracurricularCourse(int user_id){
		List<ExtracurricularCourse> extracrcl_list = new ArrayList<>();
		sql = "SELECT extc_course, course_level, ec_id FROM extracurricularcourses WHERE user_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while(rs.next()) {
				extracrcl_list.add(new ExtracurricularCourse(user_id, rs.getInt("ec_id"),rs.getString("extc_course"),rs.getString("course_level")));
				}
		}catch(SQLException e) {
			System.out.println("Error retrieving user extracurricular courses on Oracle\n" + e);
		}
		return extracrcl_list;
	}
	
	public void updateExtracurricularCourses(List<ExtracurricularCourse> courses) {
		Iterator<ExtracurricularCourse> at = courses.iterator();
		while(at.hasNext()) {
			ExtracurricularCourse iterator = at.next();
			sql = "UPDATE extracurricularcourses SET extc_course = ?, course_level = ? WHERE ec_id = ? AND user_id = ?";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, iterator.getCourse());
				ps.setString(2, iterator.getLevel());
				ps.setInt(3, iterator.getCourse_id());
				ps.setInt(4, iterator.getUser_id());
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during update Skills on Oracle\n" + e);
			}
		}
	}
	
	public void deleteExtracurricularCourse(List<ExtracurricularCourse> courses, int user_id) {
		Iterator<ExtracurricularCourse> at = courses.iterator();
		while(at.hasNext()) {
			ExtracurricularCourse iterator = at.next();
			sql = "DELETE FROM extracurricularcourses WHERE extc_course = ? AND course_level = ? AND user_id = ?";
			System.out.println("Chegou");
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, iterator.getCourse());
				ps.setString(2, iterator.getLevel());
				ps.setInt(3, user_id);
				ps.execute();
			}catch(SQLException e) {
				System.out.println("Error during delete Skills on Oracle\n" + e);
			}
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
	
	public boolean languageExists(List<Language> lang, int user_id) {
		boolean exists = false;
		Iterator<Language> at = lang.iterator();
		while(at.hasNext()) {
			Language iterator = at.next();
			sql = "SELECT lang FROM languages WHERE lang = ? AND lang_id = ? AND user_id = ? ";
			try {
				ps = connection.prepareStatement(sql);
				ps.setString(1, iterator.getLanguage());
				ps.setInt(2, iterator.getLang_id());
				ps.setInt(3, user_id);
				rs = ps.executeQuery();
				if(rs.next()) exists = true;
			}catch(SQLException e) {
				System.out.println("Error during verification if language exists on Oracle\n" + e);
			}
		}
		return exists;
	}

}
