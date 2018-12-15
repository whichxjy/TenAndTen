package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Manager;
import com.service.ManagerService;
import com.service.impl.ManagerServiceImpl;

public class ManagerLoginAction extends ActionSupport {
	private Manager manager;
	private ManagerService mService;
	private String tip; // ��¼��ʾ
		
	public ManagerLoginAction() {
		mService = ManagerServiceImpl.getService();
	}
	
	public String execute() {
		// ��¼
		if (mService.login(manager)) {
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
