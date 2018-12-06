package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		
	// 获取全部问题
	public List<String> getAllQuestions() {
		List<String> questions = new ArrayList<String>();
		
		ResultSet result = connDB.executeQuery(
			  "SELECT question "
			+ "FROM questions"
		);
		
		try {
			while (result.next()) {
				String question = result.getString("question");
				questions.add(question);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return questions;
	}
	
	// 获取全部正确问题
	public List<String> getAllRightAnswers() {
		List<String> right_answers = new ArrayList<String>();
		
		ResultSet result = connDB.executeQuery(
			  "SELECT right_answer "
			+ "FROM questions"
		);
		
		try {
			while (result.next()) {
				String right_answer = result.getString("right_answer");
				right_answers.add(right_answer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return right_answers;
	}
	
	// 获取某个问题的答案
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
	
	
	// 删除题目
//	public boolean deleteQuestion(int question_id) {
//		
//	}
//	
	
	
}
