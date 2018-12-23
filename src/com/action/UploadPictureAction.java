package com.action;

import java.io.File;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

public class UploadPictureAction extends ActionSupport {
	private String savePath;
	private File profilePic;
	private String profilePicContentType;
	private String allowTypes;
	private UserService uService;
	
	public UploadPictureAction() {
		uService = UserServiceImpl.getService();
	}
	
	public void validate() {
		for (String type : allowTypes.split(",")) {
			if (type.equals(profilePicContentType))
				return;
		}
		addFieldError("user_change_profile", "您上传的图片类型不正确");
	}
	
	@Override
	public String execute() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		uService.changeProfilePic(user, profilePic, profilePicContentType, savePath);
		return SUCCESS;
	}
		
	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public File getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(File profilePic) {
		this.profilePic = profilePic;
	}

	public String getProfilePicContentType() {
		return profilePicContentType;
	}

	public void setProfilePicContentType(String profilePicContentType) {
		this.profilePicContentType = profilePicContentType;
	}

	public String getAllowTypes() {
		return allowTypes;
	}

	public void setAllowTypes(String allowTypes) {
		this.allowTypes = allowTypes;
	}
	
}
