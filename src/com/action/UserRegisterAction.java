package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserRegisterAction extends ActionSupport {
	private User user;		
	private String profilePath;
	private UserService uService;
	
	public UserRegisterAction() {
		uService = UserServiceImpl.getService();
	}
	
	public String execute() {
		// ÓÃ»§×¢²á
		return uService.register(user, profilePath) ? SUCCESS : ERROR;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProfilePath() {
		return profilePath;
	}

	public void setProfilePath(String profilePath) {
		this.profilePath = profilePath;
	}
	
}
