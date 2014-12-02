package com.carpg.util;

import java.awt.Color;
import java.awt.Font;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
	
	private StatisticDao statistic = new StatisticImpl();
	
	
	//创建主题样式，主要是解决中文乱码问题
	public static StandardChartTheme createTheme(){
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

	//创建按品牌-年份统计折线图数据源
	private XYDataset createXYDataset(String brand) {
        TimeSeries timeseries = new TimeSeries("问题状况数量",
                org.jfree.data.time.Year.class);
        
        Map<String, Integer> map = statistic.getCountByYear_brand(brand);
        //得到当前的年份
        Calendar c = Calendar.getInstance();
        int currentYear = c.getTime().getYear();
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
	//创建按品牌-年份折线图chart
	public JFreeChart createXYChart(String brand) {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart(
                "汽车品牌问题统计", "年份", "吐槽量",
                createXYDataset(brand), true, true, true);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
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
        return jfreechart;
    }
	
	//创建哪一年份各个品牌的问题状况统计饼状图数据源
	private DefaultPieDataset createPeiDataset(String year){
		//设置饼图数据集  
		DefaultPieDataset dataset = new DefaultPieDataset();
		//得到统计量
		LinkedHashMap<String, Integer> map = (LinkedHashMap<String, Integer>) statistic.getCountByYear(year);
		Set set = map.entrySet();
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
	//创建饼状图的jfreechart
	public JFreeChart createPeiChart(String year){
		//通过工厂类生成JFreeChart对象  
		JFreeChart chart = ChartFactory.createPieChart3D("商户被关注度统计", createPeiDataset(year), true, true, false);  
		chart.addSubtitle(new TextTitle("2014上半年"));  
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
		
		return chart;
	}
}
