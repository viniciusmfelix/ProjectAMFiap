<%@page import="com.model.JobOpening"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sniper Contractor - Job Openings</title>
<link rel="stylesheet" href="Assets/CSS/jobopeninglister.css">
<link
	href="https://fonts.googleapis.com/css?family=Lobster+Two|Orbitron&display=swap"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Fredericka+the+Great|Press+Start+2P&display=swap" rel="stylesheet">
	<link rel="shortcut icon" href="Assets/Images/icon.png" />
</head>
<body>
<div class="background"></div>
	<div class="container">
		<div class="inner-container">
			<h1>Let's see what we have here...</h1>
			<div class="box">
				<form action="jobopeningretriever" method="POST">
					<input type="submit" value="See all current jobs open">	
				</form>
				<br />
				<br />
				<br />
				<br />
				<br /> <a href="EmployeePage.jsp">Return to Recruiter's Portal</a><br />
				<br />
				<br />
				
			</div>
		</div>
	</div>
<%List<JobOpening> jobs = (List<JobOpening>) request.getAttribute("jobs");%>
<%String job_empty = "No available Job Openings right now. Try again later."; %>

	<footer>
		<div class="footer">
			<div class="inner-footer">
				<div class="text">Sniper Contractor Inc, 2019 &copy;</div>
				<div class="social-menu">
					<ul>
						<li><a href="#"><i class="fa fa-instagram"></i></a></li>
						<li><a href="#"><i class="fa fa-github"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
	</footer>
</body>
</html>