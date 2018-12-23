package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ManagerQuitAction extends ActionSupport {

	public String execute() {
		ServletActionContext.getRequest().getSession().setAttribute("manager", null);
		return SUCCESS;
	}
}
