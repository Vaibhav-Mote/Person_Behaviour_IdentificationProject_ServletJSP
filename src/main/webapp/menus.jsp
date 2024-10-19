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

<%

int registerids=(Integer)session.getAttribute("userid");
PostService postService = new PostServiceImpl();
userService userService=new userServiceImpl();
UserInfoModel model = userService.isgetAllDatauser(registerids);
String name = model.getName();
String username=model.getUsername();
String email = model.getEmail();
char firstLetter=username.charAt(0);
%>
	<div class="profilelogo hk">
		<div class="firstNamelogo">  <h2><%=firstLetter %></h2> </div>
	<div class="namelogo"><%=name %></div>
</div>


<div class="leftdivMenu">
<div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
<a class="nav-link hk" id="v-pills-home-tab"  href="index.jsp?registerid=<%=registerids%>"> <i class="fa-solid fa-house fa-lg"></i>Home</a>
<a class="nav-link hk" id="v-pills-profile-tab" href="profile.jsp?registerid=<%=registerids%>" ><i class="fa-solid fa-user fa-lg"></i>Profile</a> 
<a class="nav-link hk" id="v-pills-messages-tab"  href="search.jsp?registerid=<%=registerids%>" ><i class="fa-solid fa-search"></i>Search</a>
<a class="nav-link hk" id="v-pills-messages-tab"  href="newPost.jsp?registerid=<%=registerids%>" ><i class="fa-solid fa-plus fa-lg"></i>Create New Post</a>
<a class="nav-link hk" id ="logout" href="login.jsp" >Logout</a>
</div>

</div>
</div>

</body>
</html>