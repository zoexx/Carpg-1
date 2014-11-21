<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//得到用户信息
String name = request.getParameter("name");
String email = request.getParameter("email");
String psw = request.getParameter("password");
%>
<script type="text/javascript" src="../JS/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../JS/Address/Address.js"></script>
<script type="text/javascript" src="../JS/Address/ChooseAddress.js"></script>
<script type="text/javascript">
	//加载页面信息,主要是填入已经编写的信息，昵称，邮箱，密码
	function addInfo(){
		document.getElementById("name").value = "<%= name%>";
		document.getElementById("email").value = "<%= email%>";
		document.getElementById("password").value = "<%= psw%>";
	}
	function loadPro(){
		loadProvince('420115');
	}
	//window.onload事件
	function addLoadEvent(func){
		var oldonload = window.onload;
		if (typeof window.onload != "function"){
			window.onload = func;
		}else{
			window.onload = function(){
				oldonload();
				func();
			}
		}
	}
	//添加需要预加载的onload事件
	addLoadEvent(addInfo);
	addLoadEvent(loadPro);
</script>
<jsp:include page="../HTML/regist.html"></jsp:include>

