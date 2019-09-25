<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Job Opening Register</h1>
<form action="jobopeningregister" method="POST">
<input type="number" name="jo_code" placeholder="Enter code of job opening here..." required><br/><br/>
<input type="text" name="name" placeholder="Enter name of the office here..." required><br/><br/>
<textarea rows="5" cols="30" name="description" placeholder="Enter description here..." required></textarea><br/><br/>
<input type="submit" value="Register Job Opening">
</form>
</body>
</html>