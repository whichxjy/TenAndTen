package com.action;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.QuestionItem;

public class AddQuestionAction extends ActionSupport {
	private QuestionItem questionItem;
	
	private QuestionDAO questionDAO;
	
	public AddQuestionAction() {
		questionDAO = new QuestionDAO();
	}
	
	public String execute() {
		if (questionDAO.addQuestion(questionItem.getQuestion(), questionItem.getRightAnswer())) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}

	public QuestionItem getQuestionItem() {
		return questionItem;
	}

	public void setQuestionItem(QuestionItem questionItem) {
		this.questionItem = questionItem;
	}
	
}
