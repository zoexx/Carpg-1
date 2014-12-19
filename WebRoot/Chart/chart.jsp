<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="com.carpg.util.Chart" %>
<%@ page import="org.jfree.chart.servlet.ServletUtilities" %>
<%@ page import="org.jfree.chart.ChartRenderingInfo" %>
<%@ page import="org.jfree.chart.entity.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//获取页面传递过来的参数
	String type = request.getParameter("type");
	String operate = request.getParameter("operate");
	String param = request.getParameter("param");
	
	//进行数据测试
	type = "pei_chart";
	operate = Chart.BRAND_COUNT_YEAR;
	param = "奥迪";
 %>
<%
	//生成图表
	Chart chart = new Chart();
	chart.createChart(type, operate, param);
	//创建一个ChartRenderingInfo对象。
    ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
    String filename = ServletUtilities.saveChartAsPNG(chart.getChart(), 500, 300, info, session);
	String graphURL = request.getContextPath() + "/servlet/DisplayChart.sl?filename=" + filename;
%>	

<img src="<%= graphURL %>" width=625 height=400 border=0 usemap="#<%= filename %>">
