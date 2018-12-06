package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDAO {
	private ConnDB connDB;
	
	public ManagerDAO() {
		connDB = new ConnDB();
	}
	
	// 判断数据库中是否存在匹配管理员及密码的用户
	// 如果有匹配的管理员，则登录成功
	public boolean managerLogin(String managerName, String managerPassword) {
		ResultSet matchUsers = connDB.executeQuery(
			  "SELECT * "
			+ "FROM managers "
			+ "WHERE manager_name='" + managerName + "' "
			+ "AND manager_password='" + managerPassword + "'"
		);
		try {
			if (matchUsers.next()) {
				// 有匹配的用户
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
