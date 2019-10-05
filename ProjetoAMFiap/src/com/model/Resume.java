package com.model;

import java.util.List;

public class Resume {
	private Goal goal;
	private List<AcademicTraining> academic_training;
	private List<ProfessionalExperience> professional_experience;
	private List<Language> languages;
	private List<ExtracurricularCourse> extracurricular_courses;
	
	public Resume() {
		
	}

	public Resume(Goal goal, List<AcademicTraining> academic_training, List<ProfessionalExperience> professional_experience, List<Language> languages,
			List<ExtracurricularCourse> extracurricular_courses) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
		this.professional_experience = professional_experience;
		this.languages = languages;
		this.extracurricular_courses = extracurricular_courses;
	}

	public Resume(Goal goal, List<AcademicTraining> academic_training, List<ProfessionalExperience> professional_experience,
			List<Language> languages) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
		this.professional_experience = professional_experience;
		this.languages = languages;
	}

	
	public Resume(Goal goal, List<AcademicTraining> academic_training, List<ProfessionalExperience> professional_experience) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
		this.professional_experience = professional_experience;
	}

	public Resume(Goal goal, List<AcademicTraining> academic_training) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
	}

	public Goal getGoal() {
		return goal;
	}

	public void setGoal(Goal goal) {
		this.goal = goal;
	}

	public List<AcademicTraining> getAcademic_training() {
		return academic_training;
	}

	public void setAcademic_training(List<AcademicTraining> academic_training) {
		this.academic_training = academic_training;
	}

	public List<ProfessionalExperience> getProfessional_experience() {
		return professional_experience;
	}

	public void setProfessional_experience(List<ProfessionalExperience> professional_experience) {
		this.professional_experience = professional_experience;
	}

	public List<Language> getLanguages() {
		return languages;
	}

	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}

	public List<ExtracurricularCourse> getExtracurricular_courses() {
		return extracurricular_courses;
	}

	public void setExtracurricular_courses(List<ExtracurricularCourse> extracurricular_courses) {
		this.extracurricular_courses = extracurricular_courses;
	}
}
