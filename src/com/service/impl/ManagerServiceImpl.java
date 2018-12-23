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
		Manager matchManager = dao.findByNameAndPassword(manager.getName(), manager.getPassword());
		if (matchManager == null)
			return false;
		
		ServletActionContext.getRequest().getSession().setAttribute("manager", matchManager);
		return true;
	}

}
