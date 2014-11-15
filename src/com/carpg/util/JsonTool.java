package com.carpg.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.carpg.dto.User;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonTool {
	
	
	//将Object对象转化为json字符串
	public String toJsonString(Object obj){
		return JSONObject.fromObject(obj).toString();
	}
	
	//将Object对象集转化为JsonArray字符串
	public String toJsonArrayString(List<Object> objs){
		return JSONArray.fromObject(objs).toString();
	}
	
	//将json字符串转化为Object对象
	public Object toObject(String jsonString, Class method){
        Object bean = (User)JSONObject.toBean(JSONObject.fromObject(jsonString), method.getClass());
        
        return bean;
	}
	
	//将jsonArray字符串转化为List<Object>对象
	public List<Object> toObjects(String jsonArrayString, Class method){
		List<Object> beans = (List<Object>)JSONArray.toList(JSONArray.fromObject(jsonArrayString), method.getClass());
	
		return beans;
	}

}
