

function loadnews (maxsize) {
	//maxsize设置每页展示新闻条数
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
	ali.onclick=function (this){
	var str=JSON.stringify(newsJson[obj.value]);
	alert(str);
	window.location.href=""+encodeURI(encodeURI('news_detail.jsp?param='+str));
}
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
