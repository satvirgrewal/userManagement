<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <form action="add.html" method="post">
Username: <input type="text" name="username"/><br />
Password: <input type="text" name="password"/><br />
<input type="submit" name="add" value="Add"/>
</form> --%>
<form:form modelAttribute="user">
Username: <form:input path="username"/><form:errors path="username"  /> <br />
Password: <form:input path="password"/><form:errors path="password"  /><br />
<input type="submit" value="Add"/>
</form:form>

</body>
</html>