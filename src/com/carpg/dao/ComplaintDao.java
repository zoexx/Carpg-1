package com.carpg.dao;

import java.util.List;

import com.carpg.dto.Complaint;

public interface ComplaintDao {
	
	//提交抱怨信息
	public void addComplaint(Complaint complaint);
	
	//更新抱怨信息,只有部分信息允许更新
	//更新信息: time, start_time, frequency, course, solution, fee, image, mark
	public void updateComplaint(Complaint complaint);
	
	//删除抱怨信息,参数为抱怨信息id
	public void delComplaint(int id);
	
	//获得用户自身的抱怨信息, 参数为用户名
	public List<Complaint> getComplaints(String username);

}
