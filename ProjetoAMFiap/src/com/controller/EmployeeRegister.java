package com.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDAO;
import com.model.Employee;


@WebServlet("/employeeregister")
public class EmployeeRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public EmployeeRegister() {
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
		
		EmployeeDAO employeedao = new EmployeeDAO();
		
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		Date date = Date.valueOf(request.getParameter("born_date"));
		String phone = request.getParameter("phone");
		String password = request.getParameter("password");
		String password_confirm = request.getParameter("password_confirm");
		String adm_email = request.getParameter("email_adm");
		String adm_password = request.getParameter("password_adm");
		
		if(password.equals(password_confirm)) {
			boolean admin_auth = employeedao.adminAuthentication(adm_email, adm_password);
			
			if(admin_auth == true) {
				Employee employee = new Employee(firstname,lastname,email,date,phone,password);
				employeedao.employeeRegister(employee);
				response.sendRedirect("HomenRegister/RecruiterLogin.jsp");
			} else {
				response.sendRedirect("HomenRegister/EmployeeRegisterFailed.jsp");
				System.out.println("Aqui");
			}
		} else {
			response.sendRedirect("HomenRegister/EmployeeRegisterFailed.jsp");
			System.out.println("Ou aqui");
		}
	}

}
