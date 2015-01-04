//主要是一些js工具类
//通用类
function hasClass( elements,cName ){    
    return !!elements.className.match( new RegExp( "(\\s|^)" + cName + "(\\s|$)") );   
};    
function addClass( elements,cName ){    
    if( !hasClass( elements,cName ) ){    
        elements.className += " " + cName;    
    };    
};    
function removeClass( elements,cName ){    
    if( hasClass( elements,cName ) ){    
        elements.className = elements.className.replace( new RegExp( "(\\s|^)" + cName + "(\\s|$)" ), " " );  
    };    
}; 
function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = func;
  } else {
    window.onload = function() {
      oldonload();
      func();
    }
  }
}

function insertAfter(newElement,targetElement) {
  var parent = targetElement.parentNode;
  if (parent.lastChild == targetElement) {
    parent.appendChild(newElement);
  } else {
    parent.insertBefore(newElement,targetElement.nextSibling);
  }
}

function highlightPage() {
  if (!document.getElementsByTagName) return false;
  if (!document.getElementById) return false;  
  var headers = document.getElementsByTagName('header');
  if (headers.length == 0) return false;
  var navs = headers[0].getElementsByTagName('nav');
  if (navs.length == 0) return false;
  
  var links = navs[0].getElementsByTagName("a");
  for (var i=0; i<links.length; i++) {
	  var linkurl;
	  for (var i=0; i<links.length; i++) {
	    linkurl = links[i].getAttribute("href");
	    if (window.location.href.indexOf(linkurl) != -1) {
	      links[i].className = "here";
	      var linktext = links[i].lastChild.nodeValue.toLowerCase();
	      document.body.setAttribute("id",linktext);
	    }
	  }
  }
}

//new_index.html
//更改banner图片
function indexBannerChange (thisID,tarID) {
	//解析thisID获得banner图片地址
	//更改tarID的背景图url
}
//complain_addcar.html
//添加年限时间
function addcar_addtime (year,selectID) {
	var selectItem= document.getElementById(selectID);
	var currentdate=new Date();
	var currentYear=currentdate.getFullYear();
	for (i=0;i<year;i++) {
	var items=document.createElement("option");
	items.value=currentYear-i;
	items.innerHTML=currentYear-i;
	selectItem.appendChild(items);
	}
	
}

//漆色选择外框
function addcar_color (obj) {
	var carColors= document.getElementsByName("carColor");
	for (i=0;i<carColors.length;i++) {
		//将外面显示框全部取消
		removeClass(carColors[i],"carcolor_checked");
	}
	//根据传递的参数判断是哪个按钮，并且添加外围的显示框
		addClass(obj,"carcolor_checked");
	//给隐藏的color标签赋值
	    document.getElementById("color").value=obj.value;
	return false;
}

//complain_addcomplain.html
//添加车辆问题
function addproblem (opValue) {
	if (opValue=="none") {
		document.getElementById("add_problem_text").hidden=false;
	}else{
		document.getElementById("add_problem_text").hidden=true;
	}
}
//添加造成的事故
function golSelect (objID,objValue) {
	
	if(objValue){
		document.getElementById(objID).nextSibling.nextSibling.hidden=false;
	}else{
		document.getElementById(objID).nextSibling.nextSibling.hidden=true;
	}
}
//检查表单
function checkSelect (objID) {
	var objs=document.getElementById(objID);
	if(objs.value=="default") {
		objs.style.color="#FF0000";
		objs.style.border="1px solid #FF0000";
	}else{
		objs.style.color="#000000";
		objs.style.border="1px solid #ABADB3";
	}
}
//控制iframe的显示与关闭
function onShowIframe (showHref) {
				document.getElementById("myiframe").src=""+showHref;								       
				document.getElementById("content_iframe").hidden=false;//iframe容器
				document.getElementById("overlay_mask").hidden=false;//遮罩层
				
 	    }
function closeIframe () {
				document.getElementById("content_iframe").hidden=true;				
				document.getElementById("overlay_mask").hidden=true;
		}
//设置iframe的大小
function setIframeSize(){
	if (document.getElementById("myiframe").readyState=="complete") {
				var ifm=document.getElementById("content_iframe");
				var a=document.getElementById("myiframe").contentWindow;
				var b=a.document.getElementById("iniframe");
				ifm.style.width==b.offsetWidth;				
				ifm.style.height=b.offsetHeight;
	}			
		}
//控制排行页面柱状图
function jakeChart () {
	var bjson=[
	{"name":"一汽大众","nub":501},
	{"name":"上海通用雪佛兰","nub":290},
	{"name":"上海大众","nub":280},
	{"name":"长安福特","nub":260},
	{"name":"上海通用福特","nub":230},
	{"name":"东风日产","nub":210},
	{"name":"东风悦达起亚","nub":160},
	{"name":"长城","nub":150},
	{"name":"东风雪铁龙","nub":140},
	{"name":"东风标致","nub":140},
	{"name":"北京现代","nub":140},
	{"name":"奇瑞汽车","nub":130},
	];
	showChartB(bjson);
}
function jakeChartProblem () {
	var bjson=[
	{"name":"汽车悬架","nub":701},
	{"name":"汽车外部配件","nub":180},
	{"name":"汽车内部配件","nub":100},
	{"name":"车体/油漆","nub":120},
	{"name":"刹车","nub":150},
	{"name":"离合器","nub":210},
	{"name":"冷却系统","nub":160},
	{"name":"动力传动系统","nub":150},
	{"name":"汽车电力系统","nub":140},
	{"name":"引擎","nub":140},
	{"name":"排气系统","nub":140},
	{"name":"能源系统","nub":130},
	{"name":"灯","nub":130},
	{"name":"安全带/安全气囊","nub":130},
	{"name":"空调制冷/加热","nub":130},
	{"name":"转向","nub":130},
	{"name":"变速器","nub":130},
	{"name":"车轮/轮毂","nub":130},
	{"name":"车窗/挡风玻璃","nub":130},
	];
	showChartB(bjson);
}
function showChartB (bjson) {
	Number.prototype.toPercent = function(n){n = n || 2;return ( Math.round( this * Math.pow( 10, n + 2 ) ) / Math.pow( 10, n ) ).toFixed( n ) + '%';}
	var rankBar=document.getElementById("rankBar");
	rankBar.style.width=60*bjson.length+"px";
	var sum=0;
	for (var i = 0; i < bjson.length; i++) {
		sum+=bjson[i].nub;		
	}
	for (var i = 0; i < bjson.length; i++) {
		var a=document.createElement("li");
		a.innerHTML=""+bjson[i].name;
		a.Alt=""+bjson[i].nub;
		var b=bjson[i].nub/sum+0.3;
		a.style.backgroundPositionY=""+b.toPercent();
		rankBar.appendChild(a);
	}
}
function postCar(obj){
	//表示选择车型进行提交
	if (obj.tagName.toString() == "INPUT"){
		var brand = document.getElementById("brand");
		if (brand.value == "-1"){
			alert("请选择要查找的车型");
			return false;
		}else {
			//找到对应的汉字
			var param = brand.selectedOptions[0].innerHTML.split('-')[1];
		}		
	}//表示直接点击链接提交
	else{
		var param = obj.firstChild.innerHTML;
	}
	//给参数赋值
	document.getElementById("param").value = param;
	document.getElementById("car_form").submit();
}
function setCar(value){
	
	document.getElementById("rankTitle").innerHTML=value+"问题榜";
}
		 	//显示用户登录状态
 	function showUser(username){
 		//var username="123";
 		if (username != ""){
 			document.getElementById("UserName").innerHTML=""+username;
 			document.getElementById("header_showUserName").hidden=false;
 		}else{
 			document.getElementById("header_log_re").hidden=false;
 			document.getElementById("header_showUserName").hidden=true;
 		}
 	}