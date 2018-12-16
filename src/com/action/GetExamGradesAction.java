package com.action;


import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.Grade;
import com.service.GradeService;
import com.service.impl.GradeServiceImpl;

public class GetExamGradesAction extends ActionSupport {
	private List<Grade> grades;
	private GradeService gService;
	 
	public GetExamGradesAction() {
		gService = GradeServiceImpl.getService();
	} 

	public String execute() {
		setGrades(gService.getAllGrades());
		return SUCCESS;
	}

	public List<Grade> getGrades() {
		return grades;
	}

	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}
