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
		// 查看数据库中是否有姓名和密码都匹配的用户
		User matchUser = userDAO.findByNameAndPassword(user.getName(), user.getPassword());
		return matchUser == null ? false : true;
	}

	@Override
	public boolean register(User user) {
		// 查看数据库中是否已有同名用户
		User sameNameUser = userDAO.findByName(user.getName());
		// 如果没有同名用户，则可注册; 否则注册失败
		return (sameNameUser == null && userDAO.insert(user));	
	}
	
}
