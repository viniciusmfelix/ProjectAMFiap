package com.model;

import java.sql.Date;

public class User {
	private int user_id;
	private String firstname;
	private String lastname;
	private String email;
	private Date born_date;
	private String telephone;
	private String password;
	private double ia_score;
	
	public User() {
		
	}
	
	public User(String firstname, String lastname, String email, String telephone,double ia_score) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
		this.ia_score = ia_score;
	}

	public User(int user_id, String firstname, String lastname, String email, Date born_date ,String telephone, String password) {
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.born_date = born_date;
		this.telephone = telephone;
		this.password = password;
	}
	
	public User(String firstname, String lastname, String email, Date born_date ,String telephone, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.born_date = born_date;
		this.telephone = telephone;
		this.password = password;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
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

	public Date getBorn_date() {
		return born_date;
	}

	public void setBorn_date(Date born_date) {
		this.born_date = born_date;
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

	public double getIa_score() {
		return ia_score;
	}

	public void setIa_score(double ia_score) {
		this.ia_score = ia_score;
	}
	
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", born_date=" + born_date + ", telephone=" + telephone + ", password=" + password + ", ia_score="
				+ ia_score + "]";
	}
	
}
