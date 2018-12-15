package com.service.impl;

import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.pojo.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private static volatile UserServiceImpl userServiceImpl;
	private UserDAO userDAO;
	
	private UserServiceImpl() {
		userDAO = new UserDAOImpl();
	}
	
	public static UserServiceImpl getUserServiceImpl(){
        if(userServiceImpl == null){
            synchronized (UserServiceImpl.class){
                if(userServiceImpl == null){
                	userServiceImpl = new UserServiceImpl();
                }
            }
        }
        return userServiceImpl;
    }

	@Override
	public boolean login(User user) {
		// �鿴���ݿ����Ƿ������������붼ƥ����û�
		User matchUser = userDAO.findByNameAndPassword(user.getName(), user.getPassword());
		return matchUser == null ? false : true;
	}

	@Override
	public boolean register(User user) {
		// �鿴���ݿ����Ƿ�����ͬ���û�
		User sameNameUser = userDAO.findByName(user.getName());
		// ���û��ͬ���û������ע��; ����ע��ʧ��
		return (sameNameUser == null && userDAO.insert(user));	
	}
	
}
