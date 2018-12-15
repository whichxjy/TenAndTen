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

import com.dao.ManagerDAO;
import com.pojo.Manager;

public class ManagerDAOImpl implements ManagerDAO {
	private static SessionFactory factory; 
	
	public ManagerDAOImpl() {
		try{
			// ʵ���������ļ���Ȼ�󴴽� SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	    	System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
	    }
	}
	
	@Override
	public boolean insert(Manager manager) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// �������Ա
	        session.save(manager);
	        
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
	public boolean update(Manager manager) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ���Ĺ���Ա��Ϣ
	        session.update(manager);
	        
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
	public boolean delete(Manager manager) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ɾ������Ա
	        session.delete(manager);
	        
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
	public Manager findById(int id) {
		// ���� Session
		Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// ��ѯ���ݿ��� ID ��ͬ�Ĺ���Ա
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> sameIdManager = q.getResultList();
	        
	        // �ύ����
	    	transaction.commit();
	    	
	    	session.close();
	    	return sameIdManager.isEmpty() ? null : sameIdManager.get(0);
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
	public Manager findByName(String name) {
    	// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// ��ѯ���ݿ���������ͬ�Ĺ���Ա
	    	query.select(root).where(builder.equal(root.get("name"), name));
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> sameNameManager = q.getResultList();
	        
	        // �ύ����
	    	transaction.commit();
	    	
	    	session.close();
	    	return sameNameManager.isEmpty() ? null : sameNameManager.get(0);
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
	public Manager findByNameAndPassword(String name, String password) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// ��ѯ���ݿ������ֺ����붼��ͬ�Ĺ���Ա
	    	query.select(root).where(builder.and(
	    		builder.equal(root.get("name"), name), 
	    		builder.equal(root.get("password"), password)
	    	)); 
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> matchManager = q.getResultList();
	        
	        // �ύ����
	    	transaction.commit();
	    	
	    	session.close();
	    	return matchManager.isEmpty() ? null : matchManager.get(0);
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
	public List<Manager> findAll() {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// ��ѯ���ݿ���ȫ������Ա
	    	query.select(root);
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> allManagers = q.getResultList();
	        
	        // �ύ����
	    	transaction.commit();
	    	
	    	session.close();
	    	return allManagers;
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         session.close();
	         return new ArrayList<Manager>();
	    }
	}

}
