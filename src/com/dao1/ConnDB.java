// 数据库连接类

package com.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;

public class ConnDB {
	private Connection conn;
	private Statement stmt;
	
	private String driver; // 数据库驱动
	private String url; // 连接 URL
	private String user; // 数据库用户名
	private String password; // 数据库密码
	
	public ConnDB() {
		try {
			// 加载属性文件
			Properties props = new Properties();
			String propsFilePath = "F:/db_mysql.properties";
			props.load(new FileInputStream(propsFilePath));
			
			// 加载属性
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
			System.out.println(driver);
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	// 获取数据库连接
	private void getConnection() {
		conn = null;
		try {
			// 加载驱动
			System.out.println(driver);
			Class.forName(driver);
			
			// 获取数据库连接
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 执行 DML 语句
	public int executeUpdate(String sql) {
		try {
			getConnection();
			stmt = conn.createStatement();
			return stmt.executeUpdate(sql);
		}  catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	// 执行 select 语句，返回查询到的结果集
	public ResultSet executeQuery(String sql) {
		ResultSet result = null;
		try {
			getConnection();
			stmt = conn.createStatement();
			result = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	// 关闭数据库连接
	public void close() {
		try {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
