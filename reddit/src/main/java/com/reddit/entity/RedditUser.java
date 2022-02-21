package com.reddit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reddittable")
public class RedditUser {
	@Id
	String email;
	
	String password;
	String name;
	String addr;

	public RedditUser() {};
	
	public RedditUser(String name, String email, String password, String addr) {
		this.email = email;
		this.password = password;
		this.name = name;
		this.addr = addr;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
