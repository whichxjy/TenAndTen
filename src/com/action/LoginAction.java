package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	private String userName;
	private String userPassword;
	
	// ��¼��ʾ
	private String tip;
	
	private UserDAO userDAO;
	
	
	public LoginAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// ��¼
		if (userDAO.userLogin(userName, userPassword)) {
			// ���� HttpSession ʵ��
			ActionContext.getContext().getSession().put("user", getUserName());
			setTip("��¼�ɹ���");
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


	
	
}
