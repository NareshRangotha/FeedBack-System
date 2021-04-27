<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.*" %>   
<%@page import="crud.*" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Record</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="edit-delete">

<h1>Delete Record</h1>
<form action="../DeleteSer" method="post">
<table border="1">

<%
Crud_op.connect();
ResultSet res = Crud_op.findData(Integer.parseInt(request.getParameter("q")));
if	(res.next())
{ %>	
<tr><th>RNO</th><td><input type="text" name="txtrno" value="<%= res.getString(1) %>" /></td></tr>
<tr><th>NAME</th><td><input type="text" name="txtsname" value="<%= res.getString(2) %>" /></td></tr>
<tr><th>BRANCH</th><td><input type="text" name="txtbranch" value="<%= res.getString(3) %>" /></td></tr>
<tr><th>FEES</th><td><input type="text" name="txtfees" value="<%= res.getString(4	) %>" /></td></tr>
<tr><td colspan="2">
<input class="btn" type="submit" value="Delete" /> 
<a href="viewstudentinfo.jsp">Cancel<i class="fa fa-times" aria-hidden="true"></i></a></td>
</tr>
	 
<% 

}
%>
</table>
</form>
</div>
</body>
</html>