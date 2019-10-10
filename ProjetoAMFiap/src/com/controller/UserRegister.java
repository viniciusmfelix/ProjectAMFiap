package com.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.email.JavaMail;
import com.model.User;

@WebServlet("/userregister")
public class UserRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserRegister() {
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
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Date date = Date.valueOf(request.getParameter("born_date"));
		String phone = request.getParameter("telephone");
		String password = request.getParameter("password");
		String password_confirm = request.getParameter("password_confirm");
		
		if(password.equals(password_confirm)) {
			User user = new User(firstname,lastname,email,date,phone,password);
			UserDAO userdao = new UserDAO();
			userdao.userRegister(user);
			JavaMail mail = new JavaMail();
			response.sendRedirect("HomenRegister/UserLogin.jsp");
			mail.sendWelcomeMail(email, firstname);
		} else {
			response.sendRedirect("HomenRegister/UserRegisterFailed.jsp");
		}
	}

}
