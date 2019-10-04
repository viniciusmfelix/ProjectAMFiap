package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ResumeDAO;
import com.model.AcademicTraining;
import com.model.ExtracurricularCourse;
import com.model.Goal;
import com.model.Language;
import com.model.ProfessionalExperience;
import com.model.Resume;
import java.time.LocalDate;

@WebServlet("/resumeregister")
public class ResumeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResumeRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		HttpSession session = null;
		
		String email = (String) session.getAttribute("email");
		
		ResumeDAO resumedao = new ResumeDAO();
		
		int user_id = resumedao.returnUserId(email);
		
		//Values of Goals
		String goals = request.getParameter("goals");
		Goal goal = new Goal(user_id,goals);
		
		//Values of Academic Training
		String academy_training_course = request.getParameter("academy_training_course");
		String academy_training_institution = request.getParameter("academy_training_institution");
		Date start_date_academy = Date.valueOf(request.getParameter("academy_training_startdate"));
		Date end_date_academy = Date.valueOf(request.getParameter("academy_training_enddate"));
		AcademicTraining academictraining = new AcademicTraining(user_id,academy_training_institution,academy_training_course,start_date_academy,end_date_academy);
		
		ProfessionalExperience professionalexperience;
		//Values of Professional Experience if it's not empty
		if(!request.getParameter("professional_experience_jobtitle").isEmpty()) {
			String jobtitle = request.getParameter("professional_experience_jobtitle");
			String employer = request.getParameter("professional_experience_employer");
			String jobdescription = request.getParameter("professional_experience_description");
			Date start_date_professional = Date.valueOf(request.getParameter("professional_experience_startdate"));
			Date end_date_professional = Date.valueOf(request.getParameter("professional_experience_enddate"));
			professionalexperience = new ProfessionalExperience(user_id,jobtitle, employer, jobdescription, start_date_professional, end_date_professional);
		} else { //If professional experience is empty, set values to null.
			professionalexperience = new ProfessionalExperience();
		}
		
		Language language;
		//Values of Languages if it's not empty
		if(!request.getParameter("language_1").isEmpty()) {
			String language_1 = request.getParameter("language_1");
			if(!request.getParameter("language_2").isEmpty()) {
				String language_2 = request.getParameter("language_2");
				if(!request.getParameter("language_3").isEmpty()) {
					String language_3 = request.getParameter("language_3");
					if(!request.getParameter("language_4").isEmpty()) {
						String language_4 = request.getParameter("language_4");
						if(!request.getParameter("language_5").isEmpty()) {
							String language_5 = request.getParameter("language_5");
							language = new Language(user_id,language_1,language_2,language_3,language_4,language_5);
						} else {
							language = new Language(user_id,language_1,language_2,language_3,language_4);
						}
					} else {
						language = new Language(user_id,language_1,language_2,language_3);
					}
				} else {
					language = new Language(user_id,language_1,language_2);
				}
			} else {
				language = new Language(user_id,language_1);
			}
		} else {
			language = new Language();
		}
		
		ExtracurricularCourse extracurricular;
		//Values of Extracurricular Courses if it's not empty
		if(!request.getParameter("extracurricular_1").isEmpty()) {
			String extracurricular_1 = request.getParameter("extracurricular_1");
			if(!request.getParameter("extracurricular_2").isEmpty()) {
				String extracurricular_2 = request.getParameter("extracurricular_2");
				if(!request.getParameter("extracurricular_3").isEmpty()) {
					String extracurricular_3 = request.getParameter("extracurricular_3");
					if(!request.getParameter("extracurricular_4").isEmpty()) {
						String extracurricular_4 = request.getParameter("extracurricular_4");
						if(!request.getParameter("extracurricular_5").isEmpty()) {
							String extracurricular_5 = request.getParameter("extracurricular_5");
							extracurricular = new ExtracurricularCourse(user_id,extracurricular_1,extracurricular_2, extracurricular_3,extracurricular_4,extracurricular_5);
						} else {
							extracurricular = new ExtracurricularCourse(user_id,extracurricular_1,extracurricular_2, extracurricular_3,extracurricular_4);
						}
					} else {
						extracurricular = new ExtracurricularCourse(user_id,extracurricular_1,extracurricular_2, extracurricular_3);
					}
				} else {
					extracurricular = new ExtracurricularCourse(user_id,extracurricular_1,extracurricular_2);
				}
			} else {
				extracurricular = new ExtracurricularCourse(user_id,extracurricular_1);
			}
		} else {
			extracurricular = new ExtracurricularCourse();
		}
		
		boolean resume_exists;
		
		resume_exists = resumedao.resumeExists(user_id);
		
		if(resume_exists == false) {
			resumedao.setGoals(goal);
			resumedao.setAcademicTraining(academictraining);
			resumedao.setProfessionalExperience(professionalexperience);
			resumedao.setLanguages(language);
			resumedao.setExtracurricularCourses(extracurricular);
		} else {
			
		}
		response.sendRedirect("UserPage.jsp");
	}

}
