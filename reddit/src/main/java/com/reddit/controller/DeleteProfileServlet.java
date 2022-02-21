package com.reddit.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reddit.entity.RedditUser;
import com.reddit.service.RedditService;
import com.reddit.service.RedditServiceInterface;

public class DeleteProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession s = request.getSession(true);
		String email = (String) s.getAttribute("id");

		RedditUser m = new RedditUser();
		m.setEmail(email);

		RedditServiceInterface rsi = new RedditService();
		boolean flag = rsi.deleteProfile(m);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<html> <head> <title>Reddit: Profile Deleted</title> </head> <body> <center>");

		if (flag) {
			out.println(
					"<font color=red size=3>Profile deleted. <a href=index.jsp> Click to go to register page </a> </font>");
			out.println("<br><br><br>");
			s.removeAttribute("id");
		} else {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.jsp");
			rd.forward(request, response);
		}
		out.println("</table> </center> </body> </html>");
	}

}
