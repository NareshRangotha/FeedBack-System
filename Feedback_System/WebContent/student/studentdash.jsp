<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student DASH</title>
<link rel="stylesheet" href="style.css">
<a href="../StudentLogoutSer">Logout</a>
<%
if(session.getAttribute("sessionsid")==null)
{
	response.sendRedirect("studentlogin.jsp");
}


%>
</head>
<body>

<div class="login-box">
<h1>Welcome <%= session.getAttribute("sessionsid") %> in STUDENT DASHBOARD</h1>
<form action="../FeedSer" method="post">
<div class="textbox">
<i class="fa fa-user" aria-hidden="true"></i>
<input type="text" name="txtfname" placeholder="Enter Faculty Name" />
<br><br>
</div>
<div class="textbox">
<select class="btn1" name="rating">
<option value="">Rating</option>
<option value="5">Excellent</option>
<option value="4">BEST</option>
<option value="3">Good</option>
<option value="2">Average</option>
<option value="0">Poor</option>
</select>
</div>
<br><br>
<input class="btn" type="submit" name="btnsubmit" value="Click" />
</form>
<%
if(request.getParameter("q")!=null)
{
	out.write(request.getParameter("q"));
}



%>
</div>
</body>
</html>
