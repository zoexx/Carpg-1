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

public class CarAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ModelDriven<Car>{
	
	private HttpServletResponse response;  
	private HttpServletRequest request;  
	
	private String msg;
	private Car car = new Car();
	private User_Car user_car = new User_Car();
	private CarDao carDao = new CarImpl();
	private User_CarDao user_carDao = new User_CarImpl();

	//表示在抱怨页面添加新的用户车辆
	public String addUserCar() throws Exception{
		System.out.println("添加新的车辆"+car.getBrand()+"  "+car.getCar_type());
		System.out.println("添加新的车辆"+user_car.getVin()+"  "+user_car.getColor());
		//向车辆库中添加新的车辆
		int carId = carDao.addCar(car);
		//通过session中的用户信息取出用户车给到用户车列表
		String info = (String)request.getSession().getAttribute("user");
		int userid = Integer.valueOf(info.split("~")[1]);
		String username = info.split("~")[2];
		
		//将表单中的信息封装到user_car类中
		user_car.setUser_id(userid);
		user_car.setUser_name(username);
		user_car.setCar_id(carId);
		user_car.setCar_brand(car.getBrand());
		user_car.setCar_type(car.getCar_type());
		user_car.setVin(request.getParameter("vin"));
		user_car.setColor(request.getParameter("color"));
		user_car.setBuy_time(request.getParameter("buy_time"));
		user_car.setMileage(Integer.valueOf(request.getParameter("mileage")));
		user_car.setRemark(request.getParameter("remark"));
		//向用户车库中添加新的用户车
		user_carDao.addUser_Car(user_car);
		
		//将页面反馈到用户抱怨选车页面	
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
		return "step2";
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
		
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public Car getModel() {
		// TODO Auto-generated method stub
		return car;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
