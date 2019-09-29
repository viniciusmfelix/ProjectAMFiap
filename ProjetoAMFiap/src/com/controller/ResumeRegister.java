package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.ResumeDAO;
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
		
		String goals = request.getParameter("goals");
		String academy_training = request.getParameter("academy_training");
		String professional_experience = request.getParameter("professional_experience");
		String language = request.getParameter("language");
		String extracurricular_courses = request.getParameter("extracurricular_courses");
		String email = request.getParameter("email");
		boolean resume_exists;
		
		Resume resume = new Resume(goals, academy_training,professional_experience,language,extracurricular_courses);
		ResumeDAO resumedao = new ResumeDAO();
		resume_exists = resumedao.resumeExists(email);
		
		if(resume_exists == false) {
			resumedao.createResume(resume,email);
		} else {
			resumedao.updateResume(resume,email);
		}
		response.sendRedirect("UserPage.jsp");
	}

}
