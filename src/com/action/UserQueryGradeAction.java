package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.GradeService;
import com.service.impl.GradeServiceImpl;

public class UserQueryGradeAction extends ActionSupport {
	private int score;
	private GradeService gService;
	
	public UserQueryGradeAction() {
		gService = GradeServiceImpl.getService();
	}

	public String execute() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");	
		setScore(gService.queryGrade(user));
		return score == -1 ? ERROR : SUCCESS;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
