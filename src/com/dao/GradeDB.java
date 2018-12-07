package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class GradeDB {
	private ConnDB connDB;
	
	public GradeDB() {
		connDB = new ConnDB();
	}
	
	// ��ӳɼ�
	public boolean addGrade(String userName, int score) {
		int updateNum = connDB.executeUpdate(
				  "INSERT INTO grades (user_name, score)"
				+ "values('" + userName + "', " + score + ")"
			);
			if (updateNum > 0)
				return true;
			else
				return false;
	}
	
	// ���³ɼ�
	public boolean updateGrade(String userName, int score) {
		int updateNum = connDB.executeUpdate(
				  "UPDATE grades "
				+ "SET score=" + score + " "
				+ "WHERE user_name='" + userName + "'"
			);
			if (updateNum > 0)
				return true;
			else
				return false;
	}
	
	// ��ȡȫ���ɼ�
	public Map<String, Integer> getAllGrades() {
		Map<String, Integer> grades = new HashMap<String, Integer>();
		ResultSet result = connDB.executeQuery(
			  "SELECT * "
			+ "FROM grades"
		);
		
		try {
			while (result.next()) {
				String userName = result.getString("user_name");
				int score = result.getInt("score");
				grades.put(userName, score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return grades;
	}
	
	// ��ȡĳ��ѧ���ĳɼ�
	public int getGradeByName(String userName) {
		ResultSet result = connDB.executeQuery(
			  "SELECT score "
			+ "FROM grades "
			+ "WHERE user_name='" + userName + "'"
		);
		
		try {
			if (result.next()) {
				return result.getInt("score");
			}
			else {
				return -1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	// ɾ���ɼ�
}
