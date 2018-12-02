package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.ConnDB;

public class UserDAO {
	private ConnDB connDB;
	
	public UserDAO() {
		connDB = new ConnDB();
	}
	
	// 添加用户
	public boolean addUser(String userName, String userPassword) {
		// 密码不能小于8位
		if (userPassword.length() < 8)
			return false;
		
		// 判断用户ID是否已经存在		
		ResultSet sameNameUsers = connDB.executeQuery(
			  "SELECT * "
			+ "FROM users "
			+ "WHERE user_name='" + userName + "'"
		);
		try {
			if (sameNameUsers.next()) {
				// 若用户名已经存在，则添加失败
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		// 添加用户
		connDB.executeUpdate(
			  "INSERT INTO users (user_name, user_password) "
			+ "values('" + userName + "', '" + userPassword + "')"
		);
		
		return true;
	}
	
}
