<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//获取首页新闻模块的数据（5条）
	String msgReport = (String)request.getAttribute("msgReport");
%>
<jsp:include page="/HTML/right_news.html"></jsp:include>