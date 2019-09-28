<%@page import="com.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="jobopeningselect" method="POST">
<input type="number" name="jo_code" placeholder="Enter Job Opening code here..."><br/><br/>
<input type="submit" value="Retrieve Applied Users"><br/><br/>
</form>
<%List<User> users_applied = (List<User>) request.getAttribute("users_applied"); %>
<%String job_situation = (String) request.getAttribute("job_situation"); %>
<ul>
		<%try{for(User user : users_applied){ %>
		<%if(user==null){ %>
		<li><%=job_situation %></li>
		<%}else{%>
		<li><%=user.getName()%></li>
		<%}}}catch(NullPointerException e){}%>
	</ul>
See available Job Openings <a href="JobOpeningList.jsp">here</a>
</body>
</html>