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

import com.dao.UserDAO;
import com.pojo.User;

public class UserDAOImpl implements UserDAO {
	private static volatile UserDAOImpl userDAO;
	private static SessionFactory factory; 
	
	private UserDAOImpl() {
		try{
			// ʵ���������ļ���Ȼ�󴴽� SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	    	System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public static UserDAOImpl getUserDAOImpl(){
        if(userDAO == null){
            synchronized (UserDAOImpl.class){
                if(userDAO == null){
                	userDAO = new UserDAOImpl();
                }
            }
        }
        return userDAO;
    }
	
	@Override
	public boolean insert(User user) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// �����û�
	        session.save(user);
	        
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
	public boolean update(User user) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// �����û���Ϣ
	        session.update(user);
	        
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
	public boolean delete(User user) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	// ɾ���û�
	        session.delete(user);
	        
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
	public User findById(int id) {
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// ��ѯ���ݿ��� ID ��ͬ���û�
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	Query<User> q = session.createQuery(query);
	    	List<User> sameIdUser = q.getResultList();
	        
	        // �ύ����
	    	transaction.commit();
	    	
	    	session.close();
	    	return sameIdUser.isEmpty() ? null : sameIdUser.get(0);
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// ��ѯ���ݿ���������ͬ���û�
	    	query.select(root).where(builder.equal(root.get("name"), name));
	    	Query<User> q = session.createQuery(query);
	    	List<User> sameNameUser = q.getResultList();
	        
	        // �ύ����
	    	transaction.commit();
	    	
	    	session.close();
	    	return sameNameUser.isEmpty() ? null : sameNameUser.get(0);
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// ��ѯ���ݿ������ֺ����붼��ͬ���û�
	    	query.select(root).where(builder.and(
	    		builder.equal(root.get("name"), name), 
	    		builder.equal(root.get("password"), password)
	    	)); 
	    	Query<User> q = session.createQuery(query);
	    	List<User> matchUser = q.getResultList();
	        
	        // �ύ����
	    	transaction.commit();
	    	
	    	session.close();
	    	return matchUser.isEmpty() ? null : matchUser.get(0);
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
		// ���� Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// ��ѯ���ݿ���ȫ���û�
	    	query.select(root);
	    	Query<User> q = session.createQuery(query);
	    	List<User> allUsers = q.getResultList();
	        
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
	         return new ArrayList<User>();
	    }
	}
	
}