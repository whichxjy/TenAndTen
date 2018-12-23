package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserLoginAction extends ActionSupport {
	private User user;		
	private UserService uService;
	
	public UserLoginAction() {
		uService = UserServiceImpl.getService();
	}
	
	public String execute() {		
		return uService.login(user) ? SUCCESS : ERROR;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
