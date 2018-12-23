package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.GradeService;
import com.service.impl.GradeServiceImpl;

public class UserQueryGradeAction extends ActionSupport {
	private Integer score;
	private GradeService gService;
	
	public UserQueryGradeAction() {
		gService = GradeServiceImpl.getService();
	}

	public String execute() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");	
		setScore(gService.queryGrade(user.getName()));
		return score == null ? ERROR : SUCCESS;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
	
}
