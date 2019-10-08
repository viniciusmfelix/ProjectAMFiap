package com.model;

public class ExtracurricularCourse {
	private int user_id;
	private int course_id;
	private String course;
	private String level;

	public ExtracurricularCourse(int user_id, int course_id, String course, String level) {
		super();
		this.user_id = user_id;
		this.course_id = course_id;
		this.course = course;
		this.level = level;
	}
	
	public ExtracurricularCourse(int user_id, String course, String level) {
		super();
		this.user_id = user_id;
		this.course = course;
		this.level = level;
	}


	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "ExtracurricularCourse [user_id=" + user_id + ", course_id="+course_id +", course=" + course +", level_course="+level+"]";
	}

}
