package com.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

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
	
//	private void setSessionUser(User user) {
//		ServletActionContext.getRequest().getSession().setAttribute("user", user);
//	}
	
//	@Override
//	public User getSessionUser() {
//		return (User) ServletActionContext.getRequest().getSession().getAttribute("user");
//	}

	@Override
	public boolean login(User user) {
		// 查看数据库中是否有姓名和密码都匹配的用户
		User matchUser = dao.findByNameAndPassword(user.getName(), user.getPassword());
		if (matchUser == null)
			return false;
		ServletActionContext.getRequest().getSession().setAttribute("user", matchUser);
		return true;
	}
	
	@Override
	public boolean register(User user, String profilePath) {
		if (!checkUser(user))
			return false;
		
		// 查看数据库中是否已有同名用户
		User sameNameUser = dao.findByName(user.getName());
		// 如果没有同名用户，则可注册; 否则注册失败
		if (sameNameUser != null)
			return false;
		
		user.setProfilePicPath(ServletActionContext.getServletContext().getRealPath("/WEB-INF/" + profilePath + "/default.png"));
		dao.insert(user);
		return true;
	}

	@Override
	public boolean changePassword(User user, String oldPassword, String newPassword) {
		if (!checkPassword(newPassword))
			return false;
		
		User matchUser = dao.findByNameAndPassword(user.getName(), oldPassword);
			
		if (matchUser != null) {
			matchUser.setPassword(newPassword);	
			user.setPassword(newPassword);
			return dao.update(matchUser);
		}
		else {
			return false;
		}
	}
	
	private boolean checkUser(User user) {
		return (user.getName().length() >= 4 && user.getName().length() <= 20 
				&& user.getPassword().length() >= 6 && user.getPassword().length() <= 20);
	}
	
	private boolean checkPassword(String password) {
		return (password.length() >= 62 && password.length() <= 20);
	}

	@Override
	public boolean changeProfilePic(User user, File profilePic, String fileType, String savePath) {
		String fileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + fileType.substring(fileType.lastIndexOf("/") + 1);
		String realSavePath = ServletActionContext.getServletContext().getRealPath("/WEB-INF/" + savePath);
		String profilePicPath = realSavePath + "\\" + fileName;
		
		try {
			FileUtils.copyFile(profilePic, new File(realSavePath, fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		user.setProfilePicPath(profilePicPath);
		dao.update(user);
		
		return false;
	}


	
}
