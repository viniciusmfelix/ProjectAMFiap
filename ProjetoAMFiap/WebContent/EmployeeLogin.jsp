<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sniper Contractor - Recruiter Login</title>
<link rel="stylesheet" href="Assets/CSS/recruiterlogin.css">
<link
	href="https://fonts.googleapis.com/css?family=Lobster+Two|Orbitron&display=swap"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Fredericka+the+Great|Press+Start+2P&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Kalam&display=swap" rel="stylesheet"> 
	<link rel="shortcut icon" href="Assets/Images/icon.png" />
</head>
<body>
<div class="background"></div>
	<div class="container">
		<div class="inner-container">
			<h1>Select the <span style="font-family: 'Kalam', cursive">Bests</span>. Easier, faster and with more accuracy.</h1>
			<div class="box">
				<form action="employeelogin" method="POST">
					<div class="inputBox">
						<label style="margin-left:30px">Code:</label> <input type="number" name="employee_code"
							placeholder="Enter code here..." required autofocus><br />
						<br />
					</div>
					<div class="inputBox">
						<label>Password:</label> <input type="password" name="password"
							placeholder="Enter password here..." required><br />
						<br />
					</div>
					<br /> <input type="submit" value="Sign In"><br />
					<br />
				</form>
				<br />
				<br /> <a href="UserLogin.jsp">Users Login</a>
				<br />
				<br />
				<br /> <a href="EmployeeRegister.jsp">Recruiter and not registered? Submit your register here (Administrator password required)</a><br />
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