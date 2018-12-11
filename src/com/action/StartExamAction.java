package com.action;

import java.util.List;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class StartExamAction extends ActionSupport {
	private List<String> questions; // 要显示的问题	
	private QuestionDAO questionDAO;
	
	public StartExamAction() {
		questionDAO = new QuestionDAO();
	}
	
	public String execute() {
		try {						
			// 设置显示的问题
			setQuestions(questionDAO.getAllQuestions());
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}
	
}
