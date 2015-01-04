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
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>车曝光-促进车辆质量提升</title>
		<link rel="stylesheet" href="../CSS/new_layout.css" />
		<link rel="stylesheet" href="../CSS/color.css" />
		<script type="text/javascript" src="../JS/test/brand.js"></script>
		<script type="text/javascript" src="../JS/test/selectJs_20140324.js"></script>
		<script src="../JS/util.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">

 	function aaa () {
 		var username = "<%= loginUsername%>";
 		showUser(username);
 	}
 	    addLoadEvent(aaa);
        </script>
	</head>
	<body>
<jsp:include file="/HTML/header.html" ></jsp:include>
        <div  class="global_content">
			<div  class="index_rank right">
             <jsp:include file="../HTML/right_rank.html"></jsp:include>
             <jsp:include file="../HTML/right_news.html"></jsp:include>
	    	</div>
		
		    <div class="index_content left">
			 <jsp:include file="../HTML/left_index.html"></jsp:include>
		    </div>
		</div>
<jsp:include file="/HTML/footer.html"></jsp:include>
	
	</body>
</html>
