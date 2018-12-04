package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userName;
	private String userPassword;
	
	private String[] questions;
	
	// 登录提示
	private String tip;
	
	private UserDAO userDAO;
	
	
	public LoginAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// 登录
		if (userDAO.userLogin(userName, userPassword)) {
			// 设置 HttpSession 实例
			ActionContext.getContext().getSession().put("user", getUserName());
			setTip("登录成功！");
			
			String[] q = {"Q1", "Q2", "Q3", "Q4"};
			
//			String[] q = new String[10];
			
			setQuestions(q);
			
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

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String[] getQuestions() {
		return questions;
	}

	public void setQuestions(String[] questions) {
		this.questions = questions;
	}


	
	
}
