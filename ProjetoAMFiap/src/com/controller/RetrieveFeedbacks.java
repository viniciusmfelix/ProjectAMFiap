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

import com.dao.UserDAO;
import com.model.Feedbacks;

import static java.lang.Integer.parseInt;

@WebServlet("/retrievefeedbacks")
public class RetrieveFeedbacks extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RetrieveFeedbacks() {
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
		
		String email = request.getParameter("email");
		UserDAO userdao = new UserDAO();
		
		List<Feedbacks> feedbacks = new ArrayList<>();
		
		feedbacks = userdao.retrieveFeedbacks(email);
		request.setAttribute("feedbacks", feedbacks);
		dispatcher = request.getRequestDispatcher("UserFeedbacksPage.jsp");
		dispatcher.forward(request, response);
	}

}
