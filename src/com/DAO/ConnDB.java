// ���ݿ�������

package com.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.*;

public class ConnDB {
	private Connection conn;
	private Statement stmt;
	
	private String driver; // ���ݿ�����
	private String url; // ���� URL
	private String user; // ���ݿ��û���
	private String password; // ���ݿ�����
	
	public ConnDB() {
		try {
			// ���������ļ�
			Properties props = new Properties();
			String propsFilePath = "F:/db_mysql.properties";
			props.load(new FileInputStream(propsFilePath));
			
			// ��������
			driver = props.getProperty("driver");
			url = props.getProperty("url");
			user = props.getProperty("user");
			password = props.getProperty("password");
			
			System.out.println(driver);
			
		} catch (IOException e) {
			e.printStackTrace();
		}  
	}
	
	// ��ȡ���ݿ�����
	private void getConnection() {
		conn = null;
		try {
			// ��������
			System.out.println(driver);
			Class.forName(driver);
			
			// ��ȡ���ݿ�����
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// ִ�� DML ���
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
	
	// ִ�� select ��䣬���ز�ѯ���Ľ����
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
	
	// �ر����ݿ�����
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
