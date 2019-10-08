package com.model;

import java.sql.Date;

public class Employee {
	private int employee_code;
	private String firstname;
	private String lastname;
	private String email;
	private Date date;
	private String phone;
	private String password;
	
	public Employee() {
		
	}
	
	public Employee(int employee_code, String firstname, String lastname, String email, Date date,String phone, String password) {
		super();
		this.employee_code = employee_code;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.date = date;
		this.phone = phone;
		this.password = password;
	}
	
	public Employee(String firstname, String lastname, String email, Date date,String phone, String password) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.date = date;
		this.phone = phone;
		this.password = password;
	}

	public int getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(int employee_code) {
		this.employee_code = employee_code;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
