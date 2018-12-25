package com.pojo;

public class User extends Person{
	private String profilePicPath;
	
	public User() {
		super();
		setProfilePicPath(null);
	}
	
	public User(int id, String userName, String userPassword) {
		super(id, userName, userPassword);
	}
	
	public User(String userName, String userPassword, String profilePicPath) {
		super(userName, userPassword);
		setProfilePicPath(profilePicPath);
	}
	
	public User(int id, String userName, String userPassword, String profilePicPath) {
		this(userName, userPassword, profilePicPath);
		setId(id);
	}

	public String getProfilePicPath() {
		return profilePicPath;
	}

	public void setProfilePicPath(String profilePicPath) {
		this.profilePicPath = profilePicPath;
	}

}
