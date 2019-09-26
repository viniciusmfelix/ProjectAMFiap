package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.EmployeeDAO;

import static java.lang.Integer.parseInt;

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
		
		RequestDispatcher dispatcher;
		
		PrintWriter out = response.getWriter();
		
		int employee_code = parseInt(request.getParameter("employee_code"));
		String password = request.getParameter("password");
		String name;
		
			
			ResultSet rs;
			EmployeeDAO employeedao = new EmployeeDAO();
			rs = employeedao.employeeLogin(employee_code, password);
			name = employeedao.retrieveName(employee_code);
			
			try {
				if(rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("name", name);
					dispatcher = request.getRequestDispatcher("EmployeePage.jsp");
					dispatcher.forward(request, response);
					
				} else {
					response.sendRedirect("EmployeeLogin.jsp");
					out.print("Code and/or password invalid.");
				}
			} catch (SQLException e) {
				System.out.println("Error during the retrievement of employee in Oracle - Servlet Page Error\n" + e);
		}
	}

}
