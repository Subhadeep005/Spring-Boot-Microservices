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

	<form action="addAlien">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="aid"></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="aname"></td>
			</tr>
			<tr>
				<td>Tech :</td>
				<td><input type="text" name="tech"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="Submit" value="Add Alien"></th>
			</tr>
		</table>
	</form>

	<form action="updateAlien">
		<table>
			<tr>
				<td>ID :</td>
				<td><select name="alien">
						<c:forEach items="${alienListId}" var="alien">
							<option value="${alien.aid}">${alien.aid}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Name :</td>
				<td><input type="text" name="aname"></td>
			</tr>
			<tr>
				<td>Tech :</td>
				<td><input type="text" name="tech"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="Submit" value="Update Alien"></th>
			</tr>
		</table>
	</form>

	<form action="getAlien">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="aid"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="Submit" value="Get Alien"></th>
			</tr>
		</table>
	</form>

	<form action="getAllAlien">
		<table>
			<tr>
				<th colspan="2"><input type="Submit" value="All Aliens"></th>
			</tr>
		</table>
	</form>

	<form action="deleteAlien">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="aid"></td>
			</tr>
			<tr>
				<th colspan="2"><input type="Submit" value="Delete Alien"></th>
			</tr>
		</table>
	</form>

</body>
</html>