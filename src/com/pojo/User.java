package com.pojo;

public class User {
	private int id;
	private String name;
	private String password;
	private String profilePicPath;
	
	public User() {
		setName(null);
		setPassword(null);
		setProfilePicPath("haha");
	}
	
	public User(String userName, String userPassword) {
		setName(userName);
		setPassword(userPassword);
		setProfilePicPath("haha");
	}
	
	public User(int id, String userName, String userPassword) {
		this.id = id;
		name = userName;
		password = userPassword;
		setProfilePicPath("haha");
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

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

}
