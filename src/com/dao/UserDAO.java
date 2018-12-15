package com.dao;

import java.util.List;

import com.pojo.User;

public interface UserDAO {
	boolean insert(User user);
	boolean update(User user);
	boolean delete(User user);
	
	User findById(int id);
	User findByName(String name);
	User findByNameAndPassword(String name, String password);
	List<User> findAll();
}
