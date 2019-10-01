<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sniper Contractor - Recruiter Register</title>
<link rel="stylesheet" href="Assets/CSS/recruiterregister.css">
<link
	href="https://fonts.googleapis.com/css?family=Fredericka+the+Great|Press+Start+2P&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lobster+Two|Orbitron&display=swap"
	rel="stylesheet">
<link
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
	<link rel="shortcut icon" href="Assets/Images/icon.png" />
</head>
<body>
<div class="background"></div>
	<div class="container">
		<div class="inner-container">
			<h1>More hands to help! That's awesome!</h1>
			<div class="box">
				<form action="userregister" method="POST">
				<div class="inputBox">
						<label style="margin-left:35px;">Code:</label> <input type="number" name="employee_code"
							placeholder="Enter recruiter's code here..." required><br />
						<br />
					</div>
					<div class="inputBox">
						<label style="margin-left: 30px;">Name:</label> <input type="text" name="name"
							placeholder="Enter first name here..." required autofocus><br />
						<br />
					</div>
					<div class="inputBox">
						<label>Last Name:</label> <input type="text" name="lastname"
							placeholder="Enter last name here..." required><br />
						<br />
					</div>
					<div class="inputBox">
						<label style="margin-left: 35px;">Email:</label> <input type="text" name="email"
							placeholder="Enter email here..." required autofocus><br />
						<br />
					</div>
					<div class="inputBox">
						<label style="margin-left:5px;">Password:</label> <input type="password" name="password"
							placeholder="Enter password here..." required autofocus><br />
						<br />
					</div>
					<div class="inputBox">
						<label style="margin-left:5px;">Password:</label> <input type="password" name="password_confirm"
							placeholder="Enter password confirm here..." required><br />
						<br />
					</div>
					<div class="inputBox">
						<label style="margin-left:5px;">Password:</label> <input type="password" name="password_adm"
							placeholder="Enter administrator password here..." required><br />
						<br />
					</div>
					<br /> <input type="submit" value="Sign Up"><br />
					<br />
				</form>
				<br />
				<br /> <a href="EmployeeLogin.jsp">Recruiters Login</a>
				<br />
				<br />
				<br /> <a href="UserLogin.jsp">Users Login</a><br />
				<br />
				<br /> <a href="UserRegister.jsp">Users Register</a>
				
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