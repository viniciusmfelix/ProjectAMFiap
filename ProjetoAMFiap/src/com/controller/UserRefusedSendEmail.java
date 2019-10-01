package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JobOpeningDAO;
import com.datareference.WekaAnalysis;
import com.email.JavaMail;
import com.model.User;

import static java.lang.Integer.parseInt;

@WebServlet("/userrefusedsendemail")
public class UserRefusedSendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRefusedSendEmail() {
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
		
		int jo_code = parseInt(request.getParameter("jo_code"));
		WekaAnalysis artificial_inteligence = new WekaAnalysis();
		JobOpeningDAO jobopeningdao = new JobOpeningDAO();
		List<User> refused_users = new ArrayList<>();
		JavaMail sendMail = new JavaMail();
		String name_jobopening = jobopeningdao.retrieveNameJobOpening(jo_code);
		
		refused_users = artificial_inteligence.selectRefusedApply(jo_code);
		jobopeningdao.setFeedbacktoRefusedUsers(jo_code, refused_users);
		for (User user : refused_users) {
			//sendMail.sendMailtoUser(user.getEmail(), user.getName(), jo_code, name_jobopening);
		}
		response.sendRedirect("JobOpeningPortalEmployee.jsp");
	}

}
