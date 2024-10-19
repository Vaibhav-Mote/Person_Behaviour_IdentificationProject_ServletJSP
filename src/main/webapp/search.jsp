<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="behaviour.module.model.*" %>
    <%@page import="behaviour.module.service.*" %>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/search.css">
<script src="JS/search.js"></script>
</head>
<body>
<div class="allcontaint">
<div class="leftdiv">
<%@include file="menus.jsp" %>

</div>
<div class="maincontaint">
<div class="searchdiv">
<input type="text" id="searchinput"name="search" placeholder="Search Here" onkeyup="isSearchUser(this.value)"/>


<div id="pointedDiv">
<%
int registerid=(Integer)session.getAttribute("userid");
List <UserInfoModel>list=userService.isgetAllUsers();
for(UserInfoModel m:list){
	int userid=m.getId();
	%>
	
	
<div class="followerInfo">
<div class="logo">
</div>
<a id ="anker"href="profile.jsp?registerid=<%=m.getId()%>">
<div class="username">
 <span><%=m.getUsername() %></span><br>
<%=m.getName()%>
</div>
</a>
<div class="follows">
    <a id="follow"  onclick="follow(<%=registerid%>, <%=userid%>)">Follow</a>
</div>



 </div>
	
	

	<% 
}
%>
</div>

</div>

</div>


</div>


</body>
</html>