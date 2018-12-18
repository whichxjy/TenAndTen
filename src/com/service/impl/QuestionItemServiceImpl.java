package com.service.impl;

import java.util.List;
import java.util.ListIterator;

import com.dao.QuestionItemDAO;
import com.dao.impl.QuestionItemDAOImpl;
import com.pojo.QuestionItem;
import com.service.QuestionItemService;

public class QuestionItemServiceImpl implements QuestionItemService{
	private static volatile QuestionItemServiceImpl serviceImpl;
	private QuestionItemDAO dao;
	
	private QuestionItemServiceImpl() {
		dao = new QuestionItemDAOImpl();
	}
	
	public static QuestionItemServiceImpl getService(){
        if(serviceImpl == null){
            synchronized (UserServiceImpl.class){
                if(serviceImpl == null){
                	serviceImpl = new QuestionItemServiceImpl();
                }
            }
        }
        return serviceImpl;
    }
		
	@Override
	public boolean addQuestionItem(QuestionItem questionItem) {
		return dao.insert(questionItem);
	}
	
	@Override
	public boolean deleteQuestionItem(QuestionItem questionItem) {
		return dao.delete(questionItem);
	}
	
	@Override
	public boolean deleteQuestionItem(int questionId) {
		return dao.delete(dao.findById(questionId));
	}

	@Override
	public List<QuestionItem> getAllQuestionItems() {
		return dao.findAll();
	}

	@Override
	public int getExamGrade(List<String> userAnswers) {
		// ����е�������
		ListIterator<QuestionItem> questionItemsIter = dao.findAll().listIterator();
		// �û��Ļش�
		ListIterator<String> userAnswersIter = userAnswers.listIterator();
		
		//����ɼ�
		int score = 0;
		while (questionItemsIter.hasNext() && userAnswersIter.hasNext()) {
			if (userAnswersIter.next().equals(questionItemsIter.next().getRightAnswer())) {
				score += 10;
			}
		}
		
		return score;
	}


}
