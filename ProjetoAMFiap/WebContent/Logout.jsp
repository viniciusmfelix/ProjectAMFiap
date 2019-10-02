<%@page import="com.dbconnection.ConnectToOracle"%>
<%@page import="java.sql.Connection"%>
<%
session.invalidate();
response.sendRedirect("Home.jsp");
%>