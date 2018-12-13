package com.action;

import java.util.List;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.QuestionItem;

public class GetQuestionListAction extends ActionSupport {
	private List<QuestionItem> questionItems;
	private QuestionDAO questionDAO;
	
	public GetQuestionListAction() {
		questionDAO = new QuestionDAO();
	}
	
	public String execute() {
		setQuestionItems(questionDAO.getAllQuestionItems());
		System.out.println(questionItems.get(0).getQuestion());
		return SUCCESS;
	}

	public List<QuestionItem> getQuestionItems() {
		return questionItems;
	}

	public void setQuestionItems(List<QuestionItem> questionItems) {
		this.questionItems = questionItems;
	}
	

}
