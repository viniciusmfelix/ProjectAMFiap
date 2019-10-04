package com.model;

public class Language {
	private int user_id;
	private String language_1;
	private String language_2;
	private String language_3;
	private String language_4;
	private String language_5;
	
	public Language(int user_id, String language_1, String language_2, String language_3, String language_4, String language_5) {
		super();
		this.user_id = user_id;
		this.language_1 = language_1;
		this.language_2 = language_2;
		this.language_3 = language_3;
		this.language_4 = language_4;
		this.language_5 = language_5;
	}

	public Language(int user_id, String language_1, String language_2, String language_3, String language_4) {
		super();
		this.user_id = user_id;
		this.language_1 = language_1;
		this.language_2 = language_2;
		this.language_3 = language_3;
		this.language_4 = language_4;
	}

	public Language(int user_id, String language_1, String language_2, String language_3) {
		super();
		this.user_id = user_id;
		this.language_1 = language_1;
		this.language_2 = language_2;
		this.language_3 = language_3;
	}

	public Language(int user_id, String language_1, String language_2) {
		super();
		this.user_id = user_id;
		this.language_1 = language_1;
		this.language_2 = language_2;
	}

	public Language(int user_id, String language_1) {
		super();
		this.user_id = user_id;
		this.language_1 = language_1;
	}
	
	public Language() {
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getLanguage_1() {
		return language_1;
	}

	public void setLanguage_1(String language_1) {
		this.language_1 = language_1;
	}

	public String getLanguage_2() {
		return language_2;
	}

	public void setLanguage_2(String language_2) {
		this.language_2 = language_2;
	}

	public String getLanguage_3() {
		return language_3;
	}

	public void setLanguage_3(String language_3) {
		this.language_3 = language_3;
	}

	public String getLanguage_4() {
		return language_4;
	}

	public void setLanguage_4(String language_4) {
		this.language_4 = language_4;
	}

	public String getLanguage_5() {
		return language_5;
	}

	public void setLanguage_5(String language_5) {
		this.language_5 = language_5;
	}

}
