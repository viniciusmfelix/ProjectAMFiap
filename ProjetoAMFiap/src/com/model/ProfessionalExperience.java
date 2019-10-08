package com.model;

import java.sql.Date;

public class ProfessionalExperience {
	private int user_id;
	private int professional_id;
	private String jobtitle;
	private String employer;
	private Date start_date;
	private Date end_date;
	private String jobdescription;
	
	public ProfessionalExperience() {
		
	}
	
	public ProfessionalExperience(int user_id, String jobtitle, String employer, Date startdate, Date enddate, String description) {
        super();
        // TODO Auto-generated constructor stub
        this.user_id = user_id;
		this.jobtitle = jobtitle;
		this.employer = employer;	
		this.start_date = startdate;
		this.end_date = enddate;
		this.jobdescription = description;
    }
	
	public ProfessionalExperience(int user_id, int professional_id, String jobtitle, String employer, Date start_date,Date end_date, String jobdescription) {
		super();
		this.user_id = user_id;
		this.professional_id = professional_id;
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

	public int getProfessional_id() {
		return professional_id;
	}

	public void setProfessional_id(int professional_id) {
		this.professional_id = professional_id;
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

	@Override
	public String toString() {
		return "ProfessionalExperience [user_id=" + user_id + ", jobtitle=" + jobtitle + ", employer=" + employer
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", jobdescription=" + jobdescription + "]";
	}
	
}
