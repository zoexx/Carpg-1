package com.carpg.util;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.Year;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.util.Rotation;

import com.carpg.dao.StatisticDao;
import com.carpg.impl.StatisticImpl;

//主要是作为jfreechart的一个工具类进行处理
public class Chart {
	
	//创建静态字符串便于维护和修改
	public static String BRAND_YEAR_COUNT = "brand_year_count"; //品牌按年份统计
	public static String BRAND_COUNT_YEAR = "brand_count_year"; //某一年内各个品牌的状况统计
	public static String BRAND_CARTYPE_COUNT = "brand_cartype_count"; //某一个品牌中各个车型的状况统计
	public static String PROBLEM_YEAR_COUNT = "problem_year_count"; //问题按年份统计
	public static String PROBLEM_COUNT_YEAR = "problem_count_year"; //某一年内各个问题的状况统计
	public static String PROBLEM_CARTYPE_COUNT = "problem_cartype_count"; //某一个问题中各个车型的状况统计
	
	private StatisticDao statistic = new StatisticImpl();
	private JFreeChart chart;
	
	
	
	//构建chart图表，参数类型如下
	//type为识别创建图表的类型,主要是折线图，饼状图，柱状图等
	//operate为操作的类型，主要表示为统计展示的信息类别状况，比如统计品牌以时间为轴的状况量（折线图）
	//param为前端传递的参数，主要是用于后台获取相应的数据
	public void createChart(String type, String operate, String param){
		//表示需要展示饼状图
		if (type.equals("pei_chart")){
			//创建饼状图
			createPeiChart(operate, param);
		}//表示需要展示折线图
		else if (type.equals("line_chart")){
			//创建折线图
			createXYChart(operate, param);
		}
	}
	//创建饼状图,参数类型如下
	//operate主要表示为统计展示的信息类别状况
	//param主要是用于获取相应的数据
	private void createPeiChart(String operate, String param){
		//设置主题样式，主要解决中文乱码问题
		ChartFactory.setChartTheme(createTheme());
		//根据operate类型进行相应的获取
		//表示某一年内各个品牌的问题状况量
		if (operate.equals(Chart.BRAND_COUNT_YEAR)){
			//Map<String, Integer> map = statistic.getCountByYear_brand(param);
			//测试模块
			LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
			map.put("2014", 7000);
			map.put("2013", 2000);
			map.put("2012", 1000);
			map.put("2011", 3000);
			map.put("2010", 3500);
			map.put("2009", 2500);
			chart = ChartFactory.createPieChart3D("各个品牌的状况", 
					createPeiData(map), true, true, false);
			chart.addSubtitle(new TextTitle("年份："+param));
		}
		//表示该品牌下各个车型的状况统计
		else if (operate.equals(Chart.BRAND_CARTYPE_COUNT)){
			Map<String, Integer> map = statistic.getCountByBrand_carType(param);
			chart = ChartFactory.createPieChart3D("各个车型的状况", 
					createPeiData(map), true, true, false);
			chart.addSubtitle(new TextTitle("品牌："+param));
		}
		//表示一年内各个问题的状况统计
		else if (operate.equals(Chart.PROBLEM_COUNT_YEAR)){
			Map<String, Integer> map = statistic.getCountByProblem_year(param);
			chart = ChartFactory.createPieChart3D("各个问题的状况", 
					createPeiData(map), true, true, false);
			chart.addSubtitle(new TextTitle("年份："+param));
		}
		//表示某一个问题下各个车型状况的统计
		else if (operate.equals(Chart.PROBLEM_CARTYPE_COUNT)){
			Map<String, Integer> map = statistic.getCountByProblem_carTypes(param);
			chart = ChartFactory.createPieChart3D("各个车型的状况", 
					createPeiData(map), true, true, false);
			chart.addSubtitle(new TextTitle("问题："+param));
		}
		//设置饼状图的样式
		setPeiTheme();
	}
	//创建折线图,参数类型如下
	//operate主要表示为统计展示的信息类别状况
	//param主要是用于获取相应的数据
	private void createXYChart(String operate, String param){
		//设置主题样式，主要解决中文乱码问题
		ChartFactory.setChartTheme(createTheme());
		//根据operate类型进行相应的获取
		
		//表示品牌按年份统计
		if (operate.equals(Chart.BRAND_YEAR_COUNT)){
			//根据传递的品牌参数活动每年的数据量
			//Map<String, Integer> map = statistic.getCountByYear_brand(param);
			//测试模块
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("2014", 7000);
			map.put("2013", 2000);
			map.put("2012", 1000);
			map.put("2011", 3000);
			map.put("2010", 3500);
			map.put("2009", 2500);
			//创建相应的折线图
			chart = ChartFactory.createTimeSeriesChart(
	                "汽车品牌问题统计", "年份", "吐槽量",
	                createXYData(map), true, true, true);
			
		}//表示问题按年份统计
		else if (operate.equals(Chart.PROBLEM_YEAR_COUNT)){
			Map<String, Integer> map = statistic.getCountByYear_problem(param);
			//创建相应的折线图
			chart = ChartFactory.createTimeSeriesChart(
	                "汽车问题状况统计", "年份", "吐槽量",
	                createXYData(map), true, true, true);
		}
		//给折线图设置样式
		setXYTheme();
	}
	//创建折线图数据源,参数为后台获取的Map数据
	private XYDataset createXYData(Map<String, Integer> map){
		TimeSeries timeseries = new TimeSeries("问题状况数量",
                org.jfree.data.time.Year.class);
        
        //得到当前的年份
        Calendar c = Calendar.getInstance();
        int currentYear = c.get(Calendar.YEAR);
        //展示出过去5年的问题状况
        for (int k=currentYear; k>= currentYear-4; k--){
        	//暂时确定单位为百数量级
        	double value = map.get(String.valueOf(k)) / 100;
        	timeseries.add(new Year(k), value);
        }
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        //timeseriescollection.addSeries(timeseries1);
        
        return timeseriescollection;
	}
	//创建饼状图数据源，参数为获取的后台的数据量
	private DefaultPieDataset createPeiData(Map<String, Integer> map){
		//设置饼图数据集  
		DefaultPieDataset dataset = new DefaultPieDataset();
		//得到统计量
		LinkedHashMap<String, Integer> linkMap = (LinkedHashMap<String, Integer>)map;
		Set set = linkMap.entrySet();
		Iterator iterator = set.iterator();
		//遍历hashMap并载入到数据源
		while (iterator.hasNext()){
			 Map.Entry element = (Map.Entry)iterator.next(); 
	         String  key = (String)element.getKey(); 
	         int  value = (Integer)element.getValue();
	         dataset.setValue(key, value);
		}
		
		return dataset;
	}
	

	
	//创建主题样式，主要是解决中文乱码问题
	public StandardChartTheme createTheme(){
		//创建主题样式  
		 StandardChartTheme standardChartTheme=new StandardChartTheme("CN");
		//设置标题字体  
		 standardChartTheme.setExtraLargeFont(new Font("隶书",Font.BOLD,20));  
		//设置图例的字体  
		 standardChartTheme.setRegularFont(new Font("宋书",Font.PLAIN,15));  
		//设置轴向的字体  
		 standardChartTheme.setLargeFont(new Font("宋书",Font.PLAIN,15));
		 
		 return standardChartTheme;
	}
	
	//设置折线图样式
	public void setXYTheme(){		
		chart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot) chart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot
                .getRenderer();
        if (xyitemrenderer instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyitemrenderer;
            xylineandshaperenderer.setBaseShapesVisible(true);
            xylineandshaperenderer.setBaseShapesFilled(true);
         // 显示节点的值  
            xylineandshaperenderer.setBaseItemLabelsVisible(true);  
            xylineandshaperenderer  
                    .setBasePositiveItemLabelPosition(new ItemLabelPosition(  
                            ItemLabelAnchor.OUTSIDE7, TextAnchor.BASELINE_CENTER));  
            xylineandshaperenderer  
                    .setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        }
        DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("——yyyy——"));
	}
	//设置饼状图样式
	public void setPeiTheme(){
		PiePlot pieplot = (PiePlot) chart.getPlot();  
		pieplot.setLabelFont(new Font("宋体", 0, 11));  
		StandardPieSectionLabelGenerator standarPieIG = new StandardPieSectionLabelGenerator("{0}:({1},{2})", NumberFormat.getNumberInstance(), NumberFormat.getPercentInstance());  
		pieplot.setLabelGenerator(standarPieIG);  
		  
		//没有数据的时候显示的内容  
		pieplot.setNoDataMessage("无数据显示");  
		pieplot.setLabelGap(0.02D);
		
		//第一个参数是key,第二个参数是突出显示的大小（可以自己调整一下看看效果就明白了）   
		//pieplot.setExplodePercent("城管强拆",0.23);
		  
		PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot();  
		//设置开始角度  
		pieplot3d.setStartAngle(120D);  
		//设置方向为”顺时针方向“  
		pieplot3d.setDirection(Rotation.CLOCKWISE);  
		//设置透明度，0.5F为半透明，1为不透明，0为全透明  
		pieplot3d.setForegroundAlpha(0.7F); 
	}

	public JFreeChart getChart() {
		return chart;
	}

	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}
}
