package com.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.QuestionItem;
import com.service.QuestionItemService;
import com.service.impl.QuestionItemServiceImpl;

public class GetQuestionListAction extends ActionSupport {
	private List<QuestionItem> questionItems;
	private int totalNumberOfQuestions;
	private QuestionItemService qService;
	
	public GetQuestionListAction() {
		qService = QuestionItemServiceImpl.getService();
	}
	
	public String execute() {
		setQuestionItems(qService.getAllQuestionItems());
		setTotalNumberOfQuestions(questionItems.size());
		return SUCCESS;
	}

	public List<QuestionItem> getQuestionItems() {
		return questionItems;
	}

	public void setQuestionItems(List<QuestionItem> questionItems) {
		this.questionItems = questionItems;
	}

	public int getTotalNumberOfQuestions() {
		return totalNumberOfQuestions;
	}

	public void setTotalNumberOfQuestions(int totalNumberOfQuestions) {
		this.totalNumberOfQuestions = totalNumberOfQuestions;
	}
	

}
