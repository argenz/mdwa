<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
<p> Back to <a href="../index.html">Home</a></p>

 <%@include file="header.html"%>
	<p id="result">
	Welcome to you ${username}              <%-- Questo è un'attributo     <% out.print(request.getParameter("username")); --%> 
	<%-- Welcome to you ${param.username}         Questo è un parametro --%>
	
</body>
</html>