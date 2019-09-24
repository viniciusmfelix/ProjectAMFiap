package com.model;

public class Employee {
	private int employee_code;
	private String name;
	private String lastname;
	private String email;
	private String password;
	
	public Employee() {
		
	}
	
	public Employee(int employee_code, String name, String lastname, String email, String password) {
		super();
		this.employee_code = employee_code;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}

	public int getEmployee_code() {
		return employee_code;
	}

	public void setEmployee_code(int employee_code) {
		this.employee_code = employee_code;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
