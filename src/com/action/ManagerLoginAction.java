package com.action;

import org.apache.struts2.ServletActionContext;

import com.dao.ManagerDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Manager;

public class ManagerLoginAction extends ActionSupport {
	private Manager manager;
	private String tip; // ��¼��ʾ
	
	private ManagerDAO managerDAO;
	
	public ManagerLoginAction() {
		managerDAO = ManagerDAO.getManagerDAO();
	}
	
	public String execute() {
		// ��¼
		if (managerDAO.managerLogin(manager.getName(), manager.getPassword())) {
			setTip("����Ա " + manager.getName() + "��¼�ɹ���");
			ServletActionContext.getRequest().getSession().setAttribute("manager", manager);
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
