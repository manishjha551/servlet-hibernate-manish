<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reddit: Delete Profile</title>
</head>
<body>

<center>
		<%
		HttpSession s = request.getSession(true);
		%>
		Welcome
		<%=s.getAttribute("id")%>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button>
			<a href=ViewProfileServlet>View Profile</a>
		</button>
		<button>
			<a href=homepage.jsp>Homepage</a>
		</button>
		<button>
			<a href=ViewAllProfileServlet>View All Profile</a>
		</button>
		
		<br><br><br>
		
		<font color=red size=3>Do you want to delete profile?</font>
		<br><br>
		<button>
			<a href=DeleteProfileServlet>Yes</a>
		</button>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<button>
			<a href=homepage.jsp>No</a>
		</button>
	</center>

</body>
</html>