<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/adminIndex.css">
<link rel="stylesheet" href="CSS/search.css">
<link rel="stylesheet" href="CSS/adminSearch.css">
<script src="JS/search.js"></script>
</head>
<body>
<div class="maindiv">

<div class="leftMenudiv">
<%@include file="adminMenus.jsp" %>
</div>
<div class="rightMenuDiv">

<div class="searchdiv">
<input type="text" id="searchinput"name="search" placeholder="Search Here" onkeyup="isSearchUseradmin(this.value)"/>


<div id="pointedDiv" >
<%
int registerid=(Integer)session.getAttribute("userid");
userService userService=new userServiceImpl();
List <UserInfoModel>list=userService.isgetAllUsers();
if(list!=null){
for(UserInfoModel m:list){
	int userid=m.getId();
	%>
	
	
<div class="followerInfo">
<div class="logo">
</div>
<a id ="anker"href="adminShowAllPostUser.jsp?registerid=<%=m.getId()%>">
<div class="username">
 <span><%=m.getUsername() %></span><br>
<%=m.getName()%>
</div>
</a>


 </div>
	
	

	<% 
}
}
else{
	%>
	<h2>No Data Found</h2>
	<% 
}
%>
</div>

</div>


</div>

</div>
</body>
</html>