package com.service.impl;

import org.apache.struts2.ServletActionContext;

import com.dao.ManagerDAO;
import com.dao.impl.ManagerDAOImpl;
import com.pojo.Manager;
import com.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private static volatile ManagerServiceImpl serviceImpl;
	private ManagerDAO dao;
	
	private ManagerServiceImpl() {
		dao = new ManagerDAOImpl();
	}
	
	public static ManagerServiceImpl getService(){
        if(serviceImpl == null){
            synchronized (ManagerServiceImpl.class){
                if(serviceImpl == null){
                	serviceImpl = new ManagerServiceImpl();
                }
            }
        }
        return serviceImpl;
    }
	
	@Override
	public boolean login(Manager manager) {
		if (!check(manager))
			return false;
		
		Manager matchManager = dao.findByNameAndPassword(manager.getName(), manager.getPassword());
		if (matchManager == null)
			return false;
		
		ServletActionContext.getRequest().getSession().setAttribute("manager", matchManager);
		return true;
	}
	
	public boolean check(Manager manager) {
		return (manager.getName().length() >= 4 && manager.getName().length() <= 20 
				&& manager.getPassword().length() >= 6 && manager.getPassword().length() <= 20);
	}

}
