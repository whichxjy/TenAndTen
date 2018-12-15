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
			// 实例化配置文件，然后创建 SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    } catch (Throwable e) { 
	    	System.err.println("Failed to create sessionFactory object." + e);
	        throw new ExceptionInInitializerError(e); 
	    }
	}
	
	@Override
	public boolean insert(Manager manager) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 保存管理员
	        session.save(manager);
	        
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
	public boolean update(Manager manager) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 更改管理员信息
	        session.update(manager);
	        
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
	public boolean delete(Manager manager) {
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	// 删除管理员
	        session.delete(manager);
	        
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
	public Manager findById(int id) {
		// 创建 Session
		Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// 查询数据库中 ID 相同的管理员
	    	query.select(root).where(builder.equal(root.get("id"), id));
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> sameIdManager = q.getResultList();
	        
	        // 提交事务
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
    	// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// 查询数据库中名字相同的管理员
	    	query.select(root).where(builder.equal(root.get("name"), name));
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> sameNameManager = q.getResultList();
	        
	        // 提交事务
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
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// 查询数据库中名字和密码都相同的管理员
	    	query.select(root).where(builder.and(
	    		builder.equal(root.get("name"), name), 
	    		builder.equal(root.get("password"), password)
	    	)); 
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> matchManager = q.getResultList();
	        
	        // 提交事务
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
		// 创建 Session
	    Session session = factory.openSession();
	    Transaction transaction = null;
	
	    try {
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<Manager> query = builder.createQuery(Manager.class);
	    	Root<Manager> root = query.from(Manager.class);
	    	
	    	// 查询数据库中全部管理员
	    	query.select(root);
	    	Query<Manager> q = session.createQuery(query);
	    	List<Manager> allManagers = q.getResultList();
	        
	        // 提交事务
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
