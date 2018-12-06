package com.pojo;

public class User {
	private String name;
	private String password;
	
	public User() {
		name = null;
		password = null;
	}
	
	public User(String userName, String userPassword) {
		name = userName;
		password = userPassword;
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
