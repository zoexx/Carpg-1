package com.carpg.dao;

import java.util.Map;


//信息的提取统计
public interface StatisticDao {
	
	/*以汽车品牌为统计参照进行比较*/
	
	//得到某一个品牌按年份被吐槽的的数据，返回值为Map类型<年份，数量>
	public Map<String, Integer> getCountByYear_brand(String brand);
	
	//按年份统计各个品牌的问题状况量,返回值为Map类型<品牌，数量>,并是按照降序排列
	public Map<String, Integer> getCountByYear(String year);
	
	//统计按品牌中的车型统计问题状况量，返回值为Map类型<车型，数量>,并按照降序排列
	public Map<String, Integer> getCountByBrand_carType(String brand);
	
	
	/*以问题状况为统计参照进行比较*/
	//得到一个问题按年份被吐槽的数据,返回值为Map类型<年份,数量>
	public Map<String, Integer> getCountByYear_problem(String problem);
	
	//按年份统计各个问题的状况量，返回值为Map类型<问题，数量>,并按降序排列
	public Map<String, Integer> getCountByProblem_year(String year);
	
	//统计某一个问题中被吐槽的各个车型的排行情况,返回值为Map类型<车型，数量>， 并按降序排列
	public Map<String, Integer> getCountByProblem_carTypes(String problem);

}
