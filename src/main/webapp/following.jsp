<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="behaviour.module.service.*" %>
   <%@page import="behaviour.module.model.*" %>
   <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/followers.css">
<script src="JS/followers.js" ></script>
</head>
<body>

<div class="leftmenuProfile">
<div class="leftprofile">
<%@ include file="menus.jsp" %>
</div>
<div class="followersContaint">

<%
userService userSer=new userServiceImpl();
int registeridfollowing=Integer.parseInt(request.getParameter("registerid"));
List <UserInfoModel>list=userSer.isgetFollowingList(registeridfollowing);
if(!list.isEmpty()){
%>
<div class="followersmaindiv">
<h2 id="headingFollowers">Followings</h2>
<%

for(UserInfoModel m:list){
%>

<div class="followerInfo">
<div class="logo">

</div>
<div class="username">
 <span><%=m.getUsername() %></span><br>
<%=m.getName() %>

</div>
<form action="unfollow" method="get">
                    <input type="hidden" name="registerid" value="<%= m.getId() %>" />
                    <div class="remove">
                        <input type="submit" value="Unfollow" name="remove" />
                    </div>
                </form>

 </div>
 
 <%
 }
 %>
</div>
<% 


}else{
	%>
	<h5 style="color:white ;Margin-left:420px;margin-top:30px;font-size:2em">No Following</h5>
	<% 
}
%>

</div>
</div>
</body>
</html>