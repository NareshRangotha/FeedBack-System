<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
<title>Admin Login</title>
</head>
<body>
<div class="login-box">
<h1>Admin Login</h1>
<form action="../AdminLoginSer" method="post">
<div class="textbox">
<i class="fa fa-user" aria-hidden="true"></i>	
<input type="text" name="txtuser" placeholder="Username" required/> <br><br>
</div>
<div class="textbox">
<i class="fa fa-lock" aria-hidden="true"></i>
<input type="password" name="txtpass" placeholder="Password" required/><br><br>
</div>

<input class="btn" type="Submit" value="Login"/>
</form>
</div>
</body>
</html>