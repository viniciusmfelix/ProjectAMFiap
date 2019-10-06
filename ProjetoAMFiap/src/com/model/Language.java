package com.model;

public class Language {
	private int user_id;
	private String language;
	private String level;

	public Language(int user_id, String language,String level) {
		super();
		this.user_id = user_id;
		this.language = language;
		this.level = level;
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
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Language [user_id=" + user_id + ", language=" + language + "]";
	}
	
	
}