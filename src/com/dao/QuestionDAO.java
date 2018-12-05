package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionDAO {
	private ConnDB connDB;
	
	public QuestionDAO() {
		connDB = new ConnDB();
	}
	
	// 添加题目
	public boolean addQuestion(String question, String right_answer) {
		int updateNum = connDB.executeUpdate(
			"INSERT INTO questions (question, right_answer)"
			+ "values('" + question + "', '" + right_answer + "')"
		);
		if (updateNum > 0)
			return true;
		else
			return false;
	}
	
	// 删除题目
//	public boolean deleteQuestion(int question_id) {
//		
//	}
//	
	// 获取答案
	public String getAnswer(int question_id) {
		ResultSet result = connDB.executeQuery(
			  "SELECT right_answer "
			+ "FROM questions "
			+ "WHERE question_id=" + question_id
		);
		
		try {
			while (result.next()) {
				String answer = result.getString("right_answer");
				return answer;
			}
		} catch (SQLException e) {
			e.printStackTrace();		
		}
		return null;
	}
	
	// 更新题目
//	public boolean updateQuestion(int question_id, String new_question, String new_answer) {
//		
//	}
	
	
	
}
