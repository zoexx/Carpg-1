package com.carpg.controller;

import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Session;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.carpg.dao.UserDao;
import com.carpg.dto.User;
import com.carpg.impl.UserImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware,ModelDriven<User>{

	private final static String ERROR = "error";
	private final static String LOGIN = "login";
	private final static String LOGIN_RE = "login_re";
	private final static String REGIST = "regist";
	private final static String VERIFY = "verify";
	private final static String BACK_PSW = "return_psw";
	private final static String UPDATE_PSW = "set_psw";
	
	 private HttpServletResponse response;  
	 private HttpServletRequest request;  
	 private Map<String, Object> session;
	 //根据type进行相应的操作
	private String type;
	private User user = new User();
	private UserDao userDao = new UserImpl();
	private String message;
	
	public String execute() throws Exception{
		//String Newsid[] =(String []) ActionContext.getContext().getParameters().get("username");
		//System.out.println(Newsid[0]);
		//用来存储用户表中的id，保存在session中
		String check = "";
		//表示登陆操作
		if (type.equals("loginC")){
			//Cookie cookie = new Cookie("carpg", user.getPassword()+"~"+user.getUsername());
			//response.addCookie(cookie);
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			//登陆成功
			check = userDao.checkLogin(user.getUsername(), user.getPassword());
			if (!check.equals("error")){
				System.out.println("登陆成功");
				//将用户信息保存在session中,用户信息为userid+user_name(别名)
				Calendar c = Calendar.getInstance();
				String info = c.getTimeInMillis()+"~"+check;
				request.getSession().setAttribute("user", info);	
				
				out.print("success");
			}
			else{
				System.out.println("登陆失败");
				out.print("fail");
			}
			//return LOGIN;
			//System.out.println("Session的值为："+session.get("vcode").toString());
		}else if (type.equals(LOGIN)){
					
			//跳转到登陆成功页面,并将用户信息反馈到该页面，保存sessioninfo
			return "test";
		}
		//注册详细信息页面跳转
		else if (type.equals(LOGIN_RE)){
			return "regist";
			
		}else if (type.equals(REGIST)){
			if (userDao.Regist(user)){
				return "test";
			}
			else{
				
			}
			
		}else if (type.equals(VERIFY)){
			System.out.println("测试action");
			
		}//找回密码邮箱验证
		else if (type.equals(BACK_PSW)){
			
		}//更新密码
		else if (type.equals(UPDATE_PSW)){
			
		}
		return null;
	}
	
	public String MyJson() throws Exception{
		message = "Ajax";
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

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
		
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}


}
