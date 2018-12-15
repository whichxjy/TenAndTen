package com.pojo;

public class Manager {
	private int id;
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
	
	public Manager(int id, String userName, String userPassword) {
		setId(id);
		setName(userName);
		setPassword(userPassword);
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
