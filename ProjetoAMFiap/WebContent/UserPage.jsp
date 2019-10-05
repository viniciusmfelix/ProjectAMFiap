<%@page import="com.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session = request.getSession(true);
String email = (String) session.getAttribute("email");
String name;
UserDAO userdao = new UserDAO(); 
name = userdao.retrieveName(email);
%>

<h1 style="color:#0000FF">Hello, <%=name%>!</h1><br/><br/>
<a href="ResumeRegister.jsp">Register/Update your resume here.</a><br/><br/>
<a href="JobOpeningPortalUser.jsp">Job Openings Portal</a><br/><br/>
<a href="Logout.jsp">LogOut</a>
</body>
</html>