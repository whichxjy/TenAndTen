package com.service;

import java.util.List;

import com.pojo.Grade;
import com.pojo.User;

public interface GradeService {
	// ��ӳɼ�
	public boolean addGrade(User user, int score);
	
	// ���³ɼ�
	public boolean updateGrade(User user, int score);
	
	// ��ѯ�ɼ�
	public int queryGrade(User user);
	
	// ��ȡ���гɼ�
	public List<Grade> getAllGrades();
	
}
