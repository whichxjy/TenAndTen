package com.action;

import org.apache.struts2.ServletActionContext;

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
		// ��¼		
		if (uService.login(user)) {
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
