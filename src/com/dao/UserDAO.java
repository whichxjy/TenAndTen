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
		// 验证
		
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
	
	// 判断数据库中是否存在匹配用户名及密码的用户
	// 如果有匹配的用户，则登录成功
	public boolean userLogin(String userName, String userPassword) {
		ResultSet matchUsers = connDB.executeQuery(
			  "SELECT * "
			+ "FROM users "
			+ "WHERE user_name='" + userName + "' "
			+ "AND user_password='" + userPassword + "'"
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
