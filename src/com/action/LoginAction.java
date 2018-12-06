package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class LoginAction extends ActionSupport {
	private User user;	

	
	// ��¼��ʾ
	private String tip;
	
	private UserDAO userDAO;

	
	
	public LoginAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// ��¼
		if (userDAO.userLogin(user.getName(), user.getPassword())) {
			// ���� HttpSession ʵ��
			ActionContext.getContext().getSession().put("username", user.getName());
			setTip("��¼�ɹ���");

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
