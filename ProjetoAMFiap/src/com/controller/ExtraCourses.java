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
import com.model.ExtracurricularCourse;

@WebServlet("/extracourses")
public class ExtraCourses extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ExtraCourses() {
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
		
		String button_clicked = request.getParameter("skill_sub");

		List<ExtracurricularCourse> new_skills = new ArrayList<>();
		
		if(button_clicked.equals("Save")) {
				String actual_skill = request.getParameter("group-skills[0][skill]");
				String actual_skill_level = request.getParameter("group-skills[0][level_skill]");
				ExtracurricularCourse skill = new ExtracurricularCourse(user_id, actual_skill, actual_skill_level);
				new_skills.add(skill);
			resumedao.setExtracurricularCourses(new_skills);
		} else if (button_clicked.equals("Update")) {
			List<ExtracurricularCourse> skill_update = new ArrayList<>();
			List<ExtracurricularCourse> skills = resumedao.retrieveExtracurricularCourse(user_id);

			String actual_skill = request.getParameter("group-skills[0][skill]");
			String actual_skill_level = request.getParameter("group-skills[0][level_skill]");
				
				for (ExtracurricularCourse skill : skills) {
					if(actual_skill.equalsIgnoreCase(skill.getCourse()) && !actual_skill_level.equalsIgnoreCase(skill.getLevel())) {
						skill_update.add(new ExtracurricularCourse(skill.getUser_id(),skill.getCourse_id(),actual_skill,actual_skill_level));
						
				}
					resumedao.updateExtracurricularCourses(skill_update);
			}
		} else if (button_clicked.equals("Delete")) {
			String actual_skill = request.getParameter("group-skills[0][skill]");
			String actual_skill_level = request.getParameter("group-skills[0][level_skill]");
				int skill_id = resumedao.returnSkillId(actual_skill,actual_skill_level, user_id);
				ExtracurricularCourse skill = new ExtracurricularCourse(user_id, skill_id,actual_skill, actual_skill_level);
				System.out.println(skill.toString());
				new_skills.add(skill);
			resumedao.deleteExtracurricularCourse(new_skills, user_id);
		}
		response.sendRedirect("Portal/pages/UserProfile.jsp");
			
	}

}
