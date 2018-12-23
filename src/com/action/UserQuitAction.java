package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserQuitAction extends ActionSupport {
	
	public String execute() {
		ServletActionContext.getRequest().getSession().setAttribute("user", null);
		return SUCCESS;
	}
	
}
