package com.pojo;

public class QuestionItem {
	private int id;
	private String question;
	private String rightAnswer;
	
	public QuestionItem() {
		setQuestion(null);
		setRightAnswer(null);
	}
	
	public QuestionItem(String question, String rightAnswer) {
		setQuestion(question);
		setRightAnswer(rightAnswer);
	}
	
	public QuestionItem(int id, String question, String rightAnswer) {
		this.id = id;
		this.question = question;
		this.rightAnswer = rightAnswer;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
