<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create a New Post</title>
<script src="JS/newPost.js"></script>
<link rel="stylesheet" href="CSS/newPost.css"/>
</head>
<body>
<div class="mainContent">
    <div class="leftprofile">
        <%@ include file="menus.jsp" %>
    </div>
    <div class="newpost">
        <div class="postImgdiv">
            <img id="postimg"src="">
        </div>
        <div class="post">
            <h2>Create Post</h2>
            <form name="frm" action="newpost" method="post" enctype="multipart/form-data" onsubmit="return isValidPost()">
                <input id="newpost" type="text" name="post" placeholder="Create the New Post" value="">
                <input type="file" name="file" id="file" onchange="previewImage()">
                <input type="submit" name="btn" value="Post" id="btn" class="btn btn-primary">
            </form>
            <% 
                String message = (String) request.getAttribute("message");
                if (message != null) {
            %>
                <h4 style="padding-left:150px;padding-top:30px;color:blue"><%= message %></h4>
            <% 
                }
            %>
        </div>
    </div>
</div>
</body>
</html>
