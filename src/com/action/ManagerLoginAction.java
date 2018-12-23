package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Manager;
import com.service.ManagerService;
import com.service.impl.ManagerServiceImpl;

public class ManagerLoginAction extends ActionSupport {
	private Manager manager;
	private ManagerService mService;
		
	public ManagerLoginAction() {
		mService = ManagerServiceImpl.getService();
	}
	
	public String execute() {
		return mService.login(manager) ? SUCCESS : ERROR;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
