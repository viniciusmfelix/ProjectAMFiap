package com.model;

public class Resume {
	private String goal;
	private AcademicTraining academic_training;
	private ProfessionalExperience professional_experience;
	private Language languages;
	private ExtracurricularCourse extracurricular_courses;

	public Resume(String goal, AcademicTraining academic_training, ProfessionalExperience professional_experience, Language languages,
			ExtracurricularCourse extracurricular_courses) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
		this.professional_experience = professional_experience;
		this.languages = languages;
		this.extracurricular_courses = extracurricular_courses;
	}

	public Resume(String goal, AcademicTraining academic_training, ProfessionalExperience professional_experience,
			Language languages) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
		this.professional_experience = professional_experience;
		this.languages = languages;
	}

	
	public Resume(String goal, AcademicTraining academic_training, ProfessionalExperience professional_experience) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
		this.professional_experience = professional_experience;
	}

	public Resume(String goal, AcademicTraining academic_training) {
		super();
		this.goal = goal;
		this.academic_training = academic_training;
	}

	public String getGoal() {
		return goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}

	public AcademicTraining getAcademic_training() {
		return academic_training;
	}

	public void setAcademic_training(AcademicTraining academic_training) {
		this.academic_training = academic_training;
	}

	public ProfessionalExperience getProfessional_experience() {
		return professional_experience;
	}

	public void setProfessional_experience(ProfessionalExperience professional_experience) {
		this.professional_experience = professional_experience;
	}

	public Language getLanguages() {
		return languages;
	}

	public void setLanguages(Language languages) {
		this.languages = languages;
	}

	public ExtracurricularCourse getExtracurricular_courses() {
		return extracurricular_courses;
	}

	public void setExtracurricular_courses(ExtracurricularCourse extracurricular_courses) {
		this.extracurricular_courses = extracurricular_courses;
	}
}
