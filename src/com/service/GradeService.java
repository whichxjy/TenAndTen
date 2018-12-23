package com.service;

import java.util.List;

import com.pojo.Grade;

public interface GradeService {
	// ��ӳɼ�
	public boolean addGrade(String userName, Integer score);
	
	// ���³ɼ�
	public boolean updateGrade(String userName, Integer score);
	
	// ��ѯ�ɼ�
	public Integer queryGrade(String userName);
	
	// ��ȡ���гɼ�
	public List<Grade> getAllGrades();
	
}
