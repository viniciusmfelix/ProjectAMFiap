package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.JobOpeningDAO;
import com.dao.UserDAO;
import com.email.JavaMail;

@WebServlet("/sendfeedback")
public class SendFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SendFeedback() {
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
		
		String feedback = request.getParameter("feedback");
		
		HttpSession session = request.getSession();
		JobOpeningDAO jobopeningdao = new JobOpeningDAO();
		UserDAO userdao = new UserDAO();
		String email = (String) session.getAttribute("usermail");
		String name = userdao.retrieveName(email);
				JavaMail mail = new JavaMail();
		int user_id = userdao.returnUserId(email);
		int job_id = (int) session.getAttribute("jobid");
		String jobtitle = jobopeningdao.retrieveNameJobOpening(job_id);
		jobopeningdao.applyFeedback(job_id, user_id, feedback);
		
		mail.sendMailtoUser(email, name, job_id, jobtitle);
		response.sendRedirect("Portal/pages/UsersApplied.jsp");
	}

}
