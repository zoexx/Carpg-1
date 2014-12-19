<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.carpg.util.Chart" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%

    //应用主题样式,主要输解决中文乱码问题
    ChartFactory.setChartTheme(Chart.createTheme());
    JFreeChart chart = Chart.createPeiChart();
    String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, null, session);
	String graphURL = request.getContextPath() + "/servlet/DisplayChart.ln?filename=" + filename;
%>	

<img src="<%= graphURL %>" width=625 height=400 border=0 usemap="#<%= filename %>">
