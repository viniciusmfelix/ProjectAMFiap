<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Resume Register/Update</h1>
<form action="resumeregister" method="POST">
<textarea name="goals" rows="5" cols="30" placeholder="Type here your goals..." required></textarea><br/><br/>
<textarea name="academy_training" rows="5" cols="30" placeholder="Type here your academy training..." required></textarea><br/><br/>
<textarea name="professional_experience" rows="5" cols="30" placeholder="Type here your professional experiences..."></textarea><br/><br/>
<input type="text" name="language" size="39" placeholder="Type your languages here..."><br/><br/>
<textarea name="extracurricular_courses" rows="5" cols="30" placeholder="Type here your extracurricular courses..."></textarea><br/><br/>
<input type="text" name="email" placeholder="Confirm your email here..."><br/><br/>
<input type="submit" value="Submit Resume to profile"><br/><br/>
<a href="UserPage.jsp">Return to User Page</a>
</form>
</body>
</html>