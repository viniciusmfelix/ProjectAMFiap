package com.model;

public class ExtracurricularCourse {
	private int user_id;
	private String course;

	public ExtracurricularCourse(int user_id, String course) {
		super();
		this.user_id = user_id;
		this.course = course;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "ExtracurricularCourse [user_id=" + user_id + ", course=" + course + "]";
	}

}
