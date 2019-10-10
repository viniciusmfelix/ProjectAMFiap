<%@page import="com.dao.JobOpeningDAO"%>
<%@page import="com.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String email = (String) session.getAttribute("usermail");
UserDAO userdao = new UserDAO();
JobOpeningDAO jobopeningdao = new JobOpeningDAO();
int user_id = userdao.returnUserId(email);
jobopeningdao.userDeleteFeedbacks(user_id);
response.sendRedirect("UserFeedbacks.jsp");
%>