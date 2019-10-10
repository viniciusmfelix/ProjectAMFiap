package com.model;

public class Bio {
	private int user_id;
	private String description;
	
	public Bio() {
		
	}
	
	public Bio(int user_id, String description) {
		super();
		this.user_id = user_id;
		this.description = description;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Bio [user_id=" + user_id + ", description=" + description + "]";
	}
	
}
