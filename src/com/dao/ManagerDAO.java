package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {
	private ConnDB connDB;
	
	public ManagerDAO() {
		connDB = new ConnDB();
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
