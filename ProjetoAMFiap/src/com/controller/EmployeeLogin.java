package com.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;

@WebServlet("/employeelogin")
public class EmployeeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmployeeLogin() {
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
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		ResultSet rs;
		EmployeeDAO employeedao = new EmployeeDAO();
		rs = employeedao.employeeLogin(email, password);
			
			try {
				if(rs.next()) {
					HttpSession session = request.getSession(true);
					session.setAttribute("email", email);
					response.sendRedirect("Portal/RecruiterPage.jsp");
				} else {
					response.sendRedirect("EmployeeLoginFailed.jsp");
				}
			} catch (SQLException e) {
				System.out.println("Error during the retrievement of employee in Oracle - Servlet Page Error\n" + e);
		}
	}

}
