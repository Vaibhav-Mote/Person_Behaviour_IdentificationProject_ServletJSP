<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="behaviour.module.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/adminIndex.css">
</head>
<body>
<div class="maindiv">

<div class="leftMenudiv">
<%@include file="adminMenus.jsp" %>
</div>
<div class="rightMenuDiv">
<%
String post=request.getParameter("post");
PredictionService predictSer=new PredictioinSeriviceImpl();
String personBehavior=predictSer.predictPersonBehavior(post);

%>
<h1 style="color:white;margin-left:35% ;margin-top:20%"><%=personBehavior %></h1>




</div>

</div>
</body>
</html>