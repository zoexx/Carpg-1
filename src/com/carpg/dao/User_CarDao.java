package com.carpg.dao;

import java.util.List;

import com.carpg.dto.User_Car;

public interface User_CarDao {
	
	//添加用户车
	public void addUser_Car(User_Car userCar);
	
	//更新用户车,有些信息是不能被更改的
	//能更改的信息：color, buy_time, mileage, remark
	public void updateUser_Car(User_Car userCar);
	
	//得到用户车,通过用户名获取用户车辆信息
	public List<User_Car> getUser_Car(int userid);
	
	//删除用户车辆信息,通过用户车辆信息编号
	public void delUser_Car(int id);

}
