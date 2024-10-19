<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="behaviour.module.model.*" %>
    <%@page import="behaviour.module.service.*" %>
    <%@page import="java.util.*" %>
    <%@page import="java.io.File" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/profile.css"/>
<!-- Bootstrap Icons CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css">
</head>
<body>
<div class="profileMainDiv">
    <div class="profileLeftMenuDiv">
        <jsp:include page="menus.jsp" />
    </div>
    <%
    int registerid = Integer.parseInt(request.getParameter("registerid"));
    userService userService = new userServiceImpl();
    UserInfoModel model = userService.isgetAllDatauser(registerid);
    PostService postService = new PostServiceImpl();
    %>
    
    <div class="profilemainContaint">
    <div class="containt">
    <div class="profilecs">
    <div class="profilePhotoLogocs">
    
    </div>
   <div class="usernamecs">
  <h2><%= model.getUsername() %></h2>
  <h5><%= model.getName() %></h5>
  <p><%= model.getEmail() %></p>
  <%
  int followingCount = userService.getFollowingCount(registerid);
  int followerCount = userService.getFollowerCount(registerid);
  String uploadDir = getServletContext().getRealPath("")+"uploads";
  List<PostLikeCount> likecountlist = postService.ViewAllPosts(registerid);
  int postcount = 0;
  if (likecountlist != null) {
      for (PostLikeCount p : likecountlist) {
          if (p.getPost() != null) {
              ++postcount;
          }
      }
      
  %>
  
  <a href="#">Posts: <%= postcount %></a>
  <a href="followers.jsp?registerid=<%= registerid %>">followers: <%= followerCount %></a>
  <a href="following.jsp?registerid=<%= registerid %>">followings: <%= followingCount %></a>
  <%
   int registerids=(Integer)session.getAttribute("userid");
   if(registerids==registerid){
	   %>
  <a href="editProfile.jsp?registerid=<%= registerid %>" id="editProfilebtn">EditProfile</a>
 <%
   }
 %>
   </div>
    
    </div>
   <div class="postdiv">
   <%
   for (PostLikeCount p : likecountlist) {
   %>
   <div class="viewPost">
   <div class="mainHeaderPost">
   <div class="logo">
   
   </div>
   <div class="usernamee">
   <h5><%= model.getName() %></h5>
 
   <div class="post">
   <p><%= p.getPost() %></p>
   
   <%
   int postid = postService.getPostId(p.getPost());
   String filename=p.getFilename();
   String path=uploadDir+"\\"+filename;
   %>
   
   </div>
   
   </div>
    <div class="deletePost">
 <a href="deletepost?postid=<%= postid %>&registerid=<%=registerid%>"><i class="bi bi-trash" style="color:white"></i></a>
  </div> 
   
   
   </div>
  <div class="postImage">
   <img alt="<%= filename %>" src="<%= request.getContextPath() %>/uploads/<%= filename %>" >
</div>

  <div class="likeComment">
   
   <form action="comment" method="post">
    <input type="hidden" name="postid" value="<%= postid %>"/>
    <input type="hidden" name="registerid" value="<%= registerid %>"/>
    <a href="likepost?registerid=<%= registerid %>&postid=<%= postid %>"><i class="bi bi-heart"></i><%= p.getCount() %></a>
    <a href="#"><i class="bi bi-chat-right"></i><%= p.getCommentCount() %></a>
    <input id="comment" type="text" name="commentt" value="" placeholder="Comment Here"/>
 </form>

    </div>
   
   </div>
   
   <%
   }
   %>
   
  </div>
  <%						
      } else {
  %>
   <a href="#">Posts: <%= postcount %></a>
   <a href="followers.jsp?registerid=<%= registerid %>">followers: <%= followerCount %></a>
   <a href="following.jsp?registerid=<%= registerid %>">followings: <%= followingCount %></a>
   
   <%
   int registerids=(Integer)session.getAttribute("userid");
   if(registerids==registerid){
	   %>
	   <a href="editProfile.jsp?registerid=<%= registerid %>" id="editProfilebtn">EditProfile</a>
 <%
   }
   
   %>
  
   <div>
   <h5 style="color:white;padding-top:10px">No Post</h5>
   </div>
  <% 
      }
  %>
    
    </div>
    
    </div>
    
</div>
</body>
</html>
