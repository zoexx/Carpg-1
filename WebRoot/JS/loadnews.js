

function loadmessage(maxsize) {
	//maxsize设置每页展示新闻条数
	for (var i = 0; i < maxsize; i++) {
		if (newsCount==newsJson.length) {
				//隐藏“加载更多”
				document.getElementById("view_more").hidden=true;
				break;
			}else{
				showNews(i);
				newsCount++;
			}
	}
	
}
function setNewsColumn (nColumn) {
	if (nColumn==1) {
		nColumn="汽车召回";
	}else if(nColumn==0){
		nColumn="缺陷调查";
	}else{
		nColumn="缺陷&召回";
	}
	document.getElementById("nColumn").innerHTML=""+nColumn;
}
function showNews (i) {
	var ali=document.createElement("li");
	ali.className="newsPreContent";
	ali.value=newsCount;
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
	ap.appendChild(aspan);
	ap.appendChild(bspan);
	ap.appendChild(cspan);
	ali.appendChild(ap);
	var aimg=document.createElement("img");
	aimg.src=""+newsJson[i].image;
	aimg.alt=""+newsJson[i].nTitle;
	aimg.className="newsSmallPic left";
	ali.appendChild(aimg);
	var bp=document.createElement("p");
	bp.className="newsPreText";
	var ahref=document.createElement("a");
	ahref.href="#";
	var ahh=document.createElement("h2");
	ahh.innerHTML=""+newsJson[i].nTitle;
	var bhh=document.createElement("h5");
	bhh.innerHTML=""+getPreviewText(newsJson[i].content);
	ahref.appendChild(ahh);
	ahref.appendChild(bhh);
	bp.appendChild(ahref);
	ali.appendChild(bp);
	var espan=document.createElement("span");
	espan.className="redLineNub right";
	espan.innerHTML="赞（"+newsJson[i].praise+"）";
	ali.appendChild(espan);
	document.getElementById("newsListContent").appendChild(ali);
}
function getPreviewText (str) {
	var contentLength=100;//设置截取段落的长度
	//预览内容，截取文章第一段的101个字，并加上....省略号
	//获得第一段，拆开第一个p，如果为空拆下一个
	var a=str.split("</p>");
	var atext;
	for (var i = 0; i < a.length; i++) {
		 var ainner=a[i].split(">");
		 if (ainner[1]) {
		 	atext=ainner[1];
		 	break;
		 }
	}
	if(atext.length>contentLength){
		atext=atext.substring(0,99);
	}
	atext+="......";//加上省略号输出
	return atext;
}
function setLiClick () {
	var lia=document.getElementsByClassName("newsPreContent");
	for (var i = 0; i < lia.length; i++) {
		var value=lia[i].value;
		lia[i].onclick=function (){
	var str=JSON.stringify(newsJson[value]);
	alert(str);
	window.location.href=""+encodeURI(encodeURI('news_detail.jsp?param='+str));
}
	}
}
function loadnewsDetail () {
	document.getElementById("category").innerHTML=""+news.category;
	document.getElementById("nTitle").innerText=news.nTitle;
	document.getElementById("info").innerHTML=news.author+"/"+news.time;
	if (news.image) {
		document.getElementById("image").src=news.image;
	}
	document.getElementById("content").innerHTML=""+news.content;
	var source=document.getElementById("author");
	source.innerText=news.author;
	var aurl=document.createElement("a");
	aurl.href=""+news.url;
	aurl.innerText=news.url;
	source.appendChild(aurl);
}
//滚动到底部时加载更多
//滚动条在Y轴上的滚动距离

function getScrollTop(){
　　var scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
　　if(document.body){
　　　　bodyScrollTop = document.body.scrollTop;
　　}
　　if(document.documentElement){
　　　　documentScrollTop = document.documentElement.scrollTop;
　　}
　　scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
　　return scrollTop;
}

//文档的总高度

function getScrollHeight(){
　　var scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
　　if(document.body){
　　　　bodyScrollHeight = document.body.scrollHeight;
　　}
　　if(document.documentElement){
　　　　documentScrollHeight = document.documentElement.scrollHeight;
　　}
　　scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
　　return scrollHeight;
}

//浏览器视口的高度

function getWindowHeight(){
　　var windowHeight = 0;
　　if(document.compatMode == "CSS1Compat"){
　　　　windowHeight = document.documentElement.clientHeight;
　　}else{
　　　　windowHeight = document.body.clientHeight;
　　}
　　return windowHeight;
}

window.onscroll = function(){
　　if(getScrollTop() + getWindowHeight() == getScrollHeight()){
	 window.setTimeout("loadnews(maxsize);",500);　　　　
　　}
};