package com.action;

import org.apache.struts2.ServletActionContext;

import com.dao.GradeDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class QueryGradeAction extends ActionSupport {
	private int grade;
	private GradeDAO gradeDAO;
	
	public QueryGradeAction() {
		gradeDAO = new GradeDAO();
	}

	public String execute() {
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");	
		setGrade(gradeDAO.getGradeByName(user.getName()));
		if (getGrade() != -1) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
}
