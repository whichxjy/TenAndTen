package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class UserLoginAction extends ActionSupport {
	private User user;	
	private String tip; // 登录提示
	
	private UserDAO userDAO;

	
	public UserLoginAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// 登录
		if (userDAO.userLogin(user.getName(), user.getPassword())) {

			setTip("用户 " + user.getName() + "，登录成功！");

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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}


}
