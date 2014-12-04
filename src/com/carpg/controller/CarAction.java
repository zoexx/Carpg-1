package com.carpg.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.carpg.dao.CarDao;
import com.carpg.dao.User_CarDao;
import com.carpg.dto.Car;
import com.carpg.dto.User_Car;
import com.carpg.impl.CarImpl;
import com.carpg.impl.User_CarImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class CarAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware,ModelDriven<Car>{

	private static String ADD_CAR = "add_car";
	
	private HttpServletResponse response;  
	private HttpServletRequest request;  
	private Map<String, Object> session;
	
	private String msg;
	private String type;
	private Car car = new Car();
	private User_Car user_car = new User_Car();
	private CarDao carDao = new CarImpl();
	private User_CarDao user_carDao = new User_CarImpl();

	//action执行处理操作
	public String execute() throws Exception{
		//表示在抱怨页面添加新的用户车辆
		if (type.equals(ADD_CAR)){
			
			System.out.println("添加新的车辆"+car.getBrand()+"  "+car.getCar_type());
			//添加新的用户车辆
			
			//将页面反馈到用户抱怨选车页面
			//通过session中的用户信息取出用户车给到用户车列表
			String info = (String)request.getSession().getAttribute("sessioninfo");
			int userid = Integer.valueOf(info.split("~")[1]);
			List<User_Car> list = user_carDao.getUser_Car(userid);
			msg = "";
			//将取得的汽车信息拼接起来反馈给页面
			for(int i=0; i < list.size(); i++){
				msg += list.get(i).getId() +"," +list.get(i).getCar_brand()+"," +list.get(i).getCar_type();
				msg +="~";
			}
			return "step2";
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

	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	public Car getModel() {
		// TODO Auto-generated method stub
		return car;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
