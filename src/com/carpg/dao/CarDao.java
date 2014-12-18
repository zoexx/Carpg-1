package com.carpg.dao;

import java.util.List;

import com.carpg.dto.Car;

public interface CarDao {
	
	//取得所有车型的信息
	public List<Car> getCars();
	
	//判断当前车型是否存在,存在则返回该车型的id, 否则返回-1
	public int isExist(Car car);
	
	//添加车型,返回车的id
	public int addCar(Car car);

}
