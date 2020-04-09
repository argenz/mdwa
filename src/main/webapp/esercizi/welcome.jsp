<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Welcome</title>
</head>
<body>
	<p>
		Back to <a href="../index.html">Home</a>
	</p>

	<%@include file="header.html"%>
	<p id="result">
		Welcome to you ${username} <%-- Questo è un'attributo     <% out.print(request.getParameter("username")); --%>
<%-- Welcome to you ${param.username}   Questo è un parametro --%>
	<h2>Coders:</h2>
	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">#</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="coder" items="${coders}">
				<tr>
					<td scope="row">${coder.coderID}</td>
					<td>${coder.firstName}</td>               <%-- .firstName va proprio a prendere il javaBean Coder e chiama il getFirstName!!! --%>
					<td>${coder.lastName}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>