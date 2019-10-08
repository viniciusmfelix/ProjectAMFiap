package com.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ResumeDAO;
import com.dao.UserDAO;
import com.model.ProfessionalExperience;

@WebServlet("/professionalexperience")
public class ProfessionalExperiences extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ProfessionalExperiences() {
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
		
		HttpSession session = request.getSession(true);

		String email = (String) session.getAttribute("email");
		
		UserDAO userdao = new UserDAO();
		ResumeDAO resumedao = new ResumeDAO();
		
		int user_id = userdao.returnUserId(email);
		
		String button_clicked = request.getParameter("pe_sub");

		List<ProfessionalExperience> professional_exp_list = new ArrayList<>();
		
		String jobtitle = request.getParameter("group-PEs[0][jobTitle]");
		String employer = request.getParameter("group-PEs[0][employer]");
		Date startdate = Date.valueOf(request.getParameter("group-PEs[0][startDate]"));
		Date enddate = Date.valueOf(request.getParameter("group-PEs[0][endDate]"));
		String description = request.getParameter("group-PEs[0][jobDescription]");		
		
		if(button_clicked.equals("Save")) {
			ProfessionalExperience professional_experience = new ProfessionalExperience(user_id, jobtitle, employer, startdate, enddate, description);
			professional_exp_list.add(professional_experience);
			resumedao.setProfessionalExperience(professional_exp_list);
		} else if (button_clicked.equals("Update")) {
			List<ProfessionalExperience> professional_list_retrieve = resumedao.retrieveProfessionalExperience(user_id);
			List<ProfessionalExperience> professional_list_update = new ArrayList<>();
			System.out.println(professional_list_retrieve.toString());	
			resumedao.updateProfessionalExperience(professional_list_update);
		} else if (button_clicked.equals("Delete")) {
			List<ProfessionalExperience> prof_delete_list = new ArrayList<>();
			int professional_id = resumedao.retrieveProfessionalExperienceId(jobtitle, employer, startdate, user_id);
			ProfessionalExperience prof_exp = new ProfessionalExperience(user_id,professional_id,jobtitle,employer,startdate,enddate,description);
			prof_delete_list.add(prof_exp);
			resumedao.deleteProfessionalExperience(prof_delete_list);
		}
		response.sendRedirect("Portal/pages/UserProfile.jsp");
	}

}
