package com.carpg.controller;

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
	
	private String type;
	private Car car = new Car();
	private User_Car user_car = new User_Car();
	private CarDao carDao = new CarImpl();
	private User_CarDao user_carDao = new User_CarImpl();

	//action执行处理操作
	public String execute() throws Exception{
		if (type.equals(ADD_CAR)){
			
			System.out.println("添加新的车辆"+car.getBrand()+"  "+car.getCar_type());
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

}
