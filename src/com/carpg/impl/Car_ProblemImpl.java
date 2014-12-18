package com.carpg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpg.dao.Car_ProblemDao;
import com.carpg.dto.Car_Problem;
import com.carpg.util.DBHelper;

public class Car_ProblemImpl implements Car_ProblemDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";
	
	public Car_ProblemImpl(){
		
	}

	public void addCar_Problem(Car_Problem carProblem){
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		sql = "insert into car_problems value(null,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, carProblem.getType());
			pstmt.setString(2, carProblem.getProblem());
			pstmt.setString(3, carProblem.getDetail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();

	}

	public List<Car_Problem> getCar_Problems(){
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		List<Car_Problem> list = new ArrayList<Car_Problem>();
		sql = "select * from car_problems";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Car_Problem carProblem = new Car_Problem();
				carProblem.setId(rs.getInt("id"));
				carProblem.setType(rs.getString("type"));
				carProblem.setProblem(rs.getString("problem"));
				carProblem.setDetail(rs.getString("detail"));
				list.add(carProblem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();
		return list;
	}
	

	//关闭ResultSet和pstmt
	private void close(){
		if (null != rs){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (null != pstmt){
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//关闭数据库连接conn
		DBHelper.close();
	}
}
