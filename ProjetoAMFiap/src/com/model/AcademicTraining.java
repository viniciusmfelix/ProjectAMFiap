package com.model;

import java.sql.Date;


public class AcademicTraining {
	private int user_id;
	private int at_id;
	private Date start_date;
	private Date end_date;
	private String institution;
	private String course;
	private String description;
	
	public AcademicTraining(int user_id, int at_id, Date start_date, Date end_date, String institution, String course, String description) {
		super();
		this.user_id = user_id;
		this.at_id = at_id;
		this.institution = institution;
		this.course = course;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
	}
	
	public AcademicTraining(int user_id, Date start_date, Date end_date, String institution, String course, String description) {
		super();
		this.user_id = user_id;
		this.institution = institution;
		this.course = course;
		this.start_date = start_date;
		this.end_date = end_date;
		this.description = description;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAt_id() {
		return at_id;
	}

	public void setAt_id(int at_id) {
		this.at_id = at_id;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return "AcademicTraining [user_id=" + user_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", institution=" + institution + ", course=" + course + ", description=" + description + "]";
	}
	
}
