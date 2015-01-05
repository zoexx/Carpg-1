
var newsCount;//设置计数器
//加载新闻列表
//var newsJson=<%=新闻列表json%>;
var jakeJson=[
{"car":"沃尔沃XC60/S60L","seller":"浙江豪情汽车","time":"12-31","source":"国家质检总局","imgSrc":"../images/img/newsSmallPic.png","nTitle":"浙江豪情汽车召回部分国产沃尔沃XC60/S60L","content":"&nbsp;&nbsp;&nbsp;&nbsp;日前，浙江豪情汽车制造有限公司根据《缺陷汽车产品召回管理条例》的要求，向国家质检总局备案了召回计划，决定自2014年12月31日起，召回2014年11月12日至2014年11月19日期间生产的部分国产2015款沃尔沃XC60及S60L汽车，共计529辆。","praise":11},
{"car":"沃尔沃XC60/S60L","seller":"浙江豪情汽车","time":"12-31","source":"国家质检总局","imgSrc":"../images/img/newsSmallPic.png","nTitle":"浙江豪情汽车召回部分国产沃尔沃XC60/S60L","content":"&nbsp;&nbsp;&nbsp;&nbsp;日前，浙江豪情汽车制造有限公司根据《缺陷汽车产品召回管理条例》的要求，向国家质检总局备案了召回计划，决定自2014年12月31日起，召回2014年11月12日至2014年11月19日期间生产的部分国产2015款沃尔沃XC60及S60L汽车，共计529辆。","praise":11},
{"car":"沃尔沃XC60/S60L","seller":"浙江豪情汽车","time":"12-31","source":"国家质检总局","imgSrc":"../images/img/newsSmallPic.png","nTitle":"浙江豪情汽车召回部分国产沃尔沃XC60/S60L","content":"&nbsp;&nbsp;&nbsp;&nbsp;日前，浙江豪情汽车制造有限公司根据《缺陷汽车产品召回管理条例》的要求，向国家质检总局备案了召回计划，决定自2014年12月31日起，召回2014年11月12日至2014年11月19日期间生产的部分国产2015款沃尔沃XC60及S60L汽车，共计529辆。","praise":11},
];
var newsJson=jakeJson;
//var nColumn=<%=汽车召回or缺陷调查%>
setNewsColumn(nColumn);//设置新闻栏目名称
function loadnews () {
	var maxsize;//设置每页展示新闻条数
	for (var i = 0; i < maxsize; i++) {
		showNews(i);
		newsCount++;
	}
	
}
function setNewsColumn (nColumn) {
	document.getElementById("nColumn").innerHTML=""+nColumn;
}
function showNews (i) {
	var ali=document.createElement("li");
	ali.className="newsPreContent";
	ali.value=newsCount;
	ali.onclick="toDetailPage(this)";
	var ap=document.createElement("p");
	var aspan=document.createElement("span");
	aspan.className="newsCategory left";
	aspan.innerHTML=newsJson[i].car;
	var bspan=document.createElement("span");
	bspan.className=aspan.className;
	bspan.innerHTML="/"+newsJson[i].seller;
	var cspan=document.createElement("span");
	cspan.className=aspan.className;
	cspan.innerHTML="/"+newsJson[i].time;
	var dspan=document.createElement("span");
	dspan.className=aspan.className;
	dspan.innerHTML=""+newsJson[i].source;
	ap.appendChild(aspan);
	ap.appendChild(bspan);
	ap.appendChild(cspan);
	ap.appendChild(dspan);
	ali.appendChild(ap);
	var aimg=document.createElement("img");
	aimg.src=""+newsJson[i].imgSrc;
	aimg.alt=""+newsJson[i].nTitle;
	aimg.className="newsSmallPic left";
	ali.appendChild(aimg);
	var bp=document.createElement("p");
	bp.className="newsPreText";
	var ahref=document.createElement("a");
	ahref="#";
	var ahh=document.createElement("h2");
	ahh.innerHTML=""+newsJson[i].nTitle;
	var bhh=document.createElement("h5");
	bhh.innerHTML=""+getPreviewText(newsJson[i].content);
	bp.appendChild(ahref);
	bp.appendChild(ahh);
	bp.appendChild(bhh);
	ali.appendChild(bp);
	var espan=document.createElement("span");
	espan.className="redLineNub right";
	espan.innerHTML="赞（"+newsJson[i].praise+"）";
	ali.appendChild(espan);
	document.getElementById("newsListContent").appendChild(ali);
}
function getPreviewText (str) {
	var contentLength=101;//设置截取段落的长度
	//预览内容，截取文章第一段的101个字，并加上....省略号
	//获得第一段，拆开第一个p，如果为空拆下一个
	var a=str.split("</p>");
	var atext;
	for (var i = 0; i < a.length; i++) {
		 var ainner=a[i].split(">");
		 if (ainner[1]) {
		 	atext=ainner[1];
		 }else{
		 	continue;
		 }
	}
	
	var stext=ainner[1];
	//字符串长度如果小于101，如果大于101，只截取到101
	//加上省略号输出
}
function toDetailPage(obj){
	//传newsJson[obj.value]过去下一个页面；
	
}