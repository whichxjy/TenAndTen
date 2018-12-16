package com.service.impl;

import java.util.List;

import com.dao.GradeDAO;
import com.dao.impl.GradeDAOImpl;
import com.pojo.Grade;
import com.pojo.User;
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
	public boolean addGrade(User user, int score) {
		return dao.insert(new Grade(user.getName(), score));
	}

	@Override
	public boolean updateGrade(User user, int score) {
		Grade grade = dao.findByUserName(user.getName());
		if (grade == null)
			return false;
		
		grade.setScore(score);
		return dao.update(grade);
	}

	@Override
	public int queryGrade(User user) {
		Grade grade = dao.findByUserName(user.getName());
		return grade == null ? -1 : grade.getScore();	
	}

	@Override
	public List<Grade> getAllGrades() {
		return dao.findAll();
	}

}
