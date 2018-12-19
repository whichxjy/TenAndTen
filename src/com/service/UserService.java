package com.service;

import com.pojo.User;

public interface UserService {	
	// 用户登录
	public boolean login(User user);
	
	// 用户注册
	public boolean register(User user);
	
	// 用户修改密码
	public boolean changePassword(User user, String oldPassword, String newPassword);
}
