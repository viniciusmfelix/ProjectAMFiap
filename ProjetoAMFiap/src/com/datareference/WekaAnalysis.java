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
	
	public List<User> selectAppropriateApply(int jo_code) {
		List<User> users = new ArrayList<>();
		sql = "SELECT * FROM user_jobopening JOIN resumeform ON resumeform.email_user = user_jobopening.email JOIN userform ON userform.email = user_jobopening.email WHERE user_jobopening.jo_code = ?";
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
					new_instance.setValue(0, rs.getString("goal"));
					new_instance.setValue(1, rs.getString("academic_training"));
					new_instance.setValue(2, rs.getString("professional_experience"));
					new_instance.setValue(3, rs.getString("languages"));
					new_instance.setValue(4, rs.getString("extracurricular_courses"));
					
					double[] prediction_vector = nb.distributionForInstance(new_instance);
					double prediction_1 = prediction_vector[0];
					double prediction_2 = prediction_vector[1];
					
					if(prediction_1 > prediction_2) {
						users.add(new User(rs.getString("firstname"),rs.getString("lastname"),rs.getString("email"),rs.getString("phone"),prediction_1));
					}
				} catch (Exception e) {
					System.out.println("Error during I.A. profile analysis.\n" + e);
				}
			}
		}catch(SQLException e) {
			System.out.println("Error during retrievement of applied users on Oracle\n"+e);
		}
		return users;
	}
}
