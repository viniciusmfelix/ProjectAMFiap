<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sniper Contractor - New Job Opening</title>
<link rel="stylesheet" href="Assets/CSS/jobopeningregister.css">
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
			<h1>Great! Time to get started.</h1>
			<div class="box">
				<form action="userlogin" method="POST">
					<div class="inputBox">
						<label>Job Code:</label> <input type="number" name="jo_code"
							placeholder="Enter job opening code here..." required autofocus><br />
						<br />
					</div>
					<div class="inputBox">
						<label style="margin-left:27px;">Name:</label> <input type="text" name="name"
							placeholder="Enter the office name here..." required><br />
						<br />
					</div>
					<div class="inputBox">
						<label style="margin-left:-12px;">Description:</label> <input style="height:100px;text-align:top;"type="text" name="description"
							placeholder="Enter the job description here..." required><br />
						<br />
					</div>
					<br /> <input type="submit" value="Create Job"><br />
					<br />
				</form>
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
				<br/>
				<br /> <a href="EmployeePage.jsp">Return to Recruiter's Portal</a><br />
				
			</div>
		</div>
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