package com.carpg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpg.dao.User_CarDao;
import com.carpg.dto.User_Car;
import com.carpg.util.DBHelper;

public class User_CarImpl implements User_CarDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";

	public int addUser_Car(User_Car userCar) {
		// TODO Auto-generated method stub
		int id = -1;
		PreparedStatement pstmt1=null;
		ResultSet rs1=null;
		conn = DBHelper.getConn();
		sql = "insert into user_car value(null,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userCar.getUser_id());
			pstmt.setString(2, userCar.getUser_name());
			pstmt.setInt(3, userCar.getCar_id());
			pstmt.setString(4, userCar.getCar_brand());
			pstmt.setString(5, userCar.getCar_type());
			pstmt.setString(6, userCar.getVin());
			pstmt.setString(7, userCar.getColor());
			pstmt.setString(8, userCar.getBuy_time());
			pstmt.setInt(9, userCar.getMileage());
			pstmt.setString(10, userCar.getRemark());
			pstmt.executeUpdate();
			//取出刚出入数据的id
			sql = "select max(id) from user_car";
			pstmt1 = conn.prepareStatement(sql);
			rs1 = pstmt1.executeQuery();
			while (rs1.next()){
				id = rs1.getInt(1);
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
		return id;
	}

	public void delUser_Car(int id) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		sql = "delete from user_car where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();

	}

	public List<User_Car> getUser_Car(int userid) {
		// TODO Auto-generated method stub
		List<User_Car> list = new ArrayList<User_Car>();
		conn = DBHelper.getConn();
		sql = "select * from user_car where user_id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, username);
			pstmt.setInt(1, userid);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User_Car userCar = new User_Car();
				userCar.setId(rs.getInt("id"));
				userCar.setUser_id(rs.getInt("user_id"));
				userCar.setUser_name(rs.getString("user_name"));
				userCar.setCar_id(rs.getInt("car_id"));
				userCar.setCar_brand(rs.getString("car_brand"));
				userCar.setCar_type(rs.getString("car_type"));
				userCar.setVin(rs.getString("vin"));
				userCar.setColor(rs.getString("color"));
				userCar.setBuy_time(rs.getString("buy_time"));
				userCar.setMileage(rs.getInt("mileage"));
				userCar.setRemark(rs.getString("remark"));
				list.add(userCar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();
		return list;
	}

	public void updateUser_Car(User_Car userCar) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		sql = "update user_car set color=?, buy_time=?, mileage=?, remark=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userCar.getColor());
			pstmt.setString(2, userCar.getBuy_time());
			pstmt.setInt(3, userCar.getMileage());
			pstmt.setString(4, userCar.getRemark());
			pstmt.setInt(5, userCar.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.close();

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
