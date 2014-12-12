package com.carpg.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.carpg.dao.ComplaintDao;
import com.carpg.dao.User_CarDao;
import com.carpg.dto.Complaint;
import com.carpg.dto.User_Car;
import com.carpg.impl.ComplaintImpl;
import com.carpg.impl.User_CarImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ComplaintAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ModelDriven<Complaint>{

	private static String COMPLAINT = "complaint";
	private static String SELECT_CAR = "select_car";
	private static String FINISH = "finish";
	
	private HttpServletResponse response;  
	private HttpServletRequest request; 
	
	private Complaint complaint = new Complaint();
	private ComplaintDao comDao = new ComplaintImpl();
	private User_CarDao user_carDao = new User_CarImpl();
	//根据type类型表示处理的类型
	private String types;
	//消息处理的返回信息
	private String msg;


	public String execute() throws Exception{
		//表示是准备吐槽的的请求
		if (types.equals(COMPLAINT)){
			//根据session判断用户是否登陆
			String info = (String)request.getSession().getAttribute("user");
			//如果session为空则表示为登陆
			if (null == info){
				//重定向到登陆界面
				return "login";
			}else{
				//通过session中的用户信息取出用户车给到用户车列表
				int userid = Integer.valueOf(info.split("~")[1]);
				List<User_Car> list = user_carDao.getUser_Car(userid);
				msg = "";
				//将取得的汽车信息拼接起来反馈给页面
				for(int i=0; i < list.size()-1; i++){
					msg += list.get(i).getId() +"," +list.get(i).getCar_brand()+"," +list.get(i).getCar_type();
					msg +="~";
				}
				msg += list.get(list.size()-1).getId() +"," +list.get(list.size()-1).getCar_brand()+"," +list.get(list.size()-1).getCar_type();
				System.out.println("返回的信息:" +msg);
				//将车辆信息添加到session中
				request.getSession().setAttribute("user_carinfo", msg);
				//跳转到吐槽第二步
				return "step2";
			}
		}//表示是选择了吐槽车型
		else if (types.equals(SELECT_CAR)){
			//将选择的车型信息暂存在session中
			msg = request.getParameter("select_car");
			request.getSession().setAttribute("user_carinfo", msg);
			//页面跳转到第3步
			return "step3";
		}//表示是吐槽完成的页面
		else if (types.equals(FINISH)){
			
		}
		return "test";
		
	}
	
	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public Complaint getModel() {
		// TODO Auto-generated method stub
		return complaint;
	}

	public String getTypes() {
		return types;
	}


	public void setTypes(String types) {
		this.types = types;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
}
