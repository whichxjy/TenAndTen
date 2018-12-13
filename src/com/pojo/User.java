package com.pojo;

public class User {
	private int id;
	private String name;
	private String password;
	
	public User() {
		setName(null);
		setPassword(null);
	}
	
	public User(String userName, String userPassword) {
		name = userName;
		password = userPassword;
	}
	
	public User(int id, String userName, String userPassword) {
		this.id = id;
		name = userName;
		password = userPassword;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}






	
}
