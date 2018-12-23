package com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.QuestionItem;
import com.service.QuestionItemService;
import com.service.impl.QuestionItemServiceImpl;

public class StartExamAction extends ActionSupport {
	private List<QuestionItem> questionItems;
	private QuestionItemService qService;
	
	public StartExamAction() {
		qService = QuestionItemServiceImpl.getService();
	}
	
	public String execute() {
		setQuestionItems(qService.getAllQuestionItems());
		return SUCCESS;
	}

	public List<QuestionItem> getQuestionItems() {
		return questionItems;
	}

	public void setQuestionItems(List<QuestionItem> questionItems) {
		this.questionItems = questionItems;
	}

}
