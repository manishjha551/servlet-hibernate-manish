<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reddit: Log-in Page</title>
</head>
<body>
	<p>
		<font color=red size=5>Login Page</font>
	</p>
	<form action="LoginServlet" method="post">
		<table border="6">
			<tr>
				<td>Email</td>
				<td><input type=email name=em /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type=password name=pass /></td>
			</tr>
			<tr>
				<td><input type=submit value=Sign-In /></td>
				<td><input type=reset /></td>
			</tr>
		</table>
	</form>

	<%=request.getAttribute("loginResult")%>
	
	<a href=index.jsp>Register</a>
</body>
</html>