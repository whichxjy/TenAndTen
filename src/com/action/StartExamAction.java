package com.action;

import java.util.List;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class StartExamAction extends ActionSupport {
	private List<String> questions; // Ҫ��ʾ������	
	private QuestionDAO questionDAO;
	
	public StartExamAction() {
		questionDAO = new QuestionDAO();
	}
	
	public String execute() {
		try {						
			// ������ʾ������
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
