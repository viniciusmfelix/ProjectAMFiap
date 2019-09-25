<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="employeelogin" method="POST">
<input type="number" name="employee_code" placeholder="Enter code here..." required><br/><br/>
<input type="password" name="password" placeholder="Enter password here..." required><br/><br/>
<input type="submit" value="SignIn"><br/><br/>
</form>
<a href="EmployeeRegister.jsp">Cadastro de recrutadores</a>
</body>
</html>