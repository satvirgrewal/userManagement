<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>User Management</h2>
<table border="1">
<tr>
<th>UserId</th><th>Username</th><th>Password</th><th>Operations</th>
<c:forEach items="${users}" var="user">
<tr>
<td>${user.id}</td>
<td>${user.username}</td>
<td>${user.password}</td>
<td>
<a href="view.html?id=${user.id}">View</a>
<a href="view/${user.id}.html">View 2</a>
<a href="edit.html?id=${user.id}">Edit</a>
</td>
</tr>
</c:forEach>
</tr>
</table>
<p><a href="add.html"> Add new user</a></p>
</body>
</html>