package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class UserRegisterAction extends ActionSupport {
	private User user;
	
	private UserDAO userDAO;
	
	public UserRegisterAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// ×¢²áÓÃ»§
		if (userDAO.addUser(user.getName(), user.getPassword())) {
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
