<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.sql.*" %>   
<%@page import="crud.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Faculty Information</title>
<link rel="stylesheet" href="style.css">

<%
if(session.getAttribute("sessionaid")==null)
{
	response.sendRedirect("adminlogin.jsp");
}


%>
</head>
<body>
<div class="table-data">

<a class="btn2" href="viewstudentinfo.jsp">
<i class="fa fa-home" aria-hidden="true">Home</i></a>
<a class="btn2" href="viewfeed.jsp">
<i class="fa fa-thumbs-up"  aria-hidden="true">Feedback</i></a>
<a class="btn2" href="../AdminLogoutSer">
<i class="fa fa-sign-out" aria-hidden="true">Logout</i></a>

<table cellpadding="0" cellspacing="0">
<tr><th colspan="5">Faculty Information</th></tr>
<tr><th>FID</th><th>FACULTYNAME</th><th>BRANCH</th><th>SUBJECT</th><th>EDIT|DELETE</th></tr>
<%
Crud_op.connect();
ResultSet res = Crud_op.fshowdata();
while(res.next())
{ %>
<tr>
<td><%= res.getString(1) %></td>
<td><%= res.getString(2) %></td>
<td><%= res.getString(3) %></td>
<td><%= res.getString(4) %></td>
<td>
<a href="edit.jsp?q=<%= res.getString(1) %>"><i class="fa fa-pencil-square-o" aria-hidden="true">Edit</i>|</a>
<a href="delete.jsp?q=<%= res.getString(1) %>"><i class="fa fa-trash" aria-hidden="true">Delete</i></a>
</td>
</tr>
	 
<% 

}
%>
<form action="../FInsertSer" method="post">
<tr>
<td><div class="textbox">
<input type="text" name="txtrno" placeholder="Enter ID" required>
</div></td>
<td><div class="textbox">
<input type="text" name="txtname" placeholder="Enter Name" required />
</div></td>
<td><div class="textbox">
<input type="text" name="txtbranch" placeholder="Enter Branch" required/>
</div></td>
<td><div class="textbox">
<input type="text" name="txtfees" placeholder="Enter Sub" required/>
</div></td>
<td><input class="btn" type="submit" name="btnsubmit" value="INSERT" ></td></tr>
</form>
</table>
</div>
</body>
</html>