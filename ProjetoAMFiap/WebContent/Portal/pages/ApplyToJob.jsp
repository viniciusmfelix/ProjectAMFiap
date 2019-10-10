<%@page import="com.dao.JobOpeningDAO"%>
<%@page import="com.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
int job_id = (int) session.getAttribute("jobid");
int user_id;
String email = (String) session.getAttribute("email");
UserDAO userdao = new UserDAO();
user_id = userdao.returnUserId(email);
JobOpeningDAO jobopeningdao = new JobOpeningDAO();
jobopeningdao.userApply(job_id, user_id);
response.sendRedirect("UserJobOpeningApplied.jsp");
%>