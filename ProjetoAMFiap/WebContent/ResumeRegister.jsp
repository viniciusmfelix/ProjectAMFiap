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
<textarea rows="5" cols="30" name="goals"></textarea>
<input type="text" name="academy_training_course" placeholder="Academy Course Name"><br/><br/>
<input type="text" name="academy_training_institution" placeholder="Academy Name"><br/><br/>
<input type="date" name="academy_training_startdate" placeholder="Date of start"><br/><br/>
<input type="date" name="academy_training_enddate" placeholder="Date of start"><br/><br/>
<input type="text" name="professional_experience_jobtitle" placeholder="Job Title"><br/><br/>
<input type="text" name="professional_experience_employer" placeholder="Employer's name"><br/><br/>
<textarea rows="5" cols="30" name="professional_experience_description"></textarea>
<input type="date" name="professional_experience_startdate" placeholder="Job Start date"><br/><br/>
<input type="date" name="professional_experience_enddate" placeholder="Job end date"><br/><br/>
<input type="text" name="language_1" placeholder="Lang 1"><br/><br/>
<input type="text" name="language_2" placeholder="Lang 2"><br/><br/>
<input type="text" name="language_3" placeholder="Lang 3"><br/><br/>
<input type="text" name="language_4" placeholder="Lang 4"><br/><br/>
<input type="text" name="language_5" placeholder="Lang 5"><br/><br/>
<input type="text" name="extracurricular_1" placeholder="Extra 1"><br/><br/>
<input type="text" name="extracurricular_2" placeholder="Extra 2"><br/><br/>
<input type="text" name="extracurricular_3" placeholder="Extra 3"><br/><br/>
<input type="text" name="extracurricular_4" placeholder="Extra 4"><br/><br/>
<input type="text" name="extracurricular_5" placeholder="Extra 5"><br/><br/>
 
<input type="submit" value="Submit Resume to profile"><br/><br/>
<a href="UserPage.jsp">Return to User Page</a>
</form>
</body>
</html>