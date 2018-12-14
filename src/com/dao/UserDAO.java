package com.dao;
2222
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

import com.pojo.User;

public class UserDAO {
	private static volatile UserDAO userDAO;
	
	private static SessionFactory factory; 
	
	private UserDAO() {
		try{
			// ʵ���������ļ���Ȼ�󴴽� SessionFactory
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	    	System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	}
	
	public static UserDAO getUserDAO(){
        if(userDAO == null){
            synchronized (UserDAO.class){
                if(userDAO == null){
                	userDAO = new UserDAO();
                }
            }
        }
        return userDAO;
    }    
	
	// ����û�
	public boolean addUser(String userName, String userPassword) {
		// ��֤
		if (!checkUser(userName, userPassword))
			return false;
		
		// ���� Session
	    Session session = factory.openSession();
	    
	    Transaction transaction = null;    
	    
	    boolean addUserSuccess;
	    
	    try{
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// ��ѯ���ݿ���������ͬ���û�
	    	query.select(root).where(builder.equal(root.get("name"), userName));
	    	Query<User> q = session.createQuery(query);
	    	List<User> sameNameUsers = q.getResultList();
	    	
	    	// ���û����ظ��������ʧ��
	    	if (!sameNameUsers.isEmpty()) {
	    		addUserSuccess = false;
	    	}
	    	else {
		    	// �����û�
		    	User user = new User(userName, userPassword);
		    	// �����û�
		        session.save(user);
		        
		        addUserSuccess = true;
	    	}
	    	// �ύ����
	    	transaction.commit();

	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         addUserSuccess = false;
	    } finally {
	    	session.close();
	    }
    	return addUserSuccess ? true : false;
	}
	
	// ��֤�û���������
	private boolean checkUser(String userName, String userPassword) {
		if (userName.length() < 6 || userPassword.length() < 8) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// �ж����ݿ����Ƿ����ƥ���û�����������û�
	// �����ƥ����û������¼�ɹ�
	public boolean userLogin(String userName, String userPassword) {
	    Session session = factory.openSession();
	    Transaction transaction = null;    
	    
	    boolean userLoginSuccess;
	    try{
	    	// ��ʼ����
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// ��ѯ���ݿ������ֺ����붼��ͬ���û�
	    	query.select(root).where(builder.and(
	    		builder.equal(root.get("name"), userName), 
	    		builder.equal(root.get("password"), userPassword)
	    	)); 	
	    	Query<User> q = session.createQuery(query);
	    	List<User> matchUsers = q.getResultList();
	    	
	    	// �����ƥ����û������¼�ɹ�
	    	if (!matchUsers.isEmpty()) {
	    		userLoginSuccess = true;
	    	}
	    	else {
	    		userLoginSuccess = false;
	    	}

	        // �ύ����
	        transaction.commit();
	    } catch (HibernateException e) {
	         if (transaction != null) {
	        	 transaction.rollback();
	         }
	         e.printStackTrace();
	         userLoginSuccess = false;
	    } finally {
	    	session.close(); 
	    }
	    return userLoginSuccess ? true : false;
	}
	
}
