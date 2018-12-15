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
		// 查看数据库中是否有姓名和密码都匹配的用户
		User matchUser = dao.findByNameAndPassword(user.getName(), user.getPassword());
		return matchUser == null ? false : true;
	}

	@Override
	public boolean register(User user) {
		// 查看数据库中是否已有同名用户
		User sameNameUser = dao.findByName(user.getName());
		// 如果没有同名用户，则可注册; 否则注册失败
		return (sameNameUser == null && dao.insert(user));	
	}
	
}
