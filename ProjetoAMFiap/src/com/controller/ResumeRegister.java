package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ResumeDAO;
import com.dao.UserDAO;
import com.model.AcademicTraining;
import com.model.ExtracurricularCourse;
import com.model.Goal;
import com.model.Language;
import com.model.ProfessionalExperience;
import com.model.Resume;


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
		
		RequestDispatcher dispatcher;
		
		HttpSession session = request.getSession(true);

		String email = (String) session.getAttribute("email");
		System.out.println(email);
		
		UserDAO userdao = new UserDAO();
		ResumeDAO resumedao = new ResumeDAO();
		
		int user_id = userdao.returnUserId(email);
		
		//Values of Goals
		String goals = request.getParameter("goals");
		Goal goal = new Goal(user_id,goals);
		
		List<AcademicTraining> academy_list = new ArrayList<>();
		//Values of Academic Training
		String academy_training_course = request.getParameter("academy_training_course");
		String academy_training_institution = request.getParameter("academy_training_institution");
		Date start_date_academy = Date.valueOf(request.getParameter("academy_training_startdate"));
		Date end_date_academy = Date.valueOf(request.getParameter("academy_training_enddate"));
		String description = request.getParameter("academy_training_description");
		AcademicTraining academictraining = new AcademicTraining(user_id,start_date_academy,end_date_academy,academy_training_institution,academy_training_course,description);
		academy_list.add(academictraining);
		
		
		List<ProfessionalExperience> professional_list = new ArrayList<>();
		ProfessionalExperience professionalexperience;
		//Values of Professional Experience if it's not empty
		if(!request.getParameter("professional_experience_jobtitle").isEmpty()) {
			String jobtitle = request.getParameter("professional_experience_jobtitle");
			String employer = request.getParameter("professional_experience_employer");
			String jobdescription = request.getParameter("professional_experience_description");
			Date start_date_professional = Date.valueOf(request.getParameter("professional_experience_startdate"));
			Date end_date_professional = Date.valueOf(request.getParameter("professional_experience_enddate"));
			professionalexperience = new ProfessionalExperience(user_id,jobtitle, employer, start_date_professional, end_date_professional,jobdescription);
			professional_list.add(professionalexperience);	
		}
	
		List<Language> lang_list = new ArrayList<>();
		//Values of Languages if it's not empty
		if(!request.getParameter("language").isEmpty()) {
			lang_list.add(new Language(user_id,request.getParameter("language")));
		} 
		
		List<ExtracurricularCourse> extracrcl_list = new ArrayList<>();
		//Values of Extracurricular Courses if it's not empty
		if(!request.getParameter("extracurricular").isEmpty()) {
			extracrcl_list.add(new ExtracurricularCourse(user_id,request.getParameter("extracurricular")));
		} 
		
		boolean resume_exists;
		
		resume_exists = resumedao.resumeExists(user_id);
		
		if(resume_exists == false) {
			resumedao.setGoals(goal);
			resumedao.setAcademicTraining(academy_list);
			resumedao.setProfessionalExperience(professional_list);
			resumedao.setLanguages(lang_list);
			resumedao.setExtracurricularCourses(extracrcl_list);
			Resume resume = resumedao.retrieveResume(goal, academy_list, professional_list, lang_list, extracrcl_list);
			request.setAttribute("resume", resume);
			dispatcher = request.getRequestDispatcher("ResumeRegister.jsp");
			dispatcher.forward(request, response);
			response.sendRedirect("UserPage.jsp");
		} else {
			
		}
	}

}
