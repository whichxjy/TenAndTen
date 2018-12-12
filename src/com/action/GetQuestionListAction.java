package com.action;

import java.util.Map;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class GetQuestionListAction extends ActionSupport {
	private Map<String, String> questionsAndAnswers;
	private QuestionDAO questionDAO;
	
	public GetQuestionListAction() {
		questionDAO = new QuestionDAO();
	}
	
	public String execute() {
		setQuestionsAndAnswers(questionDAO.getAllQuestionsAndAnswers());
		return SUCCESS;
	}
	
	public Map<String, String> getQuestionsAndAnswers() {
		return questionsAndAnswers;
	}

	public void setQuestionsAndAnswers(Map<String, String> questionsAndAnswers) {
		this.questionsAndAnswers = questionsAndAnswers;
	}
}
