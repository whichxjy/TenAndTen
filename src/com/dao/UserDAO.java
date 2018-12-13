package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.dao.ConnDB;
import com.pojo.User;

public class UserDAO {
	private static volatile UserDAO userDAO;
	
	private ConnDB connDB;
	
	private static SessionFactory factory; 
	
	private UserDAO() {
		connDB = ConnDB.getConnDB();
		userDAO = null;
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
		
		try{
			factory = new Configuration().configure().buildSessionFactory();
	    }catch (Throwable ex) { 
	    	System.err.println("Failed to create sessionFactory object." + ex);
	        throw new ExceptionInInitializerError(ex); 
	    }
	    Session session = factory.openSession();
	    Transaction tx = null;    
	    
	    try{
	         tx = session.beginTransaction();
	         User user = new User(userName, userPassword);
	         session.save(user); 
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }
	      return true;
//		// ��֤
//		
//		// ���벻��С��8λ
//		if (userPassword.length() < 8)
//			return false;
//		
//		// �ж��û�ID�Ƿ��Ѿ�����		
//		ResultSet sameNameUsers = connDB.executeQuery(
//			  "SELECT * "
//			+ "FROM users "
//			+ "WHERE user_name='" + userName + "'"
//		);
//		try {
//			if (sameNameUsers.next()) {
//				// ���û����Ѿ����ڣ������ʧ��
//				return false;
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		// ����û�
//		connDB.executeUpdate(
//			  "INSERT INTO users (user_name, user_password) "
//			+ "values('" + userName + "', '" + userPassword + "')"
//		);
//		
//		return true;
	}
	
	// �ж����ݿ����Ƿ����ƥ���û�����������û�
	// �����ƥ����û������¼�ɹ�
	public boolean userLogin(String userName, String userPassword) {
		ResultSet matchUsers = connDB.executeQuery(
			  "SELECT * "
			+ "FROM users "
			+ "WHERE user_name='" + userName + "' "
			+ "AND user_password='" + userPassword + "'"
		);
		try {
			if (matchUsers.next()) {
				// ��ƥ����û�
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
