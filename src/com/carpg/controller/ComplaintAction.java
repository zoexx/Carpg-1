package com.carpg.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.carpg.dao.ComplaintDao;
import com.carpg.dao.User_CarDao;
import com.carpg.dto.Complaint;
import com.carpg.dto.User_Car;
import com.carpg.impl.ComplaintImpl;
import com.carpg.impl.User_CarImpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ComplaintAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ModelDriven<Complaint>{
	
	private HttpServletResponse response;  
	private HttpServletRequest request; 
	
	private Complaint complaint = new Complaint();
	private ComplaintDao comDao = new ComplaintImpl();
	private User_CarDao user_carDao = new User_CarImpl();
	//��Ϣ�����ķ�����Ϣ
	private String msg;

	//��ʾ��׼���²۵ĵ�����(�²۵�һ��)
	public String complaintStep1() throws Exception{
		//����session�ж��û��Ƿ��½
		String info = (String)request.getSession().getAttribute("user");
		//���sessionΪ�����ʾΪ��½
		if (null == info){
			//�ض��򵽵�½����
			return "login";
		}else{
			//ͨ��session�е��û���Ϣȡ���û��������û����б�
			int userid = Integer.valueOf(info.split("~")[1]);
			List<User_Car> list = user_carDao.getUser_Car(userid);
			msg = "";
			//��ȡ�õ�������Ϣƴ������������ҳ��
			for(int i=0; i < list.size()-1; i++){
				msg += list.get(i).getId() +"," +list.get(i).getCar_brand()+"," +list.get(i).getCar_type();
				msg +="~";
			}
			msg += list.get(list.size()-1).getId() +"," +list.get(list.size()-1).getCar_brand()+"," +list.get(list.size()-1).getCar_type();
			System.out.println("���ص���Ϣ:" +msg);
			//��������Ϣ���ӵ�session��
			request.getSession().setAttribute("user_carinfo", msg);
			//��ת���²۵ڶ���
			return "step2";
		}		
	}
	////��ʾ��ѡ�����²۳���(�²۵ڶ���)
	public String complaintStep2() throws Exception{
		//��ѡ��ĳ�����Ϣ�ݴ���session��
		msg = request.getParameter("select_cars");
		System.out.println("ѡȡ���͵���Ϣ"+msg);
		request.getSession().setAttribute("user_carinfo", msg);
		//ҳ����ת����3��
		return "step3";
	}
	//��ʾ����²۵Ĵ�������(�²۵�3�������)
	public String complaintStep3() throws Exception{
		//�Ƚ�session�д洢��ѡ�񳵵���Ϣȡ��
		String carinfo = (String)request.getSession().getAttribute("user_carinfo");
		return "index";
	}
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public Complaint getModel() {
		// TODO Auto-generated method stub
		return complaint;
	}

	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
}