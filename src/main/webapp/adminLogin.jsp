<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="JS/loginpage.js"></script>
<link rel="stylesheet" href="CSS/adminLogin.css">
<link rel="stylesheet" href="CSS/loginpage.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
</head>
<body>

	<div class="mainlogin">
		<div class="imgidiv">
			<img id="mainImg" src="asset/loginpimg.jpg">

			<div class="loginformdiv ">
			<h3 id="admin">Admin Login</h3>
				<form name="frm" action="adlogin" method="get" onsubmit="return login()">
					<div class="form-group">
						<label >Username</label> 
						<input id="name" name="username" type="text" class="form-control" 
							 placeholder="Enter Username" > 
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> 
						<input type="password" name="password" class="form-control" id="password"
							placeholder="Enter Password">
					</div>
					
					<button type="submit" id="submitbtn" class="btn btn-primary" style="margin-left:110px">Login</button>
					
				</form>
				

			</div>

		</div>


	</div>


</body>
</html>