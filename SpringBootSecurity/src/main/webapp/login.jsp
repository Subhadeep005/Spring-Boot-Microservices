<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	${SPRING_SECURITY_LAST_EXCEPTION.message}

			<form action="login" method="post">
			<table>
				<tr><td><h1>Login</h1></td></tr>
					<tr><td>Username:</td><td><input type="text"
					name="username" /> </td></tr>
				<tr><td>Password:</td><td><input type="password" name="password" /></td></tr>
				<tr><td><input type="submit" name="submit" value="Submit"></td></tr>
				</table>
			</form>
</body>
</html>