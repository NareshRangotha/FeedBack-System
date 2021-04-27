<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Faculty Login</title>
<link rel="stylesheet" href="../student/style.css">
</head>
<body>
<div class="login-box">
<h1>Faculty Login</h1>
<form action="../FacultyLoginSer" method="post">
<div class="textbox">
<i class="fa fa-user" aria-hidden="true"></i>
<input type="text" name="txtuser" placeholder="Username" required/><br><br>
</div>
<div class="textbox">
<i class="fa fa-lock" aria-hidden="true"></i>
<input type="password" name="txtpass" placeholder="Password" required/><br><br>
</div>
<input class="btn" type="Submit" value="Login"/>
</form>
<br>
<div class="create">
<i class="fa fa-user-plus" aria-hidden="true"></i>
<a href="facultyreg.jsp">New Faculty Register</a>
</div>
</div>
</body>
</html>