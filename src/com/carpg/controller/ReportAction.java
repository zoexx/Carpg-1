package com.carpg.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.carpg.dao.ReportDao;
import com.carpg.dto.Report;
import com.carpg.impl.ReportImpl;
import com.carpg.util.JsonTool;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ReportAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,ModelDriven<Report>{

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	private Report report = new Report();
	private ReportDao reportDao = new ReportImpl();
	
	//用于向页面传达至
	private String msg;
	
	//添加报告
	public String addReport() throws Exception{
		reportDao.addReport(report);
		return "";
	}
	//展示报告信息列表
	public String showReport() throws Exception{
		List<Object> list = reportDao.getReports(report.getType(), report.getId());
		JsonTool json = new JsonTool();
		msg = json.toJsonArrayString(list);	
		return "";
	}
	
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
		
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
	}

	public Report getModel() {
		// TODO Auto-generated method stub
		return report;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
