package com.action;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.QuestionItem;
import com.service.QuestionItemService;
import com.service.impl.QuestionItemServiceImpl;

public class AddQuestionAction extends ActionSupport {
	private QuestionItem questionItem;
	private QuestionItemService qService;
	
	public AddQuestionAction() {
		qService = QuestionItemServiceImpl.getService();
	}
	
	public String execute() {
		return qService.addQuestionItem(questionItem) ? SUCCESS : ERROR;
	}

	public QuestionItem getQuestionItem() {
		return questionItem;
	}

	public void setQuestionItem(QuestionItem questionItem) {
		this.questionItem = questionItem;
	}
	
}
