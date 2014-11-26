package com.carpg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.carpg.dao.StatisticDao;

public class StatisticImpl implements StatisticDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";

	public List<Integer> getCountByYear_brand(String brand) {
		// TODO Auto-generated method stub
		List<Integer> list = new ArrayList<Integer>();
		sql = "select count(*) from complaint,user_car,car where complaint.user_car_id = user_car.id && user_car.id = car.id && car.brand = ?";
		return list;
	}

}
