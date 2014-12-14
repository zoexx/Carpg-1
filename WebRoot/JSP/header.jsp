<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String user = (String)request.getSession().getAttribute("user");
	//定义变量保存登陆用户的信息
	String loginUsername = ""; 
	if (null != user && !user.equals("")){
		String[] temp = user.split("~");
		loginUsername = temp[2];	
	}
 %>
<jsp:include page="../HTML/header.html"></jsp:include>
