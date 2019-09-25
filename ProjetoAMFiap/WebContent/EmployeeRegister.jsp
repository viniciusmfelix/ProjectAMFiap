<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Employee SignUp</h1><br/><br/>
<form action="employeeregister" method="POST">
<input type="number" name="employee_code" placeholder="Enter code here..."><br/><br/>
<input type="text" name="name" placeholder="Enter name here..."><br/><br/>
<input type="text" name="lastname" placeholder="Enter last name here..."><br/><br/>
<input type="text" name="email" placeholder="Enter email here..."><br/><br/>
<input type="password" name="password" placeholder="Enter password here..."><br/><br/>
<input type="password" name="password_confirm" placeholder="Confirm password..."><br/><br/>
<input type="password" name="password_adm" placeholder="Confirm ADM password for access..."><br/><br/>
<input type="submit" value="SignUp">
</form>
</body>
</html>