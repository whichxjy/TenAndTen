package com.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.QuestionItem;
import com.service.QuestionItemService;
import com.service.impl.QuestionItemServiceImpl;

public class DeleteQuestionAction extends ActionSupport {
	private QuestionItem questionItem;
	private QuestionItemService qService;
	
	public DeleteQuestionAction() {
		qService = QuestionItemServiceImpl.getService();
	}
	
	public String execute() {
		int questionId = Integer.parseInt(ServletActionContext.getRequest().getParameter("Flag"));		
		return qService.deleteQuestionItem(questionId) ? SUCCESS : ERROR;
	}

	public QuestionItem getQuestionItem() {
		return questionItem;
	}

	public void setQuestionItem(QuestionItem questionItem) {
		this.questionItem = questionItem;
	}
}
