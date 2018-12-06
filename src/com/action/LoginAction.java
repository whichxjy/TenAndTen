package com.action;

import com.dao.UserDAO;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;


public class LoginAction extends ActionSupport {
	private String userName;
	private String userPassword;
	
	private List<String> questions;
	private List<String> answers;
	
	// 登录提示
	private String tip;
	
	private UserDAO userDAO;
	
	
	public LoginAction() {
		userDAO = new UserDAO();
	}
	
	public String execute() {
		// 登录
		if (userDAO.userLogin(userName, userPassword)) {
			// 设置 HttpSession 实例
			ActionContext.getContext().getSession().put("user", getUserName());
			setTip("登录成功！");
			
//			String[] q = {"Q1", "Q2", "Q3", "Q4"};
			
			List<String> q = new ArrayList<String>();
			
			q.add("Question1");
			q.add("Question2");
			q.add("Question3");
			q.add("Question4");

			setQuestions(q);
			
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	public String examResult() {
		ListIterator<String> iter = answers.listIterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		return SUCCESS;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public List<String> getQuestions() {
		return questions;
	}

	public void setQuestions(List<String> questions) {
		this.questions = questions;
	}

	public List<String> getAnswers() {
		return answers;
	}

	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}


	
	
}
