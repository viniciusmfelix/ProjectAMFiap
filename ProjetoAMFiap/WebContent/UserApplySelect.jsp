<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="userapplyselect" method="POST">
<input type="number" name="jo_code" placeholder="Enter Job Opening Code here..."><br/><br/>
<input type="submit" value="Select Best User Applied for Job"><br/><br/>
<%User best_user = (User) request.getAttribute("best_user"); %>
<%String bad_situation = (String) request.getAttribute("bad_situation"); %>
<ul>
		<% %>
		<%if(best_user==null){ %>
		<li><%=bad_situation %></li>
		<%}else{%>
		<li><%=best_user.getName()%></li>
		<%}%>
	</ul>
</form>
</body>
</html>