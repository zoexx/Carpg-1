package com.carpg.controller;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.carpg.dao.StatisticDao;
import com.carpg.impl.StatisticImpl;
import com.carpg.util.JsonTool;
import com.opensymphony.xwork2.ActionSupport;


public class StatisticAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
	
	//创建静态字符串便于维护和修改
	public static String BRAND_YEAR_COUNT = "brand_year_count"; //品牌按年份统计
	public static String BRAND_COUNT_YEAR = "brand_count_year"; //某一年内各个品牌的状况统计
	public static String BRAND_CARTYPE_COUNT = "brand_cartype_count"; //某一个品牌中各个车型的状况统计
	public static String PROBLEM_YEAR_COUNT = "problem_year_count"; //问题按年份统计
	public static String PROBLEM_COUNT_YEAR = "problem_count_year"; //某一年内各个问题的状况统计
	public static String PROBLEM_CARTYPE_COUNT = "problem_cartype_count"; //某一个问题中各个车型的状况统计
	
	private HttpServletRequest request;
	private HttpServletResponse response;
	
	
	
	private String type;     //表示操作的类型
	private String param;	//表示传递的参数
	private String msg;		//表示回传的数据
	
	public String getRank() throws Exception{
		//根据type的类别执行操作
		if (type.equals(BRAND_YEAR_COUNT)){
			//执行操作
			StatisticDao staDao = new StatisticImpl();
			LinkedHashMap<String, Integer> map = (LinkedHashMap<String, Integer>)staDao.getCountByYear_brand(param);
			Set set = map.entrySet();
			Iterator iterator = set.iterator();
			JSONArray array = new JSONArray();
			//遍历hashMap并载入到数据源(JSONArray)
			while (iterator.hasNext()){
				 Map.Entry element = (Map.Entry)iterator.next(); 
		         String  key = (String)element.getKey(); 
		         int  value = (Integer)element.getValue();
		         JSONObject obj = new JSONObject();
		         obj.put("name", key);
		         obj.put("nub", value);
		         array.add(obj);
			}
			msg = array.toString();
			
		}
		return "rank";
	}
	

	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
		
	}

	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response = arg0;
		
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

}
