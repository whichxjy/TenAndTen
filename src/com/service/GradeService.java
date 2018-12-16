package com.service;

import java.util.List;

import com.pojo.Grade;
import com.pojo.User;

public interface GradeService {
	// 添加成绩
	public boolean addGrade(User user, int score);
	
	// 更新成绩
	public boolean updateGrade(User user, int score);
	
	// 查询成绩
	public int queryGrade(User user);
	
	// 获取所有成绩
	public List<Grade> getAllGrades();
	
}
