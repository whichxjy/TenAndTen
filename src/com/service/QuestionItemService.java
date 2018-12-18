package com.service;

import java.util.List;

import com.pojo.QuestionItem;

public interface QuestionItemService {
	// ���������
	public boolean addQuestionItem(QuestionItem questionItem);
	
	// ɾ��������
	public boolean deleteQuestionItem(QuestionItem questionItem);
	
	// ɾ��������
	public boolean deleteQuestionItem(int questionId);
	
	// ��ȡ����������
	public List<QuestionItem> getAllQuestionItems();
	
	// ����
	public int getExamGrade(List<String> userAnswers);
	
}
