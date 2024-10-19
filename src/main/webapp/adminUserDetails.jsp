<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/adminIndex.css">
<link rel="stylesheet" href="CSS/adminUserDetails.css">

</head>
<body>
<div class="maindiv">

<div class="leftMenudiv">
<%@include file="adminMenus.jsp" %>
</div>
<div class="rightMenuDiv">
 

 <%
    userService userService = new userServiceImpl();
 List<UserInfoModel> m = userService.isgetAllUsers();
    PostService postService = new PostServiceImpl();
    if(m!=null){
    	
    for(UserInfoModel model:m){
    	
    
    %><div class="profilemainContaint">
 <div class="containt">
     <div class="profilecs">
   
    
    
    <div class="profilePhotoLogocs">
    
    </div>
   <div class="usernamecs">
  <h2><%= model.getUsername() %></h2>
  <h5><%= model.getName() %></h5>
  <h5><%= model.getPass() %></h5>
  
  <p><%= model.getEmail() %></p>
  <%
  int followingCount = userService.getFollowingCount(model.getId());
  int followerCount = userService.getFollowerCount(model.getId());
  String uploadDir = getServletContext().getRealPath("")+"uploads";
  List<PostLikeCount> likecountlist = postService.ViewAllPosts(model.getId());
  int postcount = 0;
  if (likecountlist != null) {
      for (PostLikeCount p : likecountlist) {
          if (p.getPost() != null) {
              ++postcount;
          }
      }
      
  %>
  
  <a href="#">Posts: <%= postcount %></a>
  <a href="">followers: <%= followerCount %></a>
  <a href="">followings: <%= followingCount %></a>
   <%
   }
  else{
	  %>
	  <a href="#">Posts: <%= postcount %></a>
   <a href="">followers: <%= followerCount %></a>
   <a href="">followings: <%= followingCount %></a>
   
	  <%
  }
 %>
   </div>
    
    </div>



</div>

</div>
<%
  }
    }
    else{
    	%>
    	<h2 style="color:white">Data not Found</h2>
    	<% 
    }
%>
</div>
</div>
</body>
</html>