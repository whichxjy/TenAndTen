package com.action;

import java.util.List;
import java.util.ListIterator;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitAnswersAction extends ActionSupport {
	private List<String> questions;
	private List<String> answers; // 用户提交的答案
	private List<String> rightAnswers; // 题库中的正确答案
	private int score; // 考试成绩
		
	private QuestionDAO questionDAO;
	
	public SubmitAnswersAction() {
		questionDAO = new QuestionDAO();
		setScore(0);
	}
	
	public String execute() {
		// 获取题库中的正确答案
		setRightAnswers(questionDAO.getAllRightAnswers());
		
		ListIterator<String> answersIter = answers.listIterator();
		ListIterator<String> rightAnswersIter = rightAnswers.listIterator();
		
		// 计算考试成绩
		while (answersIter.hasNext() && rightAnswersIter.hasNext()) {
			// 判断用户答案是否正确
			if (answersIter.next().equals(rightAnswersIter.next())) {
				// 答案正确则加分
				setScore(getScore() + 10);
			}
		}
		
		return SUCCESS;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}

	public List<String> getRightAnswers() {
		return rightAnswers;
	}

	public void setRightAnswers(List<String> rightAnswers) {
		this.rightAnswers = rightAnswers;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}


	
	

}
