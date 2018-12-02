package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private String userName;
	private String userPassword;
	
	private UserDAO userDAO;
	
	public RegisterAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// ×¢²áÓÃ»§
		if (userDAO.addUser(userName, userPassword)) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

}
