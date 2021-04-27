<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.*" %>   
<%@page import="crud.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>View feedback</title>

<%
if(session.getAttribute("sessionaid")==null)
{
	response.sendRedirect("adminlogin.jsp");
}


%>
</head>
<body>
<div class="feed-data">

<a class="btn2" href="viewstudentinfo.jsp">
<i class="fa fa-home" aria-hidden="true">Home</i></a>
<a class="btn2" href="viewfeed.jsp">
<i class="fa fa-thumbs-up"  aria-hidden="true">Feedback</i></a>
<a class="btn2" href="../AdminLogoutSer">
<i class="fa fa-sign-out" aria-hidden="true">Logout</i></a>

<table cellpadding="0" cellspacing="0">
<tr><th colspan="5">View Feedback Info here</th></tr>
<tr><th>FeedID</th><th>FacultyNAME</th><th>FeedTo</th><th>Rating</th><th>POSTDATE</th></tr>
<%
Crud_op.connect();
ResultSet res = Crud_op.showfeedback();
while(res.next())
{ %>
<tr><td><%= res.getString(1) %></td><td><%= res.getString(2) %></td><td><%= res.getString(3) %></td><td><%= res.getString(4) %></td><td><%= res.getString(5) %></td></tr>
	 
<% 

}
%>


</table>
</div>
</body>
</html>