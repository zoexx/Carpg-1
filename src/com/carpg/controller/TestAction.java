package com.carpg.controller;

import com.carpg.dao.UserDao;
import com.carpg.dto.User;
import com.carpg.impl.UserImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class TestAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private UserDao userDao = new UserImpl();
	String msg;
	public TestAction() {
		// TODO Auto-generated constructor stub
	}
	
	public String execute() throws Exception{
		msg = "≤‚ ‘struts2µƒ∑µªÿ÷µ";
		return "test";
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
