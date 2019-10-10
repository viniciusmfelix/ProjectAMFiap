<%@page import="com.dao.JobOpeningDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
int job_id = (int) session.getAttribute("jobid");
JobOpeningDAO jobopeningdao = new JobOpeningDAO();
jobopeningdao.deleteJobOpening(job_id);
response.sendRedirect("JobOpeningPortalRecruiter.jsp");
%>