package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.Integer.parseInt;

import com.dao.JobOpeningDAO;
import com.dao.UserDAO;
import com.email.JavaMail;

@WebServlet("/userselectsendemail")
public class UserSelectSendEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserSelectSendEmail() {
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
		
		JobOpeningDAO jobopeningdao = new JobOpeningDAO();
		int jo_code = parseInt(request.getParameter("jo_code"));
		String name_jobopening = jobopeningdao.retrieveNameJobOpening(jo_code);
		String feedback_message = request.getParameter("feedback_message");
		String email = request.getParameter("email");
		boolean user_exists;
		boolean job_exists;
		boolean user_applied;
		String situation;
		
		JavaMail sendEmail = new JavaMail();
		UserDAO userdao = new UserDAO();
		user_exists = userdao.userExists(email);
		job_exists = jobopeningdao.jobOpeningExists(jo_code);
		
		user_applied = jobopeningdao.userAlreadyApplied(jo_code, email);
		
		if(user_applied == true) {
			situation = "Email Sent!";
			sendEmail.sendMailtoUser(email, feedback_message,jo_code, name_jobopening);
			request.setAttribute("email_sent", situation);
			dispatcher = request.getRequestDispatcher("UserApplySelect.jsp");
			dispatcher.forward(request, response);
		} else {
			
			if(user_exists == true) {
				if(job_exists == true) {
					situation = "User not applied to this job opening";
					request.setAttribute("email_sent", situation);
					dispatcher = request.getRequestDispatcher("UserApplySelect.jsp");
					dispatcher.forward(request, response);
				} else {
					situation = "Job Opening not exists";
					request.setAttribute("job_notexists", situation);
					dispatcher = request.getRequestDispatcher("UserApplySelect.jsp");
					dispatcher.forward(request, response);
				}
			} else {
				situation = "User not exists";
				request.setAttribute("user_notexists", situation);
				dispatcher = request.getRequestDispatcher("UserApplySelect.jsp");
				dispatcher.forward(request, response);
			}
		
		}

	}

}
