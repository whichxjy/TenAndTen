package com.service;

import com.pojo.User;

public interface UserService {
	
	// �û���¼
	public User login(User user);
	
	// �û�ע��
	public User register(User user);
}
