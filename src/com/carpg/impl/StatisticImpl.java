package com.carpg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.carpg.dao.StatisticDao;
import com.carpg.dto.Complaint;
import com.carpg.util.DBHelper;

public class StatisticImpl implements StatisticDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";

	public Map<String, Integer> getCountByYear_brand(String brand) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		conn = DBHelper.getConn();
		sql = "select start_time, count(*),user_car_id from complaint group by start_time" +
						"having user_car_id =(select user_car.id  from user_car,car where user_car.car_id = car.id && car.brand = ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, brand);
			rs = pstmt.executeQuery();
			//得到抱怨信息的统计列表
			while(rs.next()){
				map.put(rs.getString("start_time"), rs.getInt(2));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);
		return map;
	}

	public Map<String, Integer> getCountByYear(String year) {
		// TODO Auto-generated method stub
		Map<String, Integer> map = new HashMap<String, Integer>();
		conn = DBHelper.getConn();
		sql = "select car_brand, count(*) from complaint where start_time = ? group by car_brand order by count(*) DESC";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, year);
			rs = pstmt.executeQuery();
			while(rs.next()){
				map.put(rs.getString("car_brand"), rs.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);
		return map;
	}

}
