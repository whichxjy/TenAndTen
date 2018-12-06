package com.pojo;

public class Manager {
	private String name;
	private String password;
	
	public Manager() {
		setName(null);
		setPassword(null);
	}
	
	public Manager(String userName, String userPassword) {
		setName(userName);
		setPassword(userPassword);
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
