package com.carpg.controller;

import com.carpg.dao.UserDao;
import com.carpg.dto.User;
import com.carpg.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User>{

	private final static String ERROR = "error";
	private final static String LOGIN = "login";
	private final static String REGIST = "regist";
	private final static String VERIFY = "verify";
	private final static String BACK_PSW = "back_psw";
	private final static String UPDATE_PSW = "update_psw";
	//传入的type类型表示进行的操作
	private String type;
	private User user = new User();
	private UserDao userDao = new UserImpl();
	private String message;
	
	public String execute() throws Exception{
		System.out.println(type+"  "+user.getUsername() + "  "+user.getPassword());
		String Newsid[] =(String []) ActionContext.getContext().getParameters().get("username");
		System.out.println(Newsid[0]);
		//表示是登陆操作
		if (type.equals(LOGIN)){
			/*
			if (userDao.checkLogin(user.getUsername(), user.getPassword())){
				//表示登陆成功，返回接下来要跳转和操作的页面
				return "loginSucess";
			}
			else{
				//返回失败的页面操作
			}
			*/
			type = "测试返回值";
			return LOGIN;
		}else if (type.equals(REGIST)){
			
		}else if (type.equals(VERIFY)){
			
		}else if (type.equals(BACK_PSW)){
			
		}else if (type.equals(UPDATE_PSW)){
			
		}
		return ERROR;
	}
	
	public String MyJson() throws Exception{
		message = "测试Ajax";
		return "login";
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
