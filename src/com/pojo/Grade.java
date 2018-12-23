package com.pojo;

public class Grade {
	private int id;
	private String userName;
	private Integer score;
	
	public Grade() {
		setUserName(null);
	}
	
	public Grade(String userName, int score) {
		setUserName(userName);
		setScore(score);
	}
	
	public Grade(int id, String userName, int score) {
		setId(id);
		setUserName(userName);
		setScore(score);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
}
