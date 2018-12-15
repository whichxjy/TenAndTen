package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserRegisterAction extends ActionSupport {
	private User user;		
	private UserService userService;
	
	public UserRegisterAction() {
		userService = UserServiceImpl.getUserServiceImpl();
	}
	
	public String execute() {
		// ÓÃ»§×¢²á
		return userService.register(user) ? SUCCESS : ERROR;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
