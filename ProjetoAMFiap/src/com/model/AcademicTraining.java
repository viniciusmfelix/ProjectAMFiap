package com.model;

import java.sql.Date;


public class AcademicTraining {
	private int user_id;
	private String institution;
	private String course;
	private Date start_date;
	private Date end_date;
	
	
	public AcademicTraining(int user_id, String institution, String course, Date start_date, Date end_date) {
		super();
		this.user_id = user_id;
		this.institution = institution;
		this.course = course;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
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
