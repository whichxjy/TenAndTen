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
			// 实例化配置文件，然后创建 SessionFactory
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
	
	// 添加用户
	public boolean addUser(String userName, String userPassword) {
		// 验证
		if (!checkUser(userName, userPassword))
			return false;
		
		// 创建 Session
	    Session session = factory.openSession();
	    
	    Transaction transaction = null;    
	    
	    boolean addUserSuccess;
	    
	    try{
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// 查询数据库中名字相同的用户
	    	query.select(root).where(builder.equal(root.get("name"), userName));
	    	Query<User> q = session.createQuery(query);
	    	List<User> sameNameUsers = q.getResultList();
	    	
	    	// 若用户名重复，则添加失败
	    	if (!sameNameUsers.isEmpty()) {
	    		addUserSuccess = false;
	    	}
	    	else {
		    	// 创建用户
		    	User user = new User(userName, userPassword);
		    	// 保存用户
		        session.save(user);
		        
		        addUserSuccess = true;
	    	}
	    	// 提交事务
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
	
	// 验证用户名和密码
	private boolean checkUser(String userName, String userPassword) {
		if (userName.length() < 6 || userPassword.length() < 8) {
			return false;
		}
		else {
			return true;
		}
	}
	
	// 判断数据库中是否存在匹配用户名及密码的用户
	// 如果有匹配的用户，则登录成功
	public boolean userLogin(String userName, String userPassword) {
	    Session session = factory.openSession();
	    Transaction transaction = null;    
	    
	    boolean userLoginSuccess;
	    try{
	    	// 开始事务
	    	transaction = session.beginTransaction();
	    	
	    	CriteriaBuilder builder = session.getCriteriaBuilder();
	    	CriteriaQuery<User> query = builder.createQuery(User.class);
	    	Root<User> root = query.from(User.class);
	    	
	    	// 查询数据库中名字和密码都相同的用户
	    	query.select(root).where(builder.and(
	    		builder.equal(root.get("name"), userName), 
	    		builder.equal(root.get("password"), userPassword)
	    	)); 	
	    	Query<User> q = session.createQuery(query);
	    	List<User> matchUsers = q.getResultList();
	    	
	    	// 如果有匹配的用户，则登录成功
	    	if (!matchUsers.isEmpty()) {
	    		userLoginSuccess = true;
	    	}
	    	else {
	    		userLoginSuccess = false;
	    	}

	        // 提交事务
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
