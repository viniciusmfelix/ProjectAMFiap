package com.model;

public class Profession {
	private int user_id;
	private String profession;
	
	public Profession(int user_id, String profession) {
		super();
		this.user_id = user_id;
		this.profession = profession;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

}
