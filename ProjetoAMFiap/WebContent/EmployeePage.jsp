<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sniper Contractor - Recruiter Portal</title>
<link rel="stylesheet" href="Assets/CSS/recruiterportal.css">
<link
	href="https://fonts.googleapis.com/css?family=Fredericka+the+Great|Press+Start+2P&display=swap"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link rel="shortcut icon" href="Assets/Images/icon.png" />

</head>
<body>
	<div class="video">
		<video autoplay muted loop id="recruiterPortalVideo"
			style="width: 100%; height: 100%;">
			<source src="Assets/Videos/background-recruiter-page.mp4">
		</video>
		<div class="background"></div>
	</div>
	<div class="menu">
		<h4>Greetings, ${name}!</h4>
		<div class="inner-menu">
			<div class="item" id="profile">
				<a href="#profile" class="btn"><i class="fa fa-user"></i>Profile</a>
				<div class="submenu">
					<a href="#">Update Profile</a>
				</div>
			</div>
			<div class="item" id="jobs">
				<a href="#jobs" class="btn"><i class="fa fa-search"></i>Job Openings</a>
				<div class="submenu">
					<a href="JobOpeningRegister.jsp">New Job Opening</a> 
					<a href="JobOpeningList.jsp">Available Jobs</a> 
					<a href="JobOpeningSelect.jsp">Select Applies</a> 
					<a href="SendEmailRefusedUsers.jsp">Refused Users</a>
				</div>
			</div>
			<div class="item" id="logout">
				<a href="Logout.jsp" class="btn"><i class="fa fa-sign-out"></i>Exit</a>
			</div>
		</div>
	</div>
	<div class="text">
	<h1>Select perfect candidates in few clicks. Literally!</h1>
	<h2>The 'Job Openings' window gives you selection superpowers like our buddy here. You should try it.. Just an advice.</h2>
	<h3>-It really works dude! Gotham is completely safe now and I can watch my videos on YouTube. -Batman</h3>
	<img src="Assets/Images/batman.png" style="margin-top: 30px;">
	</div>
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