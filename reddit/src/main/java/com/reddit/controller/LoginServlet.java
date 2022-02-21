package com.reddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.reddit.entity.RedditUser;
import com.reddit.service.RedditService;
import com.reddit.service.RedditServiceInterface;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RedditUser rUser = new RedditUser();
		rUser.setEmail(request.getParameter("em"));
		rUser.setPass(request.getParameter("pass"));

		RedditServiceInterface rService = new RedditService();
		boolean i = rService.login(rUser);

		if (i) {
			System.out.println("Login Suceassful");
			
			HttpSession s=request.getSession(true);
			s.setAttribute("id", rUser.getEmail());
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/homepage.jsp");

			rd.forward(request, response);
		} else {
			System.out.println("Login failed");
			request.setAttribute("loginResult", "Could not Login. Try Again");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");

			rd.forward(request, response);
		}
	}

}
