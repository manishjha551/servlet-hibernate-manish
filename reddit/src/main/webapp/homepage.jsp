<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reddit: Homepage</title>
</head>
<body>
	<center>
		<%
		HttpSession s = request.getSession(true);
		%>
		Welcome
		<%=s.getAttribute("id")%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button>
			<a href=ViewProfileServlet>View Profile</a>
		</button>
		<button>
			<a href=deletepage.jsp>Delete Profile</a>
		</button>
		<button>
			<a href=ViewAllProfileServlet>View All Profile</a>
		</button>
		<img alt="Welcome Image" src="https://cdn.dribbble.com/users/2322685/screenshots/6221645/welcome-dribbble.gif" />
	</center>
</body>
</html>