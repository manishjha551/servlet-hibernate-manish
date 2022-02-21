package com.reddit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reddit.entity.RedditUser;
import com.reddit.service.RedditService;
import com.reddit.service.RedditServiceInterface;

public class ViewAllProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		String email = (String) s.getAttribute("id");
		
		RedditServiceInterface rsi = new RedditService();
		List<RedditUser> list = rsi.viewAllDetails();

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html> <head> <title>Reddit: All Users</title> </head> <body> <center>");
		
		out.println("Welcome "+email);
		out.print("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
				+ "		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\r\n"
				+ "		<button>\r\n"
				+ "			<a href=ViewProfileServlet>View Profile</a>\r\n"
				+ "		</button>\r\n"
				+ "		<button>\r\n"
				+ "			<a href=deletepage.jsp>Delete Profile</a>\r\n"
				+ "		</button>\r\n"
				+ "		<button>\r\n"
				+ "			<a href=homepage.jsp>Homepage</a>\r\n"
				+ "		</button> "
				+ "		<br> <br> <br>");
		
		
		out.println("<font color=red size=5>Registration Page</font>");
		out.println("<br><br><br>");
		out.println("<table border=\"6\"> ");
		out.println("<tr> <th>Name</th> <th>Email</th> <th>Password</th> <th>Address</th> </tr>");
		if (list != null) {
			for (RedditUser r : list) {
				out.println("<tr>");
				out.println("<th>" + r.getName() + "</th>");
				out.println("<th>" + r.getEmail() + "</th>");
				out.println("<th>" + r.getPass() + "</th>");
				out.println("<th>" + r.getAddr() + "</th>");
				out.println("</tr>");
			}
		} else {
			out.println("<h3>No record found!</h3>");
		}
		out.println("</table> </center> </body> </html>");
	}

}
