<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/adminIndex.css">
<link rel="stylesheet" href="CSS/adminShowAllPostUser.css">
</head>
<body>
<div class="maindiv">

<div class="leftMenudiv">
<%@include file="adminMenus.jsp" %>
</div>
<div class="rightMenuDiv">
<div class="maininfodiv">
<%
PostService postService = new PostServiceImpl();
userService userService = new userServiceImpl();
int registerid = Integer.parseInt(request.getParameter("registerid"));
List<PostLikeCount> likecountlist = postService.ViewAllPosts(registerid);
UserInfoModel model = userService.isgetAllDatauser(registerid);
if(likecountlist!=null){
for (PostLikeCount p : likecountlist) {
%>
<div class="postdiv">
<div class="logo">
<div class="pphoto">

</div>
</div>
<div class="username">
<h2><%=model.getUsername() %></h2>
</div>
<div class="post">

<a href="adminPrediction.jsp?post=<%=p.getPost() %>">

<p><%=p.getPost() %></p>
</div>
</a>
</div>
<% 	
}
}
else{
	
	%>
	<h1 style="color:white; text-align:center">Post Not Avaliable</h1>
	<% 
}

%>



</div>
</div>

</div>
</body>
</html>