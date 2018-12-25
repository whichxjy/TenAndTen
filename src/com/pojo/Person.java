package com.pojo;

public class Person {
	private int id;
	private String name;
	private String password;
	
	public Person() {
		setName(null);
		setPassword(null);
	}
	
	public Person(String name, String password) {
		setName(name);
		setPassword(password);
	}
	
	public Person(int id, String name, String password) {
		setId(id);
		setName(name);
		setPassword(password);
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
