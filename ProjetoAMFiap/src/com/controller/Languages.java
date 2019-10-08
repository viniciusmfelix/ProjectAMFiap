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
		
		//group-languages["+i+"][level_language]"
		
		HttpSession session = request.getSession(true);

		String email = (String) session.getAttribute("email");
		
		UserDAO userdao = new UserDAO();
		ResumeDAO resumedao = new ResumeDAO();
		
		int user_id = userdao.returnUserId(email);
		
		String button_clicked = request.getParameter("lang_sub");

		List<Language> new_langs = new ArrayList<>();
		
		if(button_clicked.equals("Save")) {
				String actual_lang = request.getParameter("group-languages[0][language]");
				String actual_lang_level = request.getParameter("group-languages[0][level_language]");
				Language lang = new Language(user_id, actual_lang, actual_lang_level);
				new_langs.add(lang);
			resumedao.setLanguages(new_langs);
		} else if (button_clicked.equals("Update")) {
			List<Language> lang_update = new ArrayList<>();
			List<Language> langs = resumedao.retrieveLanguage(user_id);

				String actual_lang = request.getParameter("group-languages[0][language]");
				String actual_lang_level = request.getParameter("group-languages[0][level_language]");
				
				for (Language language : langs) {
					if(actual_lang.equalsIgnoreCase(language.getLanguage()) && !actual_lang_level.equalsIgnoreCase(language.getLevel())) {
						lang_update.add(new Language(language.getUser_id(),language.getLang_id(),actual_lang,actual_lang_level));
						
				}
					resumedao.updateLanguage(lang_update);
			}
		} else if (button_clicked.equals("Delete")) {
				String actual_lang = request.getParameter("group-languages[0][language]");
				String actual_lang_level = request.getParameter("group-languages[0][level_language]");
				int lang_id = resumedao.returnLangId(actual_lang,actual_lang_level, user_id);
				Language lang = new Language(user_id, lang_id,actual_lang, actual_lang_level);
				System.out.println(lang.toString());
				new_langs.add(lang);
			resumedao.deleteLanguage(new_langs, user_id);
		}
		response.sendRedirect("Portal/pages/UserProfile.jsp");
	}

}
