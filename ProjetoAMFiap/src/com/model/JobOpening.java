package com.model;

public class JobOpening {
	private int jo_code;
	private String name;
	private String description;
	
	public JobOpening() {
		
	}

	public JobOpening(int jo_code, String name, String description) {
		super();
		this.jo_code = jo_code;
		this.name = name;
		this.description = description;
	}

	public int getJo_code() {
		return jo_code;
	}

	public void setJo_code(int jo_code) {
		this.jo_code = jo_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
