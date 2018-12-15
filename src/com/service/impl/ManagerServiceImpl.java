package com.service.impl;

import com.dao.ManagerDAO;
import com.dao.impl.ManagerDAOImpl;
import com.pojo.Manager;
import com.service.ManagerService;

public class ManagerServiceImpl implements ManagerService {
	private static volatile ManagerServiceImpl managerServiceImpl;
	private ManagerDAO managerDAO;
	
	private ManagerServiceImpl() {
		managerDAO = new ManagerDAOImpl();
	}
	
	public static ManagerServiceImpl getManagerServiceImpl(){
        if(managerServiceImpl == null){
            synchronized (ManagerServiceImpl.class){
                if(managerServiceImpl == null){
                	managerServiceImpl = new ManagerServiceImpl();
                }
            }
        }
        return managerServiceImpl;
    }
	
	@Override
	public boolean login(Manager manager) {
		// �鿴���ݿ����Ƿ������������붼ƥ����û�
		Manager matchManager = managerDAO.findByNameAndPassword(manager.getName(), manager.getPassword());
		return matchManager == null ? false : true;
	}

}
