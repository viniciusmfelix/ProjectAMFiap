<%@page import="com.dao.ResumeDAO"%>
<%@page import="com.model.Resume"%>
<%@page import="com.dao.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session = request.getSession(true);
String email = (String) session.getAttribute("email");
UserDAO userdao = new UserDAO();
ResumeDAO resumedao = new ResumeDAO();
int user_id = userdao.returnUserId(email);
Resume resume = (Resume) request.getAttribute("resume");
%>
<h1>Resume Register/Update</h1>
<form action="resumeregister" method="POST">
<textarea rows="5" cols="30" name="goals"></textarea>
<input type="text" name="academy_training_course" placeholder="Academy Course Name"><br/><br/>
<input type="text" name="academy_training_institution" placeholder="Academy Name"><br/><br/>
<input type="date" name="academy_training_startdate" placeholder="Date of start"><br/><br/>
<input type="date" name="academy_training_enddate" placeholder="Date of start"><br/><br/>
<input type="text" name="academy_training_description" placeholder="description academic">
<input type="text" name="professional_experience_jobtitle" placeholder="Job Title"><br/><br/>
<input type="text" name="professional_experience_employer" placeholder="Employer's name"><br/><br/>
<textarea rows="5" cols="30" name="professional_experience_description"></textarea>
<input type="date" name="professional_experience_startdate" placeholder="Job Start date"><br/><br/>
<input type="date" name="professional_experience_enddate" placeholder="Job end date"><br/><br/>
<input type="text" name="language" placeholder="Lang 1"><br/><br/>
<input type="text" name="extracurricular" placeholder="Extra 5"><br/><br/>
<input type="submit" value="Submit Resume to profile"><br/><br/>
<a href="UserPage.jsp">Return to User Page</a>
<%try{ %>
<%=email %>
<%=resume.getGoal().getGoals() %>
<%=resume.getAcademic_training().toString() %>
<%=resume.getProfessional_experience().toString() %>
<%=resume.getLanguages().toString() %>
<%=resume.getExtracurricular_courses().toString() %>
<%}catch(NullPointerException e){/*ignored*/} %>
</form>
</body>
</html>