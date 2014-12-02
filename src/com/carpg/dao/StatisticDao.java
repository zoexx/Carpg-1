package com.carpg.dao;

import java.util.Map;


//信息的提取统计
public interface StatisticDao {
	
	//得到某一个品牌按年份被吐槽的的数据，返回值为Map类型<年份，数量>
	public Map<String, Integer> getCountByYear_brand(String brand);
	
	//按年份统计各个品牌的问题状况量,返回值为Map类型<品牌，数量>,并是按照降序排列
	public Map<String, Integer> getCountByYear(String year);
	

}
