package com.service;

import java.util.List;

import com.pojo.QuestionItem;

public interface QuestionItemService {
	// 添加问题项
	public boolean addQuestionItem(QuestionItem questionItem);
	
	// 删除问题项
	public boolean deleteQuestionItem(QuestionItem questionItem);
	
	// 删除问题项
	public boolean deleteQuestionItem(int questionId);
	
	// 获取所有问题项
	public List<QuestionItem> getAllQuestionItems();
	
	// 评分
	public int getExamGrade(List<String> userAnswers);
	
}
