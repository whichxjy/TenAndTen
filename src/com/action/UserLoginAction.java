package com.action;

import org.apache.struts2.ServletActionContext;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class UserLoginAction extends ActionSupport {
	private User user;	
	
	private UserDAO userDAO;
	
	public UserLoginAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// µÇÂ¼
		System.out.println(user.getName() + " " + user.getPassword());
		
		if (userDAO.userLogin(user.getName(), user.getPassword())) {
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
