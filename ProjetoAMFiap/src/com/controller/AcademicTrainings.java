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
import com.model.AcademicTraining;
import com.model.ProfessionalExperience;

@WebServlet("/academictrainings")
public class AcademicTrainings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AcademicTrainings() {
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
		
		String button_clicked = request.getParameter("at_sub");

		List<AcademicTraining> acad_train_list = new ArrayList<>();
		
		String course = request.getParameter("group-educations[0][degree]");
		String institution = request.getParameter("group-educations[0][school]");
		Date startdate = Date.valueOf(request.getParameter("group-educations[0][startDate]"));
		Date enddate = Date.valueOf(request.getParameter("group-educations[0][endDate]"));
		String description = request.getParameter("group-educations[0][educationDescription]");		
		
		if(button_clicked.equals("Save")) {
			AcademicTraining academic_training = new AcademicTraining(user_id, startdate, enddate, institution, course, description);
			acad_train_list.add(academic_training);
			resumedao.setAcademicTraining(acad_train_list);
		} else if (button_clicked.equals("Update")) {
			//startdate == valor.getStartDate()
			List<ProfessionalExperience> professional_list_retrieve = resumedao.retrieveProfessionalExperience(user_id);
			List<ProfessionalExperience> professional_list_update = new ArrayList<>();
			System.out.println(professional_list_retrieve.toString());	
			resumedao.updateProfessionalExperience(professional_list_update);
		} else if (button_clicked.equals("Delete")) {
			List<AcademicTraining> acad_delete_list = new ArrayList<>();
			int acad_id = resumedao.retrieveAcademicTrainingId(institution, course, user_id);
			AcademicTraining acad_train = new AcademicTraining(user_id,acad_id,startdate,enddate,institution,course,description);
			acad_delete_list.add(acad_train);
			resumedao.deleteAcademicTraining(acad_delete_list);
		}
		response.sendRedirect("Portal/pages/UserProfile.jsp");
	}

}
