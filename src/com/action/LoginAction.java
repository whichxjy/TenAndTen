package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class LoginAction extends ActionSupport {
	private User user;	

	
	// 登录提示
	private String tip;
	
	private UserDAO userDAO;

	
	
	public LoginAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// 登录
		if (userDAO.userLogin(user.getName(), user.getPassword())) {
			// 设置 HttpSession 实例
			ActionContext.getContext().getSession().put("username", user.getName());
			setTip("登录成功！");

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
