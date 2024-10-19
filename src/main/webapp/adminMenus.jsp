<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="behaviour.module.service.*" %>
    <%@page import="behaviour.module.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.6.0/css/all.min.css" integrity="sha512-Kc323vGBEqzTmouAECnVceyQqyqdsSiqLQISBL29aUW4U/M7pSPA/gEUZQqv1cwx4OnYxTxve5UMg5GT6L4JJg==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">

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
<link rel="stylesheet" href="CSS/menus.css">
<link rel="stylesheet" href="CSS/index.css">
</head>
<body>
<div class="leftdiv2">

	<div class="profilelogo hk">
		<div class="firstNamelogo">  <h2>v</h2> </div>
	<div class="namelogo">Vaibhav</div>
</div>


<div class="leftdivMenu">
<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
<a class="nav-link hk show-active" id="v-pills-home-tab"  href="adminIndex.jsp"> <i class="fa-solid fa-house fa-lg"></i>Home</a>
<a class="nav-link hk" id="v-pills-profile-tab" href="adminUserDetails.jsp" ><i class="fa-solid fa-user fa-lg"></i>UserDetails</a> 
<a style="display:flex" class="nav-link hk" id="v-pills-messages-tab"  href="adminSearch.jsp" ><i class="fa-solid fa-search" style="margin-top:6px"></i><div class="prediction">
Search user for Prediction
</div></a>

<a class="nav-link hk" id ="logout" href="login.jsp" >Logout</a>
</div>

</div>
</div>

</body>
</html>