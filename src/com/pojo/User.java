package com.pojo;

public class User {
	private int id;
	private String name;
	private String password;
	private String profilePicPath;
	
	public User() {
		setName(null);
		setPassword(null);
		setProfilePicPath(null);
	}
	
	public User(int id, String userName, String userPassword) {
		setId(id);
		setName(userName);
		setPassword(userPassword);
	}
	
	public User(String userName, String userPassword, String profilePicPath) {
		setName(userName);
		setPassword(userPassword);
		setProfilePicPath(profilePicPath);
	}
	
	public User(int id, String userName, String userPassword, String profilePicPath) {
		this(userName, userPassword, profilePicPath);
		setId(id);
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
