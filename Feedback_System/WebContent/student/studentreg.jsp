<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Regsitration</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<div class="login-box">
<h1>Regsitration</h1>
<form action="../RegSer" method="post">
<div class="textbox">
<i class="fa fa-user" aria-hidden="true"></i>
<input type="text" name="txtuser" placeholder="Enter Name" required/> <br><br>
</div>
<div class="textbox">
<i class="fa fa-lock" aria-hidden="true"></i>
<input type="password" name="txtpass" placeholder="Enter Password" required/><br><br>
</div>
<div class="textbox">
<i class="fa fa-envelope" aria-hidden="true"></i>
<input type="email" name="txtemail" placeholder="Enter Email" required/><br><br>
</div>
<div class="textbox">
<i class="fa fa-mobile" aria-hidden="true"></i>
<input type="mobile" name="txtmobile" placeholder="Enter Mobile" required/><br><br>
</div>
<input class="btn" type="Submit" value="submit"/>
</form>
</div>
</body>
</html>