package com.carpg.dao;

import java.util.List;

import com.carpg.dto.Car;

public interface CarDao {
	
	//取得所有车型的信息
	public List<Car> getCars();
	
	//判断当前车型是否存在
	public boolean isExist(Car car);
	
	//添加车型
	public void addCar(Car car);

}
