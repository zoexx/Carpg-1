<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.jfree.chart.ChartFactory,org.jfree.chart.JFreeChart,
org.jfree.chart.plot.PlotOrientation,org.jfree.chart.servlet.ServletUtilities,org.jfree.data.category.DefaultCategoryDataset"%>
<%@ page import="com.carpg.util.Chart" %>
<%
DefaultCategoryDataset dataset = new DefaultCategoryDataset();dataset.addValue(610, "Guangzhou", "猪肉");dataset.addValue(220, "Guangzhou", "牛肉");dataset.addValue(530, "Guangzhou", "鸡肉");dataset.addValue(340, "Guangzhou", "鱼");
  
 //应用主题样式,主要输解决中文乱码问题
 ChartFactory.setChartTheme(Chart.createTheme());
 JFreeChart chart = ChartFactory.createBarChart3D("肉类销量统计图","type","amount",dataset,
PlotOrientation.VERTICAL,false,false,false);
 //ChartFrame  frame=new ChartFrame ("肉类销量统计图 ",chart,true);  
       //frame.pack();  
       //frame.setVisible(true);
String filename = ServletUtilities.saveChartAsPNG(chart, 500, 300, null, session);
String graphURL = request.getContextPath() + "/servlet/DisplayChart.ln?filename=" + filename;
%>
<img src="<%= graphURL %>" width=900 height=400 border=0 usemap="#<%= filename %>">