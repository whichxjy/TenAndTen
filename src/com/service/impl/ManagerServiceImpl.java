package com.service.impl;

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
		// �鿴���ݿ����Ƿ������������붼ƥ����û�
		Manager matchManager = dao.findByNameAndPassword(manager.getName(), manager.getPassword());
		return matchManager == null ? false : true;
	}

}
