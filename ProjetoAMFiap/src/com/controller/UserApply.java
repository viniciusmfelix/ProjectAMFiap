package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JobOpeningDAO;
import com.dao.UserDAO;

import static java.lang.Integer.parseInt;

@WebServlet("/userapply")
public class UserApply extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserApply() {
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
		String email = request.getParameter("email");
		boolean job_exists;
		boolean user_applied;
		String job_apply;
		String user_invalid;
		
		RequestDispatcher dispatcher;
		
		JobOpeningDAO jobopeningdao = new JobOpeningDAO();
		UserDAO userdao = new UserDAO();
		
		job_exists = jobopeningdao.jobOpeningExists(jo_code);
		user_applied = jobopeningdao.userAlreadyApplied(jo_code, email);
		
		if(job_exists == true) {
			if(user_applied == false) {
				userdao.userApply(jo_code, email);
				job_apply = "Apply success!";
				request.setAttribute("job_apply", job_apply);
				dispatcher = request.getRequestDispatcher("UserApply.jsp");
				dispatcher.forward(request, response);
			} else {
				user_invalid = "User already applied for this Job Opening.";
				request.setAttribute("user_applied", user_invalid);
				dispatcher = request.getRequestDispatcher("UserApply.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			job_apply = "Job Opening not elegible or doesn't exists.";
			request.setAttribute("job_apply", job_apply);
			dispatcher = request.getRequestDispatcher("UserApply.jsp");
			dispatcher.forward(request, response);
		}
		
	}

}
