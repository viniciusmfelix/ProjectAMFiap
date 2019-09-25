package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JobOpeningDAO;
import com.model.JobOpening;

import static java.lang.Integer.parseInt;

@WebServlet("/jobopeningregister")
public class JobOpeningRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JobOpeningRegister() {
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
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		JobOpening jobopening = new JobOpening(jo_code,name,description);
		JobOpeningDAO jobopeningdao = new JobOpeningDAO();
		
		jobopeningdao.createNewJobOpening(jobopening);
		response.sendRedirect("JobOpeningPortal.jsp");
	}

}
