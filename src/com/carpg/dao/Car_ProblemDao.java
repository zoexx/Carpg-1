package com.carpg.dao;

import java.sql.SQLException;
import java.util.List;

import com.carpg.dto.Car_Problem;

public interface Car_ProblemDao {
	
	//得到问题的列表
	public List<Car_Problem> getCar_Problems();
	
	//添加新的问题类别
	public void addCar_Problem(Car_Problem carProblem);
	
	

}
