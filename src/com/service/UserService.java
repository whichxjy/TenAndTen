package com.service;

import com.pojo.User;

public interface UserService {	
	// �û���¼
	public boolean login(User user);
	
	// �û�ע��
	public boolean register(User user);
	
	// �û��޸�����
	public boolean changePassword(User user, String oldPassword, String newPassword);
}
