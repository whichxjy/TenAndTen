package com.action;

import java.util.List;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.QuestionItem;

public class GetQuestionListAction extends ActionSupport {
	private List<QuestionItem> questionItems;
	private int totalNumberOfQuestions;
	private QuestionDAO questionDAO;
	
	public GetQuestionListAction() {
		questionDAO = QuestionDAO.getQuestionDAO();
	}
	
	public String execute() {
		setQuestionItems(questionDAO.getAllQuestionItems());
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
