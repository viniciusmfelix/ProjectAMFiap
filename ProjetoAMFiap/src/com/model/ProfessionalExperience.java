package com.model;

import java.sql.Date;

public class ProfessionalExperience {
	private int user_id;
	private String jobtitle;
	private String employer;
	private String jobdescription;
	private Date start_date;
	private Date end_date;
	
	public ProfessionalExperience() {
		
	}
	
	public ProfessionalExperience(int user_id, String jobtitle, String employer, String jobdescription, Date start_date,
			Date end_date) {
		super();
		this.user_id = user_id;
		this.jobtitle = jobtitle;
		this.employer = employer;
		this.jobdescription = jobdescription;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getJobtitle() {
		return jobtitle;
	}
	
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	
	public String getEmployer() {
		return employer;
	}
	
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	
	public String getJobdescription() {
		return jobdescription;
	}
	
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}
	
	public Date getStart_date() {
		return start_date;
	}
	
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	
	public Date getEnd_date() {
		return end_date;
	}
	
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	
}