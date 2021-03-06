package com.carpg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpg.dao.CarDao;
import com.carpg.dto.Car;
import com.carpg.util.DBHelper;

public class CarImpl implements CarDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";
	
	public CarImpl(){
		
	}

	public int addCar(Car car) {
		// TODO Auto-generated method stub
		int i = -1;
		PreparedStatement pstmt1=null;
		ResultSet rs1 = null;
		conn = DBHelper.getConn();
		sql = "insert into car value(null,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getBrand());
			pstmt.setString(2, car.getCar_type());
			pstmt.setFloat(3, car.getDisplacement());
			pstmt.setString(4, car.getSale_time());
			pstmt.setString(5, car.getCategory());
			pstmt.setString(6, car.getConfigure());
			pstmt.setString(7, car.getAlias());
			pstmt.setString(8, car.getTransmission());
			pstmt.setString(9, car.getStandard());
			pstmt.executeUpdate();
			sql = "select max(id) from car";
			pstmt1 = conn.prepareStatement(sql);
			rs1 = pstmt1.executeQuery();
			while (rs1.next()){
				i = rs1.getInt(1);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			rs1.close();
			pstmt1.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();
		return i;
	}

	public List<Car> getCars() {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		List<Car> cars = new ArrayList<Car>();
		sql = "select * from car";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Car car = new Car();
				car.setId(rs.getInt("id"));
				car.setBrand(rs.getString("brand"));
				car.setCar_type(rs.getString("car_type"));
				car.setDisplacement(rs.getFloat("displacement"));
				car.setSale_time(rs.getString("sale_time"));
				car.setCategory(rs.getString("category"));
				car.setConfigure(rs.getString("configure"));
				car.setAlias(rs.getString("alias"));
				car.setTransmission(rs.getString("transmission"));
				car.setStandard(rs.getString("standard"));
				cars.add(car);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();
		return cars;
	}

	public int isExist(Car car) {
		// TODO Auto-generated method stub
		int id = -1;
		conn = DBHelper.getConn();
		sql = "select * from car where brand=? && car_type=? && displacement=? && transmission=? && standard=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getBrand());
			pstmt.setString(2, car.getCar_type());
			pstmt.setFloat(3, car.getDisplacement());
			pstmt.setString(4, car.getTransmission());
			pstmt.setString(5, car.getStandard());
			rs = pstmt.executeQuery();
			while(rs.next()){
				//取出当前的车型id
				id = rs.getInt("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();
		return id;
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
