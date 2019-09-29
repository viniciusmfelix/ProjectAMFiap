package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static java.lang.Integer.parseInt;

import com.dao.AnalysisDAO;
import com.datareference.WekaAnalysis;
import com.model.User;

@WebServlet("/userapplyselect")
public class UserApplySelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserApplySelect() {
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
		
		int jo_code = parseInt(request.getParameter("jo_code"));
		WekaAnalysis artificial_intelligence = new WekaAnalysis();
		AnalysisDAO analysisdao = new AnalysisDAO();
		String bad_situation;
		User best_user;
		
		List<User> users_to_analysis = artificial_intelligence.selectAppropriateApply(jo_code);
		best_user = analysisdao.getBestUser(users_to_analysis);
		
		if(best_user != null) {
			request.setAttribute("best_user", best_user);
			dispatcher = request.getRequestDispatcher("UserApplySelect.jsp");
			dispatcher.forward(request, response);
		} else {
			bad_situation = "No good results for applies in this Job Opening";
			request.setAttribute("bad_situation", bad_situation);
			dispatcher = request.getRequestDispatcher("UserApplySelect.jsp");
			dispatcher.forward(request, response);
		}
	}

}
