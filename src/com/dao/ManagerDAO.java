package com.dao;

import java.util.List;

import com.pojo.Manager;

public interface ManagerDAO {
	boolean insert(Manager manager);
	boolean update(Manager manager);
	boolean delete(Manager manager);
	
	Manager findById(int id);
	Manager findByName(String name);
	Manager findByNameAndPassword(String name, String password);
	List<Manager> findAll();
}
