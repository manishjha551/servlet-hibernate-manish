package com.reddit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.reddit.entity.RedditUser;
import com.reddit.service.RedditService;
import com.reddit.service.RedditServiceInterface;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RedditUser rUser = new RedditUser(request.getParameter("nm"), request.getParameter("em"), 
											request.getParameter("pass"), request.getParameter("ad"));
		
		RedditServiceInterface rService = new RedditService();
		boolean i=rService.signup(rUser);
		
		if(i) {
			System.out.println("Profile Created");
			request.setAttribute("registereResult", "Profile created sucessfully. <a href='login.jsp'>Log-in to continue</a>");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			
			rd.forward(request, response);
		}
		else {
			System.out.println("Profile not Created");
			request.setAttribute("registereResult", "Could not create profile. Try Again");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			
			rd.forward(request, response);
		}
	}

}
