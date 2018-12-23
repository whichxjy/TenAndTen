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
			// ʵ���������ļ���Ȼ�󴴽� SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	    	System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
	    }
	}
		
	@Override
	public boolean insert(QuestionItem questionItem) {
		// ���� Session
	    Session session = factory.openSession();
    	// ��ʼ����
	    Transaction transaction = null;
	
	    try {
	    	transaction = session.beginTransaction();
	    	
	    	// ����������
	        session.save(questionItem);
	        
	        // �ύ����
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try { 
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ������������Ϣ
	        session.update(questionItem);
	        
	        // �ύ����
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ɾ��������
	        session.delete(questionItem);
	        
	        // �ύ����
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<QuestionItem> query = builder.createQuery(QuestionItem.class);
	    	Root<QuestionItem> root = query.from(QuestionItem.class);
	    	
	    	// ��ѯ���ݿ��� ID ��ͬ��������
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	List<QuestionItem> resultList = session.createQuery(query).getResultList();
	        
	        // �ύ����
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<QuestionItem> query = builder.createQuery(QuestionItem.class);
	    	Root<QuestionItem> root = query.from(QuestionItem.class);
	    	
	    	// ��ѯ���ݿ���ȫ���û�
	    	query.select(root);
	    	List<QuestionItem> allQuestionItems = session.createQuery(query).getResultList();
	        
	        // �ύ����
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
