package com.carpg.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.carpg.dao.ComplaintDao;
import com.carpg.dto.Complaint;
import com.carpg.util.DBHelper;

public class ComplaintImpl implements ComplaintDao {
	
	private Connection conn=null;
	private PreparedStatement pstmt=null;
	private ResultSet rs=null;
	private String sql="";

	public void addComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		sql = "insert into complaint value(null,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, complaint.getUser_id());
			pstmt.setString(2, complaint.getUser_name());
			pstmt.setInt(3, complaint.getUser_car_id());
			pstmt.setInt(4, complaint.getProblem_id());
			pstmt.setString(5, complaint.getTime());
			pstmt.setString(6, complaint.getStart_time());
			pstmt.setString(7, complaint.getFrequency());
			pstmt.setString(8, complaint.getCourse());
			pstmt.setString(9, complaint.getSolution());
			pstmt.setInt(10, complaint.getFee());
			pstmt.setString(11, complaint.getImage());
			pstmt.setString(12, complaint.getMark());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);

	}

	public void delComplaint(int id) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		sql = "delete from complaint where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);
	}

	public List<Complaint> getComplaints(String username) {
		// TODO Auto-generated method stub
		List<Complaint> list = new ArrayList<Complaint>();
		conn = DBHelper.getConn();
		sql = "select * from compliant where user_name=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Complaint com = new Complaint();
				com.setId(rs.getInt("id"));
				com.setUser_id(rs.getInt("user_id"));
				com.setUser_name(rs.getString("user_name"));
				com.setUser_car_id(rs.getInt("user_car_id"));
				com.setProblem_id(rs.getInt("problem_id"));
				com.setTime(rs.getString("time"));
				com.setStart_time(rs.getString("start_time"));
				com.setFrequency(rs.getString("frequency"));
				com.setCourse(rs.getString("course"));
				com.setSolution(rs.getString("solution"));
				com.setFee(rs.getInt("fee"));
				com.setImage(rs.getString("image"));
				com.setMark(rs.getString("mark"));
				list.add(com);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);
		return list;
	}

	public void updateComplaint(Complaint complaint) {
		// TODO Auto-generated method stub
		conn = DBHelper.getConn();
		sql = "update complaint set time=?, start_time=?, frequency=?, course=?,"+
						"solution=?, fee=?, image=?, mark=? where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, complaint.getTime());
			pstmt.setString(2, complaint.getStart_time());
			pstmt.setString(3, complaint.getFrequency());
			pstmt.setString(4, complaint.getCourse());
			pstmt.setString(5, complaint.getSolution());
			pstmt.setInt(6, complaint.getFee());
			pstmt.setString(7, complaint.getImage());
			pstmt.setString(8, complaint.getMark());
			pstmt.setInt(9, complaint.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DBHelper.close(rs, pstmt);

	}

}
