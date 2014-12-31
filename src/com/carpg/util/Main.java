package com.carpg.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.mail.MessagingException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Main {
	static int id;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试模块
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("2014", 7000);
		map.put("2013", 2000);
		map.put("2012", 1000);
		map.put("2011", 3000);
		map.put("2010", 3500);
		map.put("2009", 2500);
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
		System.out.println("map转化为json："+ array.toString());

	}
	public void setI(){
		id = 3;
	}

}
