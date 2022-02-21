package com.reddit.service;

import java.util.List;

import com.reddit.dao.RedditDAO;
import com.reddit.entity.RedditUser;

public class RedditService implements RedditServiceInterface{
	RedditDAO rDAO = new RedditDAO();
	@Override
	public boolean login(RedditUser r) {
		return rDAO.login(r);
	}

	@Override
	public boolean signup(RedditUser r) {
		return rDAO.signup(r);
	}

	@Override
	public RedditUser viewDetails(RedditUser r) {
		return rDAO.viewDetails(r);
	}

	@Override
	public List<RedditUser> viewAllDetails() {
		return rDAO.viewAllDetails();
	}

	@Override
	public boolean deleteProfile(RedditUser r) {
		return rDAO.deleteProfile(r);
	}

}
