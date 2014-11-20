<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String username = request.getParameter("username");
	if (username.equals("yan")){
		//out.println("用户名称["+username+"]已经被注册，请更换其他用户名称再注册。");
		out.print("false");
	}
	else{
		out.print("true");
	}
	
 %>
