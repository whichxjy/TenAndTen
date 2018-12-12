package com.action;


import java.util.Map;

import com.dao.GradeDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GetExamResultTableAction extends ActionSupport {
	private Map<String, Integer> examResult; 
	private GradeDAO gradeDAO;
	 
	public GetExamResultTableAction() {
		gradeDAO = new GradeDAO();
	} 

	public String execute() {
		setExamResult(gradeDAO.getAllGrades());
		return SUCCESS;
	}

	public Map<String, Integer> getExamResult() {
		return examResult;
	}

	public void setExamResult(Map<String, Integer> examResult) {
		this.examResult = examResult;
	}
	

}
