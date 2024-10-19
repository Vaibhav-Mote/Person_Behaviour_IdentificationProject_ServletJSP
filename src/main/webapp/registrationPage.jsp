<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="CSS/registrationPage.css">
<script src="JS/registration.js"></script>

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
	<div class="maindiv">
		<div class="imgdiv">
			<img src="asset/gifimg.gif">
		</div>
		<div class="formdiv">
			<form name="frm" action="registr" method="get" onsubmit=" return register()">
				<h4 id="registerlogo">Register Here</h4>
				<div class="form-group">
					<label >Name</label> 
					<input id="name" name="name" type="text" class="form-control" placeholder="Enter Name" ">
				</div>
				<div class="form-group">
					<label >Email</label> 
					<input id="email" name="email" type="text" class="form-control" placeholder="Enter Email" required>
					<span  id="emailMessage" style="color:red"></span>
                       
				</div>
				<div class="form-group">
					<label >Username</label> 
					<input id="username" type="text" name="username" class="form-control" placeholder="Enter Username">
				</div>
				<div class="form-group">
					<label >Password</label> 
					<input id="password" type="password" name="password" class="form-control" placeholder="Enter Password">
				</div>

				<button type="submit" id="submitbtn" class="btn btn-primary ">Submit</button>
				<a href="login.jsp" id="submitbtn"
					class="btn btn-primary ">Go Login</a>
					
					
			</form>
			<%
			String message=(String)request.getAttribute("message");
			if(message!=null){
				%>
				<p style="padding-left:70px"><%=message %></p>
				<%
			}
			%>

		</div>

	</div>


</body>
</html>