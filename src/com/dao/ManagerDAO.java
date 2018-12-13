package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {
	private static volatile ManagerDAO managerDAO;
	
	private ConnDB connDB;
	
	private ManagerDAO() {
		connDB = ConnDB.getConnDB();
		managerDAO = null;
	}
	
    public static ManagerDAO getManagerDAO(){
        if(managerDAO == null){
            synchronized (ManagerDAO.class){
                if(managerDAO == null){
                	managerDAO = new ManagerDAO();
                }
            }
        }
        return managerDAO;
    } 
	
	// �ж����ݿ����Ƿ����ƥ�����Ա��������û�
	// �����ƥ��Ĺ���Ա�����¼�ɹ�
	public boolean managerLogin(String managerName, String managerPassword) {
		ResultSet matchUsers = connDB.executeQuery(
			  "SELECT * "
			+ "FROM managers "
			+ "WHERE manager_name='" + managerName + "' "
			+ "AND manager_password='" + managerPassword + "'"
		);
		try {
			if (matchUsers.next()) {
				// ��ƥ����û�
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
