package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDAO;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserLogin() {
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
		
		PrintWriter out = response.getWriter();
		
		ResultSet rs;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email != null && password != null & !email.isEmpty() && !password.isEmpty()) {
			UserDAO userdao = new UserDAO();
			rs = userdao.userLogin(email, password);
			try {
				if(rs.next()) {
					HttpSession session = request.getSession();
					session.setAttribute("email", email);
					response.sendRedirect("UserPage.jsp");
				} else {
					response.sendRedirect("UserLogin.jsp");
					out.print("Usuario ou senha inválidos.");
				}
			} catch (SQLException e) {
				System.out.println("Erro ao consultar o banco pelo Servlet\n" + e);
			}
		} else {
			response.sendRedirect("UserLogin.jsp");
			out.print("Usuario ou senha não podem ser nulos.");
		}
	}

}
