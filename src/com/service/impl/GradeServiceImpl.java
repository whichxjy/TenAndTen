package com.service.impl;

import java.util.List;

import com.dao.GradeDAO;
import com.dao.impl.GradeDAOImpl;
import com.pojo.Grade;
import com.service.GradeService;

public class GradeServiceImpl implements GradeService {
	private static volatile GradeServiceImpl serviceImpl;
	private GradeDAO dao;
	
	private GradeServiceImpl() {
		dao = new GradeDAOImpl();
	}
	
	public static GradeServiceImpl getService(){
        if(serviceImpl == null){
            synchronized (GradeServiceImpl.class){
                if(serviceImpl == null){
                	serviceImpl = new GradeServiceImpl();
                }
            }
        }
        return serviceImpl;
    }
	
	@Override
	public boolean addGrade(String userName, Integer score) {
		return dao.insert(new Grade(userName, score));
	}

	@Override
	public boolean updateGrade(String userName, Integer score) {
		Grade grade = dao.findByUserName(userName);
		if (grade == null)
			return false;
		
		grade.setScore(score);
		return dao.update(grade);
	}

	@Override
	public Integer queryGrade(String userName) {
		Grade grade = dao.findByUserName(userName);
		return grade == null ? null : grade.getScore();	
	}

	@Override
	public List<Grade> getAllGrades() {
		return dao.findAll();
	}

}
