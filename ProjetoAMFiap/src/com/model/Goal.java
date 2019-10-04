package com.model;

public class Goal {
	private int user_id;
	private String goals;
	
	public Goal(int user_id, String goals) {
		super();
		this.user_id = user_id;
		this.goals = goals;
	}

	public Goal() {
		super();
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getGoals() {
		return goals;
	}

	public void setGoals(String goals) {
		this.goals = goals;
	}
	
	
}
