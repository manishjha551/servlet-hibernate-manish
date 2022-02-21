package com.reddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reddit.entity.RedditUser;
import com.reddit.service.RedditService;
import com.reddit.service.RedditServiceInterface;

public class ViewProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		String email = (String) s.getAttribute("id");

		RedditUser m = new RedditUser();
		m.setEmail(email);

		RedditServiceInterface ms = new RedditService();
		RedditUser mm = ms.viewDetails(m);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html> <head> <title>Reddit: All Users</title> </head> <body> <center>");
		
		out.println("Welcome "+email);
		out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
				+ "		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
				+ "		<button>\r\n"
				+ "			<a href=homepage.jsp>Homepage</a>\r\n"
				+ "		</button> "
				+ "		<button>\r\n"
				+ "			<a href=deletepage.jsp>Delete Profile</a>\r\n"
				+ "		</button>\r\n"
				+ "		<button>\r\n"
				+ "			<a href=ViewAllProfileServlet>View All Profile</a>\r\n"
				+ "		</button> "
				+ "		<br> <br> <br>");
		
		out.println("<font color=red size=5>User Details</font>");
		out.println("<br><br><br>");
		out.println("<table border=\"6\"> ");
		if (mm != null) {
			out.println("<tr> <th>Name</th> <td>" + mm.getName() + "</td> </tr>");
			out.println("<tr> <th>Email</th> <td>" + mm.getEmail() + "</td> </tr>");
			out.println("<tr> <th>Passsword</th> <td>" + mm.getPass() + "</td> </tr>");
			out.println("<tr> <th>Address</th> <td>" + mm.getAddr() + "</td> </tr>");
		} else {
			out.println("<h3>No record found!</h3>");
		}
		out.println("</table> </center> </body> </html>");
	}

}
