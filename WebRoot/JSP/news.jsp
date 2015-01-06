<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>车曝光-车讯列表</title>
		<meta name="title" content="车曝网" />
		<meta name="keywords" content="车曝网,汽车,轿车,二手车,曝光,质量,驾驶安全,反馈,调查报告,数据分析,召回,拍卖,竞价,消费者权益,315,车"/>
		<meta name="description" content="车曝网是国内首家收集整理车主驾驶体验信息的完全公开完全开放的民间网站，车曝网为广大车主以及准车主提供大量汽车质量的数据分析服务以及二手车交易信息服务。" />
		<link rel="stylesheet" href="../CSS/new_layout.css" />
		<link rel="stylesheet" href="../CSS/color.css" />
	    <script type="text/javascript" src="../JS/util.js" ></script>
	    <script src="../JS/loadnews.js" type="text/javascript" charset="utf-8"></script>
	</head>
	<body>
<jsp:include page="header.jsp" flush="true" ></jsp:include>
        <div  class="global_content">
			<div  class="index_rank right">
             <jsp:include page="/HTML/right_rank.html"></jsp:include>
             <jsp:include page="/HTML/right_news.html"></jsp:include>
	    	</div>
		
		    <div class="index_content left">
		    	<ul class="left-li-clear" id="newsListContent">				
					<li class="view_newsTitle">
						<h2 class="newsGrey"><b id="nColumn">汽车召回</b></h2>
					</li>
					<script type="text/javascript">
var newsCount=0;//设置计数器
var jakeJson=[
{"car":"沃尔沃XC60/S60L","seller":"浙江豪情汽车","time":"12-31","source":"国家质检总局","imgSrc":"../images/img/newsSmallPic.png","nTitle":"浙江豪情汽车召回部分国产沃尔沃XC60/S60L","content":"<p style=\"color=black\">&nbsp;&nbsp;&nbsp;&nbsp;日前，浙江豪情汽车制造有限公司根据《缺陷汽车产品召回管理条例》的要求，向国家质检总局备案了召回计划，决定自2014年12月31日起，召回2014年11月12日至2014年11月19日期间生产的部分国产2015款沃尔沃XC60及S60L汽车，共计529辆。</p>","praise":11},
{"car":"沃尔沃XC60/S60L","seller":"浙江豪情汽车","time":"12-31","source":"国家质检总局","imgSrc":"../images/img/newsSmallPic.png","nTitle":"浙江豪情汽车召回部分国产沃尔沃XC60/S60L","content":"<p style=\"color=black\">&nbsp;&nbsp;&nbsp;&nbsp;日前，浙江豪情汽车制造有限公司根据《缺陷汽车产品召回管理条例》的要求，向国家质检总局备案了召回计划，决定自2014年12月31日起，召回2014年11月12日至2014年11月19日期间生产的部分国产2015款沃尔沃XC60及S60L汽车，共计529辆。</p>","praise":11},
{"car":"沃尔沃XC60/S60L","seller":"浙江豪情汽车","time":"12-31","source":"国家质检总局","imgSrc":"../images/img/newsSmallPic.png","nTitle":"浙江豪情汽车召回部分国产沃尔沃XC60/S60L","content":"<p style=\"color=black\">&nbsp;&nbsp;&nbsp;&nbsp;日前，浙江豪情汽车制造有限公司根据《缺陷汽车产品召回管理条例》的要求，向国家质检总局备案了召回计划，决定自2014年12月31日起，召回2014年11月12日至2014年11月19日期间生产的部分国产2015款沃尔沃XC60及S60L汽车，共计529辆。</p>","praise":11},
];
var newsJson=jakeJson;
var nColumn="汽车召回";
setNewsColumn(nColumn);//设置新闻栏目名称	
loadnews(3);//数字表示展示新闻的条数
					</script>
			 <!--<jsp:include page="/HTML/left_newslist.html"></jsp:include>-->
			 	</ul>
		    </div>
		</div>
<jsp:include page="/HTML/footer.html"></jsp:include>
	
	</body>
</html>
