package com.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.UserDAO;
import com.pojo.User;

public class UserDAOImpl implements UserDAO {
	private static SessionFactory factory; 
	
	public UserDAOImpl() {
		try{
			// 实例化配置文件，然后创建 SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	    	System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
	    }
	}
	
	@Override
	public boolean insert(User user) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 保存用户
	        session.save(user);
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return true;
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return false;
	    }
	}

	@Override
	public boolean update(User user) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 更改用户信息
	        session.update(user);
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return true;
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return false;
	    }
	}

	@Override
	public boolean delete(User user) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 删除用户
	        session.delete(user);
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return true;
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return false;
	    }
	}

	@Override
	public User findById(int id) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// 查询数据库中 ID 相同的用户
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	List<User> resultList = session.createQuery(query).getResultList();
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return resultList.isEmpty() ? null : resultList.get(0);
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return null;
	    }
	}

	@Override
	public User findByName(String name) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// 查询数据库中名字相同的用户
	    	query.select(root).where(builder.equal(root.get("name"), name));
	    	List<User> resultList = session.createQuery(query).getResultList();
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return resultList.isEmpty() ? null : resultList.get(0);
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return null;
	    }
	}

	@Override
	public User findByNameAndPassword(String name, String password) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// 查询数据库中名字和密码都相同的用户
	    	query.select(root).where(builder.and(
	    		builder.equal(root.get("name"), name), 
	    		builder.equal(root.get("password"), password)
	    	)); 
	    	List<User> resultList = session.createQuery(query).getResultList();
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return resultList.isEmpty() ? null : resultList.get(0);
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return null;
	    }
	}
	
	@Override
	public List<User> findAll() {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// 查询数据库中全部用户
	    	query.select(root);
	    	List<User> allUsers = session.createQuery(query).getResultList();
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return allUsers;
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return new ArrayList<User>();
	    }
	}
	
}