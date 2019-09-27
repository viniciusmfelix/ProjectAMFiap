<%@page import="com.model.JobOpening"%>
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
<form action="jobopeningretriever" method="POST">
<input type="submit" value="Retrieve Available Job Openings">
</form>
<%List<JobOpening> jobs = (List<JobOpening>) request.getAttribute("jobs");%>
<%String job_empty = "No available Job Openings right now. Try again later."; %>
	<ul>
	<%if(jobs==null){ %>
		<li><%=job_empty %></li>
	<%}else{%>
		<%for(JobOpening jobopening : jobs){ %>
		<li><%=jobopening.getName()%></li>
	<%}}%>
	</ul>
</body>
</html>