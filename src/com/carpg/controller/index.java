package com.carpg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class index extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	//请求的类别
	private int typeReport;
	
	//服务器向前端传递的值
	//信息报告的值
	private String msgReport;
	//统计数据的值
	private String msgStatistic;
	
	//首页的请求转发
	public String execute() throws Exception{
		System.out.println("首页请求");
		//将首页动态展示的信息传递给页面前端（session或其他）
		//得到首页的统计展示数据
		StatisticAction staAction = new StatisticAction();
		//得到首页的调查报告，汽车召回的数据
		ReportAction reAction = new ReportAction();
		reAction.getReport_index(1);
		//得到后端请求的信息报告的值
		msgReport = reAction.getMsg();
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

	public int getTypeReport() {
		return typeReport;
	}

	public void setTypeReport(int typeReport) {
		this.typeReport = typeReport;
	}

	public String getMsgReport() {
		return msgReport;
	}

	public void setMsgReport(String msgReport) {
		this.msgReport = msgReport;
	}

	public String getMsgStatistic() {
		return msgStatistic;
	}

	public void setMsgStatistic(String msgStatistic) {
		this.msgStatistic = msgStatistic;
	}


}
