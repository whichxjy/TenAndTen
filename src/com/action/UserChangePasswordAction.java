package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UserChangePasswordAction extends ActionSupport {
	private String oldPassword;
	private String newPassword;
	private String confirmPassword;
	private UserService uService;
	
	public UserChangePasswordAction() {
		uService = UserServiceImpl.getService();
	}

	public String execute() {
		if (!newPassword.equals(confirmPassword))
			return ERROR;

		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		return uService.changePassword(user, oldPassword, newPassword) ? SUCCESS : ERROR;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public UserService getuService() {
		return uService;
	}

	public void setuService(UserService uService) {
		this.uService = uService;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
