package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JobOpeningDAO;
import com.dao.UserDAO;
import com.model.User;

import static java.lang.Integer.parseInt;

@WebServlet("/jobopeningselect")
public class JobOpeningSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JobOpeningSelect() {
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
		List<User> users_applied = new ArrayList<>();
		UserDAO userdao = new UserDAO();
		JobOpeningDAO jobopeningdao = new JobOpeningDAO();
		int jo_code = parseInt(request.getParameter("jo_code"));
		boolean job_exists = jobopeningdao.jobOpeningExists(jo_code);
		String job_situation;
		users_applied = userdao.retrieveUsersApplied(jo_code);
		
		
		if(job_exists == true) {
			if(users_applied != null) {
				request.setAttribute("users_applied", users_applied);
				dispatcher = request.getRequestDispatcher("JobOpeningSelect.jsp");
				dispatcher.forward(request, response);
			} else {
				request.setAttribute("users_applied", null);
				dispatcher = request.getRequestDispatcher("JobOpeningSelect.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			job_situation = "Job Opening not elegible or doesn't exists.";
			request.setAttribute("job_situation", job_situation);
			dispatcher = request.getRequestDispatcher("JobOpeningSelect.jsp");
			dispatcher.forward(request, response);
		}
	}

}
