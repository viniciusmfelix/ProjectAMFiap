package com.datareference;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import weka.classifiers.bayes.NaiveBayes;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import weka.filters.unsupervised.attribute.StringToNominal;

import com.dbconnection.ConnectToOracle;
import com.model.User;

public class WekaAnalysis {
	
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sql;
	
	public WekaAnalysis() {
		this.connection = new ConnectToOracle().connect();
	}
	
	public User selectAppropriateProfession(int jo_code) {
		User best_user = new User();
		sql = "SELECT user_jobopening.user_id, userform.firstname, userform.lastname, userform.email, userform.born_date, userform.phone, userform.accesspassword, profession.profession_name,academictraining.course, professionalexperience.jobtitle, languages.lang, languages.lang_level, extracurricularcourses.extc_course, extracurricularcourses.course_level FROM user_jobopening JOIN userform ON userform.user_id = user_jobopening.user_id JOIN profession ON userform.user_id = profession.profession_id JOIN academictraining ON academictraining.user_id = user_jobopening.user_id JOIN professionalexperience ON professionalexperience.user_id = user_jobopening.user_id JOIN languages ON languages.user_id = user_jobopening.user_id JOIN extracurricularcourses ON extracurricularcourses.user_id = user_jobopening.user_id WHERE user_jobopening.job_id = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			rs = ps.executeQuery();
			if(rs.next()) {
				try {
					DataSource ds = new DataSource("data_reference_ia.arff");
					Instances ins = ds.getDataSet();
					ins.setClassIndex(ins.numAttributes() - 1);
					NaiveBayes nb = new NaiveBayes();
					nb.buildClassifier(ins);
					Instance new_instance = new DenseInstance(5);
					new_instance.setDataset(ins);
					ins.add(new_instance);
					
					String profession = rs.getString("profession_name");
					String course = rs.getString("course");
					String jobtitle = rs.getString("jobtitle");
					String lang = rs.getString("lang");
					String lang_level = rs.getString("lang_level");
					String skill = rs.getString("extc_course");
					String skill_level = rs.getString("course_level");
					
					new_instance.setValue(0, "Backenddeveloper");
					new_instance.setValue(1, "Sistemasdeinformacao");
					new_instance.setValue(2, "Analistadesistemaspl");
					new_instance.setValue(3, "Ingles");
					new_instance.setValue(4, "Java");
					
					double[] prediction_vector = nb.distributionForInstance(new_instance);
					double prediction_1 = prediction_vector[0];
					double prediction_2 = prediction_vector[1];
					
					if(prediction_1 > prediction_2) {
						best_user = new User(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("phone"),prediction_1);
					}
				} catch (Exception e) {
					System.out.println("Error during I.A. profile analysis.\n" + e);
				}
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement of applied users on Oracle\n"+e);
		} 
		System.out.println(best_user.toString());
		return best_user;
	}
	
	public List<User> selectRefusedApply(int jo_code) {
		List<User> users = new ArrayList<>();
		sql = "SELECT * FROM user_jobopening JOIN resumeform ON resumeform.email_user = user_jobopening.email JOIN userform ON userform.email = user_jobopening.email WHERE user_jobopening.jo_code = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, jo_code);
			rs = ps.executeQuery();
			while(rs.next()) {
				try {
					DataSource ds = new DataSource("data_reference_ia.arff");
					Instances ins = ds.getDataSet();
					ins.setClassIndex(ins.numAttributes() - 1);
					NaiveBayes nb = new NaiveBayes();
					nb.buildClassifier(ins);
					Instance new_instance = new DenseInstance(5);
					new_instance.setDataset(ins);
					ins.add(new_instance);
					new_instance.setValue(0, rs.getString("goal"));
					new_instance.setValue(1, rs.getString("academic_training"));
					new_instance.setValue(2, rs.getString("professional_experience"));
					new_instance.setValue(3, rs.getString("languages"));
					new_instance.setValue(4, rs.getString("extracurricular_courses"));
					
					double[] prediction_vector = nb.distributionForInstance(new_instance);
					double prediction_1 = prediction_vector[0];
					double prediction_2 = prediction_vector[1];
					
					if(prediction_2 > prediction_1) {
						users.add(new User(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("phone"),prediction_1));
						
					}
				} catch (Exception e) {
					System.out.println("Error during I.A. profile analysis.\n" + e);
				}
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement of applied users on Oracle\n"+e);
		} 
		System.out.println(users.toString());
		return users;
	}
}
