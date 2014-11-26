package com.carpg.dao;

import java.util.List;

//信息的提取统计
public interface StatisticDao {
	
	//得到某一个品牌按年份被吐槽的的数据
	public List<Integer> getCountByYear_brand(String brand); 
	

}
