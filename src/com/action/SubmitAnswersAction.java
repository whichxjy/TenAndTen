package com.action;

import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.pojo.User;
import com.service.GradeService;
import com.service.QuestionItemService;
import com.service.impl.GradeServiceImpl;
import com.service.impl.QuestionItemServiceImpl;

public class SubmitAnswersAction extends ActionSupport {
	private List<String> userAnswers; // 用户提交的答案
	private Integer score; // 考试成绩
		
	private QuestionItemService qService;
	private GradeService gService;
	
	public SubmitAnswersAction() {
		qService = QuestionItemServiceImpl.getService();
		gService = GradeServiceImpl.getService();
		setScore(0);
	}
	
	public String execute() {
		setScore(qService.getExamGrade(userAnswers));
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");	
		return (gService.updateGrade(user.getName(), score) || gService.addGrade(user.getName(), score)) ? SUCCESS : ERROR;
	}

	public List<String> getUserAnswers() {
		return userAnswers;
	}

	public void setUserAnswers(List<String> userAnswers) {
		this.userAnswers = userAnswers;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

}
