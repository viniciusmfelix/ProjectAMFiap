package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ResumeDAO;
import com.dao.UserDAO;
import com.model.Language;

@WebServlet("/languages")
public class Languages extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Languages() {
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
		
		HttpSession session = request.getSession(true);

		String email = (String) session.getAttribute("email");
		
		UserDAO userdao = new UserDAO();
		ResumeDAO resumedao = new ResumeDAO();
		
		int user_id = userdao.returnUserId(email);
		
		List<Language> lang_list = new ArrayList<>();
		
		Language language = new Language(user_id,request.getParameter("group-languages["+1+"][language]"),request.getParameter("group-languages["+1+"][level_language]"));
		lang_list.add(language);
		resumedao.setLanguages(lang_list);
		response.sendRedirect("Portal/pages/UserProfile.jsp");
		//if(!request.getParameter("language").isEmpty()) {
			
		//} else {
			
		//}
	}

}
