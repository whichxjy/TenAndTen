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
			// ʵ���������ļ���Ȼ�󴴽� SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	    	System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
	    }
	}

	@Override
	public boolean insert(Grade grade) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ����ɼ�
	        session.save(grade);
	        
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
	public boolean update(Grade grade) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ���ĳɼ�
	        session.update(grade);
	        
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
	public boolean delete(Grade grade) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ɾ���ɼ�
	        session.delete(grade);
	        
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
	public Grade findById(int id) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
	    	Root<Grade> root = query.from(Grade.class);
	    	
	    	// ��ѯ���ݿ����� ID ƥ��ĳɼ�
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	Query<Grade> q = session.createQuery(query);
	    	List<Grade> sameIdGrade = q.getResultList();
	        
	        // �ύ����
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
	    	Root<Grade> root = query.from(Grade.class);
	    	
	    	// ��ѯ���ݿ������û���ƥ��ĳɼ�
	    	query.select(root).where(builder.equal(root.get("userName"), userName));
	    	Query<Grade> q = session.createQuery(query);
	    	List<Grade> sameUserNameGrade = q.getResultList();
	        
	        // �ύ����
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Grade> query = builder.createQuery(Grade.class);
	    	Root<Grade> root = query.from(Grade.class);
	    	
	    	// ��ѯ���ݿ���ȫ���ɼ�
	    	query.select(root);
	    	Query<Grade> q = session.createQuery(query);
	    	List<Grade> allUsers = q.getResultList();
	        
	        // �ύ����
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
