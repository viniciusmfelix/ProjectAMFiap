package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.JobOpeningDAO;
import com.model.JobOpening;

@WebServlet("/jobopeningretriever")
public class JobOpeningRetriever extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public JobOpeningRetriever() {
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
		
		List<JobOpening> jobs = jobopeningdao.retrieveJobOpening();
		
		if(jobs != null) {
			request.setAttribute("jobs", jobs);
			dispatcher = request.getRequestDispatcher("JobOpeningList.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("jobs", null);
			dispatcher = request.getRequestDispatcher("JobOpeningList.jsp");
			dispatcher.forward(request, response);
		}
	}

}
