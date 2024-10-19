<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/editProfile.css">
<script src="JS/editProfile.js" ></script>
</head>
<body>

<div class="maindiv">

<div class="leftmenu">
<%@include file="menus.jsp" %>

</div>
<div class="maincontaint">
<div class="editprofile">
<h2 id="editheader">Edit Profile</h2>
<%
int userid1=Integer.parseInt(request.getParameter("registerid"));
UserInfoModel model1 = userService.isgetAllDatauser(userid1);
%>
<form method="get" onsubmit=" return isUniqueUsername(userid1)"  >
    <div class="logo">
    </div>

    <label>Username</label><br>
    <input id="username" type="text" name="username" value="<%=model1.getUsername()%>" required/><br>
    <label>Name</label><br>
    <input id="name" type="text" name="name" value="<%=model1.getName()%>"/><br>
    <label>Email</label><br>
    <input id="email" type="text" name="email" value="<%=model1.getEmail()%>"/>
    <input id="btn" type="submit" name="btn" value="Update"/>
    <div id="message" style="color:white;margin-left:30%;width:50% "></div>
  
</form>

</div>

</div>


</div>

</body>
</html>