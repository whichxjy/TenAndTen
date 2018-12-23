package com.service;

import java.io.File;

import com.pojo.User;

public interface UserService {	
	// �û���¼
	public boolean login(User user);
	
	// �û�ע��
	public boolean register(User user, String profilePath);
	
	// �û��޸�����
	public boolean changePassword(User user, String oldPassword, String newPassword);
	
	// �û��޸�ͷ��
	public boolean changeProfilePic(User user, File profilePic, String fileType, String savePath);
	
}
