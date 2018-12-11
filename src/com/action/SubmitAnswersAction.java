package com.action;

import java.util.List;
import java.util.ListIterator;

import org.apache.struts2.ServletActionContext;

import com.dao.GradeDAO;
import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;

public class SubmitAnswersAction extends ActionSupport {
	private List<String> questions;
	private List<String> userAnswers; // 用户提交的答案
	private List<String> rightAnswers; // 题库中的正确答案
	private int score; // 考试成绩
		
	private QuestionDAO questionDAO;
	private GradeDAO gradeDAO;
	
	public SubmitAnswersAction() {
		questionDAO = new QuestionDAO();
		gradeDAO = new GradeDAO();
		setScore(0);
	}
	
	public String execute() {
		// 获取题库中的正确答案
		setRightAnswers(questionDAO.getAllRightAnswers());
		
		ListIterator<String> userAnswersIter = userAnswers.listIterator();
		ListIterator<String> rightAnswersIter = rightAnswers.listIterator();
		
		// 计算考试成绩
		while (userAnswersIter.hasNext() && rightAnswersIter.hasNext()) {
			// 判断用户答案是否正确
			if (userAnswersIter.next().equals(rightAnswersIter.next())) {
				// 答案正确则加分
				setScore(getScore() + 10);
			}
		}
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		// 录入成绩
		if (gradeDAO.addGrade(user.getName(), getScore()) || gradeDAO.updateGrade(user.getName(), getScore())) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
			
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	public List<String> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(List<String> userAnswers) {
		this.userAnswers = userAnswers;
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
