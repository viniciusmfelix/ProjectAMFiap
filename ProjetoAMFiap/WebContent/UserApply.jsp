<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="userapply" method="POST">
<input type="number" name="jo_code" placeholder="Insert Job Opening code here..."><br/><br/>
<input type="text" name="email" placeholder="Confirm your email here..."><br/><br/>
<input type="submit" value="Apply Myself">
</form><br/><br/>
<%String job_apply = (String) request.getAttribute("job_apply");%>
<%=job_apply%><br/><br/>
If you don't know your Job Opening code, check it out <a href="JobOpeningList.jsp">here</a>
</body>
</html>