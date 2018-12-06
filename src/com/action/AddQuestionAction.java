package com.action;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class AddQuestionAction extends ActionSupport {
	private String question; // 需要添加的题目
	private String rightAnswer; // 题目对应的正确答案
	
	private QuestionDAO questionDAO;
	
	public AddQuestionAction() {
		questionDAO = new QuestionDAO();
	}
	
	public String execute() {
		if (questionDAO.addQuestion(getQuestion(), getRightAnswer())) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}


	
}
