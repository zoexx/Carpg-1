package com.carpg.controller;

import com.carpg.dao.UserDao;
import com.carpg.dto.User;
import com.carpg.impl.UserImpl;
import com.opensymphony.xwork2.ModelDriven;

public class TestAction implements ModelDriven<User> {

	private User user = new User();
	private UserDao userDao = new UserImpl();
	public TestAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String  login(){
		
		System.out.println(user.getUsername()+"  "+user.getPassword());
		if (userDao.checkLogin(user.getUsername(), user.getPassword())){
			return "login";
		}
		return null;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

}
