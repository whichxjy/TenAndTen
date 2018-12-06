package com.action;

import com.dao.ManagerDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Manager;

public class ManagerLoginAction extends ActionSupport {
	private Manager manager;
	private String tip; // 登录提示
	
	private ManagerDAO managerDAO;
	
	public ManagerLoginAction() {
		managerDAO = new ManagerDAO();
	}
	
	public String execute() {
		// 登录
		if (managerDAO.managerLogin(manager.getName(), manager.getPassword())) {
			setTip("管理员 " + manager.getName() + "登录成功！");

			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}
}
