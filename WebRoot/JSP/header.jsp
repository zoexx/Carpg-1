<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String user = (String)request.getSession().getAttribute("user");
	//定义变量保存登陆用户的信息
	String loginUsername = ""; 
	if (null != user && !user.equals("")){
		String[] temp = user.split("~");
		loginUsername = temp[2];	
	}
 %>
 <script src="../JS/util.js" type="text/javascript" charset="utf-8"></script>
 <script type="text/javascript">
 	//显示用户登录状态
 	function showUser(){
 		var username = "<% =loginUsername%>";
 		if (username != ""){
 			document.getElementById("")
 		}
 	}
 	addLoadEvent(showUser);
 </script>
<jsp:include page="../HTML/header.html"></jsp:include>
