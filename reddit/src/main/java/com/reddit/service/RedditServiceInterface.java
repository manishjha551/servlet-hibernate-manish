package com.reddit.service;

import java.util.List;

import com.reddit.entity.RedditUser;

public interface RedditServiceInterface {
	boolean login(RedditUser r);
	
	boolean signup(RedditUser r);
	
	RedditUser viewDetails(RedditUser r);
	
	List<RedditUser> viewAllDetails();
	
	boolean deleteProfile(RedditUser r);

}
