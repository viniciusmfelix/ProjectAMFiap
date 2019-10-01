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
<input type="number" name="jo_code" placeholder="Enter Job Opening Code here..." required><br/><br/>
<input type="submit" value="Select Best User Applied for Job"><br/><br/>
</form>
<%User best_user = (User) request.getAttribute("best_user"); %>
<%String bad_situation = (String) request.getAttribute("bad_situation"); %>
<ul>
		<%if(best_user==null){ %>
		<li><%=bad_situation %></li>
		<%}else{%>
		<li><%=best_user.getName()%></li>
		<%}%>
	</ul>
<br/><br/>
<form action="userselectsendemail" method="POST">
<input type="number" name="jo_code" placeholder="Type the Job Opening code here..."><br/><br/>
<input type="text" name="email" placeholder="Type the email of the User here..."><br/><br/>
<textarea name="feedback_message" rows="5" cols="30" placeholder="Specify email here"></textarea><br/><br/>
<input type="submit" value="Send Email">
</form><br/><br/>
<%String email_sent = (String) request.getAttribute("email_sent"); %>
<%=email_sent %>
</body>
</html>