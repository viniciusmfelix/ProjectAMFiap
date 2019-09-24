package com.model;

public class User {
	private String name;
	private String lastname;
	private String email;
	private String telephone;
	private String password;
	
	public User() {
		
	}

	public User(String name, String lastname, String email, String telephone, String password) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
