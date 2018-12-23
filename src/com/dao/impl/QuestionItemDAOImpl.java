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

import com.dao.QuestionItemDAO;
import com.pojo.QuestionItem;

public class QuestionItemDAOImpl implements QuestionItemDAO {
	private static SessionFactory factory;
	
	public QuestionItemDAOImpl() {
		try{
			// 实例化配置文件，然后创建 SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	    	System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
	    }
	}
		
	@Override
	public boolean insert(QuestionItem questionItem) {
		// 创建 Session
	    Session session = factory.openSession();
    	// 开始事务
	    Transaction transaction = null;
	
	    try {
	    	transaction = session.beginTransaction();
	    	
	    	// 保存问题项
	        session.save(questionItem);
	        
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
	public boolean update(QuestionItem questionItem) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try { 
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 更改问题项信息
	        session.update(questionItem);
	        
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
	public boolean delete(QuestionItem questionItem) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 删除问题项
	        session.delete(questionItem);
	        
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
	public QuestionItem findById(int id) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<QuestionItem> query = builder.createQuery(QuestionItem.class);
	    	Root<QuestionItem> root = query.from(QuestionItem.class);
	    	
	    	// 查询数据库中 ID 相同的问题项
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	List<QuestionItem> resultList = session.createQuery(query).getResultList();
	        
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
	public List<QuestionItem> findAll() {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<QuestionItem> query = builder.createQuery(QuestionItem.class);
	    	Root<QuestionItem> root = query.from(QuestionItem.class);
	    	
	    	// 查询数据库中全部用户
	    	query.select(root);
	    	List<QuestionItem> allQuestionItems = session.createQuery(query).getResultList();
	        
	        // 提交事务
	    	transaction.commit();
	    	
	    	session.close();
	    	return allQuestionItems;
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return new ArrayList<QuestionItem>();
	    }
	}
	

}
