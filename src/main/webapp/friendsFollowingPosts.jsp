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
<link rel="stylesheet" href="CSS/followinFriendsPost.css">
<link rel="stylesheet" href="CSS/profile.css"/>
<!-- Bootstrap Icons CSS -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.0/font/bootstrap-icons.min.css">

</head>
<body>
<div class="followingFriendsPost">
<%
    int registerid2 = (Integer) session.getAttribute("userid");
    PostService pser1 = new PostServiceImpl();
    List<List<Object>> posts1 = pser1.getFriendsFollowerPosts(registerid2);
    if (posts1 != null) {
        for (List<Object> innerList : posts1) {
            PostLikeCount postLikeCount = null;
            UserInfoModel userInfoModel = null;

            for (Object obj : innerList) {
                if (obj instanceof PostLikeCount) {
                    postLikeCount = (PostLikeCount) obj;
                } else if (obj instanceof UserInfoModel) {
                    userInfoModel = (UserInfoModel) obj;
                }
            }

            if (postLikeCount != null && userInfoModel != null) {
%>
    <div class="postdiv">
        <div class="viewPost">
            <div class="mainHeaderPost">
                <div class="logo">
                    <!-- Add logo content if needed -->
                </div>
                <div class="usernamee">
                    <h5><%= userInfoModel.getUsername() %></h5>
                    <div class="post">
                        <p><%= postLikeCount.getPost() %></p>
                    </div>
                </div>
                <div class="deletePost">
                    <a href="deletePostOnIndex?postid=<%= postLikeCount.getPostid() %>&registerid=<%=userInfoModel.getId() %>">
                        <i class="bi bi-trash" style="color:white"></i>
                    </a>
                </div>
            </div>
            <%
            String uploadDir = getServletContext().getRealPath("")+"uploads";
            String filename=postLikeCount.getFilename();
            String path=uploadDir+"\\"+filename;
            %>
            <div class="postImage">
   <img alt="<%= filename %>" src="<%= request.getContextPath() %>/uploads/<%= filename %>" >
</div>
            <div class="likeComment">
                <form action="comment" method="post">
                    <input type="hidden" name="postid" value="<%= postLikeCount.getPostid() %>"/>
                    <a href="likepost?registerid=<%= registerid2 %>&&postid=<%= postLikeCount.getPostid() %>">
                        <i class="bi bi-heart"></i><%= postLikeCount.getCount() %>
                    </a>
                    <a href="#">
                        <i class="bi bi-chat-right"></i><%= postLikeCount.getCommentCount() %>
                    </a>
                    <input id="comment" type="text" name="commentt" placeholder="Comment Here"/>
                </form>
            </div>
        </div>
    </div>
<%
            }
        }
    } else {
%>
    <h5>No Post</h5>
<%
    }
%>
</div>


</body>
</html>