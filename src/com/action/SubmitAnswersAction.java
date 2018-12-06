package com.action;

import java.util.List;
import java.util.ListIterator;

import com.dao.QuestionDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SubmitAnswersAction extends ActionSupport {
	private List<String> questions;
	private List<String> answers; // �û��ύ�Ĵ�
	private List<String> rightAnswers; // ����е���ȷ��
	private int score; // ���Գɼ�
		
	private QuestionDAO questionDAO;
	
	public SubmitAnswersAction() {
		questionDAO = new QuestionDAO();
		setScore(0);
	}
	
	public String execute() {
		// ��ȡ����е���ȷ��
		setRightAnswers(questionDAO.getAllRightAnswers());
		
		ListIterator<String> answersIter = answers.listIterator();
		ListIterator<String> rightAnswersIter = rightAnswers.listIterator();
		
		// ���㿼�Գɼ�
		while (answersIter.hasNext() && rightAnswersIter.hasNext()) {
			// �ж��û����Ƿ���ȷ
			if (answersIter.next().equals(rightAnswersIter.next())) {
				// ����ȷ��ӷ�
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
