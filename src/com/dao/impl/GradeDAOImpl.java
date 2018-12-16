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
import org.hibernate.query.Query;

import com.dao.GradeDAO;
import com.pojo.Grade;

public class GradeDAOImpl implements GradeDAO {
	private static SessionFactory factory; 
	
	public GradeDAOImpl() {
		try{
			// 实例化配置文件，然后创建 SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	    	System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
	    }
	}

	@Override
	public boolean insert(Grade grade) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 保存成绩
	        session.save(grade);
	        
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
	public boolean update(Grade grade) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 更改成绩
	        session.update(grade);
	        
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
	public boolean delete(Grade grade) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 删除成绩
	        session.delete(grade);
	        
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
	public Grade findById(int id) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
	    	Root<Grade> root = query.from(Grade.class);
	    	
	    	// 查询数据库中与 ID 匹配的成绩
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	Query<Grade> q = session.createQuery(query);
	    	List<Grade> sameIdGrade = q.getResultList();
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return sameIdGrade.isEmpty() ? null : sameIdGrade.get(0);
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
	public Grade findByUserName(String userName) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
	    	Root<Grade> root = query.from(Grade.class);
	    	
	    	// 查询数据库中与用户名匹配的成绩
	    	query.select(root).where(builder.equal(root.get("userName"), userName));
	    	Query<Grade> q = session.createQuery(query);
	    	List<Grade> sameUserNameGrade = q.getResultList();
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return sameUserNameGrade.isEmpty() ? null : sameUserNameGrade.get(0);
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
	public List<Grade> findAll() {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
	    	Root<Grade> root = query.from(Grade.class);
	    	
	    	// 查询数据库中全部成绩
	    	query.select(root);
	    	Query<Grade> q = session.createQuery(query);
	    	List<Grade> allUsers = q.getResultList();
	        
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
	         return new ArrayList<Grade>();
	    }
	}
}
