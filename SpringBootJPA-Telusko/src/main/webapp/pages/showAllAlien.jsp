<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring Boot with JPA</title>
</head>
<body>
	All Alien List
	<ul>
		<c:forEach var="listValue" items="${allAlienList}">
			<li>${listValue}</li>
		</c:forEach>
	</ul>
</body>
</html>