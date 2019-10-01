<%@page import="com.model.Feedbacks"%>
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
<form action="retrievefeedbacks" method="POST">
<input type="text" name="email" placeholder="Type here your email to retrieve feedbacks..."><br/><br/>
<input type="submit" value="View Feedbacks">
</form><br/><br/>
<%List<Feedbacks> feedbacks = (List<Feedbacks>) request.getAttribute("feedbacks"); %>
<%try{for(Feedbacks feedback : feedbacks){%>
<%=feedback.getJo_code() %>
<%=feedback.getFeedback_message() %>
<%}}catch(NullPointerException e){} %>
</body>
</html>