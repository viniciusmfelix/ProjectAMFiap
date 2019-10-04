package com.model;

public class ExtracurricularCourse {
	private int user_id;
	private String course_1;
	private String course_2;
	private String course_3;
	private String course_4;
	private String course_5;
	
	public ExtracurricularCourse(int user_id, String course_1, String course_2, String course_3, String course_4, String course_5) {
		super();
		this.user_id = user_id;
		this.course_1 = course_1;
		this.course_2 = course_2;
		this.course_3 = course_3;
		this.course_4 = course_4;
		this.course_5 = course_5;
	}

	public ExtracurricularCourse(int user_id, String course_1, String course_2, String course_3, String course_4) {
		super();
		this.user_id = user_id;
		this.course_1 = course_1;
		this.course_2 = course_2;
		this.course_3 = course_3;
		this.course_4 = course_4;
	}

	public ExtracurricularCourse(int user_id, String course_1, String course_2, String course_3) {
		super();
		this.user_id = user_id;
		this.course_1 = course_1;
		this.course_2 = course_2;
		this.course_3 = course_3;
	}

	public ExtracurricularCourse(int user_id, String course_1, String course_2) {
		super();
		this.user_id = user_id;
		this.course_1 = course_1;
		this.course_2 = course_2;
	}

	public ExtracurricularCourse(int user_id, String course_1) {
		super();
		this.user_id = user_id;
		this.course_1 = course_1;
	}
	
	public ExtracurricularCourse() {
		
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCourse_1() {
		return course_1;
	}

	public void setCourse_1(String course_1) {
		this.course_1 = course_1;
	}

	public String getCourse_2() {
		return course_2;
	}

	public void setCourse_2(String course_2) {
		this.course_2 = course_2;
	}

	public String getCourse_3() {
		return course_3;
	}

	public void setCourse_3(String course_3) {
		this.course_3 = course_3;
	}

	public String getCourse_4() {
		return course_4;
	}

	public void setCourse_4(String course_4) {
		this.course_4 = course_4;
	}

	public String getCourse_5() {
		return course_5;
	}

	public void setCourse_5(String course_5) {
		this.course_5 = course_5;
	}
	
}
