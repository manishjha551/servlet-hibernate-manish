<html>
<head>
<title>Reddit: Register Page</title>
</head>
<body>
	<p>
		<font color=red size=5>Registration Page</font>
	</p>
	<form action="RegistrationServlet" method="post">
		<table border="6">
			<tr>
				<td>Name</td>
				<td><input type=text name=nm required /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type=email name=em /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type=password name=pass maxlength=16 minlength=3 /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type=text name=ad /></td>
			</tr>

			<tr>
				<td><input type=Submit value=Register></td>
				<td><input type=reset></td>
			</tr>
		</table>
	</form>
	<br>
	<br>
	<br>
	<%
	if (String.valueOf(request.getAttribute("registereResult")).equals(null)) {
		System.out.println("It is null");
		out.println(request.getAttribute("registereResult"));
	} else {
		out.println(request.getAttribute("registereResult"));
	}
	System.out.println(request.getAttribute("registereResult"));
	%>
	
	<a href=login.jsp>Log-in</a>
</body>
</html>

