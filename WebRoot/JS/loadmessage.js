//评论展示页面展示消息
function loadMassage (maxsize) {
		for (var i = 0; i < maxsize; i++) {
			if (msgCount==aJson.length-1) {
				//隐藏“加载更多”
				document.getElementById("view_mainComplains_more").hidden=true;
				break;
			}else{
				showMessage();
				msgCount++;
			}					
		}		 
	}
function showMessage () {
	//整条评论的容器
			var view_mainComplains=document.createElement("div");
			view_mainComplains.className="view_mainComplains view_complainBorder";
			//user信息容器
			var avatar=document.createElement("div");
			avatar.className="avatar";
			var avatarPic=document.createElement("img");//用户头像
			//if (aJson[i].img!="") {
				//avatarPic.src=""+aJson[i].img;
			//}else{
				avatarPic.src="../images/img/avatar.png";//默认用户头像
			//}
			avatarPic.className="avatarPic";
			var avatarName=document.createElement("p");
			avatarName.className="avatarName";
			if (aJson[msgCount].user_name!="") {
				var timeinfo=aJson[msgCount].time.split(" ");		       
				avatarName.innerHTML="<b>"+aJson[msgCount].user_name+"</b><br/>"+timeinfo[1]+"<br/>"+timeinfo[0];
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
			view_complainTitle.innerHTML=""+aJson[msgCount].car_brand+aJson[msgCount].car_type+aJson[msgCount].problem_detail;
			view_complainContent.appendChild(view_complainTitle);
			//问题标签
			var view_complainTips=document.createElement("ul");
			view_complainTips.className="view_complainTips";
			var tips=[aJson[msgCount].problem_type,aJson[msgCount].problem_problem,aJson[msgCount].mileage,aJson[msgCount].frequency];
			for (var n = 0; n <tips.length ; n++) {
				var a=document.createElement("li");
				a.innerHTML=""+tips[n];
				view_complainTips.appendChild(a);
			}
			view_complainContent.appendChild(view_complainTips);
			//吐槽内容
			var view_complainText=document.createElement("p");
			view_complainText.className="view_complainText";
			view_complainText.innerHTML=""+aJson[msgCount].mark;
			view_complainContent.appendChild(view_complainText);
			//图片列表
			var view_complainPhoto=document.createElement("ul");
			view_complainPhoto.className="view_complainPhoto";
			for (var j = 0; j < aJson[msgCount].image.length; j++) {
				var a=document.createElement("li");
				var b=document.createElement("img");
			    b.src=""+aJson[msgCount].image[j];
			    a.appendChild(b);
			    view_complainPhoto.appendChild(a);
			}
			view_complainContent.appendChild(view_complainPhoto);
			//功能按键列表
			var view_complainAction=document.createElement("ul");
			view_complainAction.className="view_complainAction";
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
//拼在jsp中时需加上$footer.height
window.onscroll = function(){
　　if(getScrollTop() + getWindowHeight() == getScrollHeight()){
	 window.setTimeout("loadMassage(maxSize);",500);　　　　
　　}
};