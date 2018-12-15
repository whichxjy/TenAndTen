package com.service.impl;

import com.dao.UserDAO;
import com.dao.impl.UserDAOImpl;
import com.pojo.User;
import com.service.UserService;

public class UserServiceImpl implements UserService {
	private static volatile UserServiceImpl serviceImpl;
	private UserDAO dao;
	
	private UserServiceImpl() {
		dao = new UserDAOImpl();
	}
	
	public static UserServiceImpl getService(){
        if(serviceImpl == null){
            synchronized (UserServiceImpl.class){
                if(serviceImpl == null){
                	serviceImpl = new UserServiceImpl();
                }
            }
        }
        return serviceImpl;
    }

	@Override
	public boolean login(User user) {
		// �鿴���ݿ����Ƿ������������붼ƥ����û�
		User matchUser = dao.findByNameAndPassword(user.getName(), user.getPassword());
		return matchUser == null ? false : true;
	}

	@Override
	public boolean register(User user) {
		// �鿴���ݿ����Ƿ�����ͬ���û�
		User sameNameUser = dao.findByName(user.getName());
		// ���û��ͬ���û������ע��; ����ע��ʧ��
		return (sameNameUser == null && dao.insert(user));	
	}
	
}
