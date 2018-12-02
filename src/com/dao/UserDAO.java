package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.ConnDB;

public class UserDAO {
	private ConnDB connDB;
	
	public UserDAO() {
		connDB = new ConnDB();
	}
	
	// ����û�
	public boolean addUser(String userName, String userPassword) {
		// ���벻��С��8λ
		if (userPassword.length() < 8)
			return false;
		
		// �ж��û�ID�Ƿ��Ѿ�����		
		ResultSet sameNameUsers = connDB.executeQuery(
			  "SELECT * "
			+ "FROM users "
			+ "WHERE user_name='" + userName + "'"
		);
		try {
			if (sameNameUsers.next()) {
				// ���û����Ѿ����ڣ������ʧ��
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// ����û�
		connDB.executeUpdate(
			  "INSERT INTO users (user_name, user_password) "
			+ "values('" + userName + "', '" + userPassword + "')"
		);
		
		return true;
	}
	
}
