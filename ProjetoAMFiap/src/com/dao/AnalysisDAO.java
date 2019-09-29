package com.dao;


import java.util.List;
import com.model.User;

public class AnalysisDAO {
	
	public AnalysisDAO(){
	}
	
	public User getBestUser(List<User> users) {
		User best_user = users.get(0);
		for (User user : users) {
			if(user.getIa_score() > best_user.getIa_score()) {
				best_user = user;
			}
		}
		return best_user;
	}
}
