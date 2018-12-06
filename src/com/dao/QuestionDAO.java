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
	
	// �����Ŀ
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
		
	// ��ȡȫ������
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
	
	// ��ȡȫ����ȷ����
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
	
	// ��ȡĳ������Ĵ�
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
	
	// ������Ŀ
//	public boolean updateQuestion(int question_id, String new_question, String new_answer) {
//		
//	}
	
	
	// ɾ����Ŀ
//	public boolean deleteQuestion(int question_id) {
//		
//	}
//	
	
	
}
