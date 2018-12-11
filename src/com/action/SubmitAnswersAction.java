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
	private List<String> userAnswers; // �û��ύ�Ĵ�
	private List<String> rightAnswers; // ����е���ȷ��
	private int score; // ���Գɼ�
		
	private QuestionDAO questionDAO;
	private GradeDAO gradeDAO;
	
	public SubmitAnswersAction() {
		questionDAO = new QuestionDAO();
		gradeDAO = new GradeDAO();
		setScore(0);
	}
	
	public String execute() {
		// ��ȡ����е���ȷ��
		setRightAnswers(questionDAO.getAllRightAnswers());
		
		ListIterator<String> userAnswersIter = userAnswers.listIterator();
		ListIterator<String> rightAnswersIter = rightAnswers.listIterator();
		
		// ���㿼�Գɼ�
		while (userAnswersIter.hasNext() && rightAnswersIter.hasNext()) {
			// �ж��û����Ƿ���ȷ
			if (userAnswersIter.next().equals(rightAnswersIter.next())) {
				// ����ȷ��ӷ�
				setScore(getScore() + 10);
			}
		}
		
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("user");
		// ¼��ɼ�
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
