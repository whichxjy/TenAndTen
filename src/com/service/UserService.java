package com.service;

import java.io.File;

import com.pojo.User;

public interface UserService {	
	// 用户登录
	public boolean login(User user);
	
	// 用户注册
	public boolean register(User user, String profilePath);
	
	// 用户修改密码
	public boolean changePassword(User user, String oldPassword, String newPassword);
	
	// 用户修改头像
	public boolean changeProfilePic(User user, File profilePic, String fileType, String savePath);
	
}
