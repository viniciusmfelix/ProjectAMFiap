package com.model;

public class Resume {
	private String goal;
	private String academic_training;
	private String professional_experience;
	private String languages;
	private String extracurricular_courses;
	
	public Resume() {
		
	}

	public Resume(String goal, String academic_training, String professional_experience, String languages,
			String extracurricular_courses) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
		this.professional_experience = professional_experience;
		this.languages = languages;
		this.extracurricular_courses = extracurricular_courses;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public String getAcademic_training() {
		return academic_training;
	}

	public void setAcademic_training(String academic_training) {
		this.academic_training = academic_training;
	}

	public String getProfessional_experience() {
		return professional_experience;
	}

	public void setProfessional_experience(String professional_experience) {
		this.professional_experience = professional_experience;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getExtracurricular_courses() {
		return extracurricular_courses;
	}

	public void setExtracurricular_courses(String extracurricular_courses) {
		this.extracurricular_courses = extracurricular_courses;
	}
}
