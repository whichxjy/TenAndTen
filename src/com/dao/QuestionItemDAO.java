package com.dao;

import java.util.List;

import com.pojo.QuestionItem;

public interface QuestionItemDAO {
	boolean insert(QuestionItem questionItem);
	boolean update(QuestionItem questionItem);
	boolean delete(QuestionItem questionItem);
	
	QuestionItem findById(int id);
	List<QuestionItem> findAll();
}
