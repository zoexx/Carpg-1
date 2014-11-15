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

	public void addCar(Car car) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		sql = "insert into car value(null,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, car.getBrand());
			pstmt.setString(2, car.getCar_type());
			pstmt.setFloat(3, car.getDisplacement());
			pstmt.setString(4, car.getSale_time());
			pstmt.setString(5, car.getCategory());
			pstmt.setString(6, car.getConfigure());
			pstmt.setString(7, car.getAlias());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);

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
				cars.add(car);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);
		return cars;
	}

	public boolean isExist(Car car) {
		// TODO Auto-generated method stub
		return false;
	}

}
