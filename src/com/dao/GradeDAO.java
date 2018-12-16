package com.dao;

import java.util.List;

import com.pojo.Grade;

public interface GradeDAO {
	boolean insert(Grade grade);
	boolean update(Grade grade);
	boolean delete(Grade grade);
	
	Grade findById(int id);
	Grade findByUserName(String userName);
	List<Grade> findAll();
}
