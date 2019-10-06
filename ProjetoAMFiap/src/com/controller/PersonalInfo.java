package com.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.ResumeDAO;
import com.dao.UserDAO;
import com.model.Bio;
import com.model.Location;
import com.model.Profession;

@WebServlet("/personalinfo")
public class PersonalInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public PersonalInfo() {
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
		
		Bio bio = new Bio(user_id,request.getParameter("bio"));
		Location location = new Location(user_id, request.getParameter("country"),request.getParameter("address"));
		Profession profession = new Profession(user_id,request.getParameter("profession"));
		
		
		userdao.updateFirstName(request.getParameter("firstname"), user_id);
		userdao.updateLastName(request.getParameter("lastname"), user_id);
		
		boolean bio_exists, location_exists, profession_exists;
		
		if(!request.getParameter("borndate").isEmpty()) {
			Date born_date = Date.valueOf(request.getParameter("borndate"));
			userdao.updateBornDate(born_date, user_id);
		}
		
		bio_exists = resumedao.bioExists(user_id);
		location_exists = resumedao.locationExists(user_id);
		profession_exists = resumedao.professionExists(user_id);
		
		if(bio_exists == true) {
			resumedao.updateBio(bio);
		} else {
			resumedao.setBio(bio);
		}
		
		if(location_exists == true) {
			resumedao.updateLocation(location);
		} else {
			resumedao.setLocation(location);
		}
		
		if(profession_exists == true) {
			resumedao.updateProfession(profession);
		} else {
			resumedao.setProfession(profession);
		}
		
		response.sendRedirect("Portal/pages/UserProfile.jsp");
	}

}
