package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dao.GradeDAO;
import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.QuestionItemService;
import com.service.impl.QuestionItemServiceImpl;

public class SubmitAnswersAction extends ActionSupport {
	private List<String> userAnswers; // 用户提交的答案
	private int score; // 考试成绩
		
	private QuestionItemService qService;
	private GradeDAO gradeDAO;
	
	public SubmitAnswersAction() {
		qService = QuestionItemServiceImpl.getService();
		gradeDAO = GradeDAO.getGradeDAO();
		setScore(0);
	}
	
	public String execute() {
		setScore(qService.getExamGrade(userAnswers));
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		// 录入成绩
		if (gradeDAO.addGrade(user.getName(), getScore()) || gradeDAO.updateGrade(user.getName(), getScore())) {
			return SUCCESS;
		}
		else {
			return ERROR;
		}
			
	}

	public List<String> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(List<String> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
