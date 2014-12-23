<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//得到action传递过来的抱怨信息,信息采用jsonArray的形式存储
	String msg = request.getParameter("msg");
	
	
 %>
<script type="text/javascript">
    //第一次载入时给后端-1
    //加载更多 最后一条id
	var aJson = "<%= msg %>";
	var maxSize=5;//设置每次展示条数
	var msgCount=0;//设置计数器控制“加载更多”
    addLoadEvent(loadJson(maxSize,msgCount));
    function loadJson (maxsize,msgcount) {
		//把json拆开
		
		
		//填充
		
	}
	
	function loadMassage (maxsize,bjson) {
		
		//创建n个评论信息容器		
		createComplainContent(n);
		//循环填充
		for (var i = 0; i < n; i++) {
		//公共变量用来获取当前id
		var currentID=new String();
		//img src用户头像
		currentID="avatarPic"+i;
		document.getElementById(currentID).src=""+imgs;
		//用户名称 时间 日期
		var timeinfo=ctime.split(" ");
		var cDate=timeinfo[0];
		var cTime=timeinfo[1];		
		currentID="avatarName"+i;
		document.getElementById(currentID).innerHTML="<b>"+userName+"</b><br/>"+cTime+"<br/>"+cDate;
		//标题
		currentID="view_complainTitle"+i;
		document.getElementById(currentID).innerHTML="["+ctitle+"]";
		//问题标签		
		var ctips=['上海通用雪佛兰','发动机','迈锐宝','黄石市','2012/10/18购入','黄石三环瑞通汽车销售服务有限公司(雪佛兰4S店)'];
		currentID="view_complainTips"+i;
		for (var a = 0; a < ctips.length; a++) {
			var cli=document.createElement("li");
			cli.innerHTML=""+ctips[a];
			document.getElementById(currentID).appendChild(cli);
		}
		//正文
		var ctext="1234561234561234561345613456123456";
		currentID="view_complainText"+i;
		document.getElementById(currentID).innerHTML=""+ctext;
		//图片
		var cpics=['../images/img/example1.jpg','../images/img/example1.jpg'];
		currentID="view_complainPhoto"+i;
		for (var j = 0; j < cpics.length; j++) {
			var clii=document.createElement("li");
			var cimg=document.createElement("img");
			cimg.src=""+cpics[j];
			clii.appendChild(cimg);
			document.getElementById(currentID).appendChild(clii);
		}
		//显示收藏，转发，赞等数量
		//给按钮添加href 或者事件
		
		for (var c = 0; c < 4; c++) {
			currentID="actionBtn"+i+""+c;
			document.getElementById(currentID).href="";
		}
		//添加到。。。
		currentID="complainContent"+i;
		
		}
		//分步显示
		
	}
	
	//创建评论框架
	function createComplainContent (maxsize) {
		for (var i = 0; i < maxsize; i++) {
			//整条评论的容器
			var view_mainComplains=document.createElement("div");
			view_mainComplains.className="view_mainComplains view_complainBorder";
			//user信息容器
			var avatar=document.createElement("div");
			avatar.className="avatar";
			var avatarPic=document.createElement("img");//用户头像
			//if (cjson[i].img!="") {
				//avatarPic.src=""+cjson[i].img;
			//}else{
				avatarPic.src="../images/img/avatar.png";//默认用户头像
			//}
			avatarPic.className="avatarPic";
			var avatarName=document.createElement("p");
			avatarName.className="avatarName";
			if (cjson[i].user_name!="") {
				var timeinfo=cjson.time.split(" ");		       
				avatarName.innerHTML="<b>"+userName+"</b><br/>"+timeinfo[1]+"<br/>"+timeinfo[0];
				}else{
				avatarName.innerHTML="<b>"+"车曝网友"+"</b><br/>"+timeinfo[1]+"<br/>"+timeinfo[0];					
				}
			avatar.appendChild(avatarPic);
			avatar.appendChild(avatarName);
			view_mainComplains.appendChild(avatar);
			//吐槽信息容器
			var view_complainContent=document.createElement("div");
			view_complainContent.className="view_complainContent";
			//吐槽标题
			var view_complainTitle=document.createElement("h4");
			view_complainTitle.className="view_complainTitle";		
			view_complainContent.appendChild(view_complainTitle);
			//问题标签
			var view_complainTips=document.createElement("ul");
			view_complainTips.className="view_complainTips";
			view_complainContent.appendChild(view_complainTips);
			//吐槽内容
			var view_complainText=document.createElement("p");
			view_complainText.className="view_complainText";
			view_complainContent.appendChild(view_complainText);
			//图片列表
			var view_complainPhoto=document.createElement("ul");
			view_complainPhoto.className="view_complainPhoto";
			view_complainContent.appendChild(view_complainPhoto);
			//功能按键列表
			var view_complainAction=document.createElement("ul");
			addSameIdClass(view_complainAction,"view_complainAction",i);
			var actiontext=['收藏','评论','转发','赞'];
			for (var b = 0; b < actiontext.length; b++) {
				var acli=document.createElement("li");				
				var actionBtn=document.createElement("a");
				actionBtn.id="actionBtn"+i+""+b;
				actionBtn.className="actionBtn";
				actionBtn.innerHTML=""+actiontext[b];
				acli.appendChild(actionBtn);
				view_complainAction.appendChild(acli);
			}
			view_complainContent.appendChild(view_complainAction);
			view_mainComplains.appendChild(view_complainContent);
			//添加到吐槽显示区
			document.getElementById("add_ccshere").appendChild(view_mainComplains);
			
		}
		 
	}
</script>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<jsp:include page="../HTML/view_complain.html"></jsp:include>
<jsp:include page="../HTML/footer.html"></jsp:include>
