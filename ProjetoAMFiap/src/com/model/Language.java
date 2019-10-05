package com.model;

public class Language {
	private int user_id;
	private String language;
	

	public Language(int user_id, String language_1) {
		super();
		this.user_id = user_id;
		this.language = language_1;
	}
	
	public Language() {
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Override
	public String toString() {
		return "Language [user_id=" + user_id + ", language=" + language + "]";
	}
	
	
}