<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="processForm" modelAttribute="product">
<br>
Name : <form:input path="name"/>
<form:errors path="name"/>
<br><br>
<input type="submit" value="submit">
</form:form >
</body>
</html>