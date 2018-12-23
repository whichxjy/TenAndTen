package com.service;

import java.util.List;

import com.pojo.Grade;

public interface GradeService {
	// 添加成绩
	public boolean addGrade(String userName, Integer score);
	
	// 更新成绩
	public boolean updateGrade(String userName, Integer score);
	
	// 查询成绩
	public Integer queryGrade(String userName);
	
	// 获取所有成绩
	public List<Grade> getAllGrades();
	
}
