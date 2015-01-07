<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	//得到action传递过来的抱怨信息,信息采用jsonArray的形式存储
	String msg = (String)request.getAttribute("msg");
	
	
 %>
<!DOCTYPE html>
<html>
	<head>
		<title>车曝光-查看吐槽</title>
		<link rel="stylesheet" href="../CSS/new_layout.css" />
		<link rel="stylesheet" href="../CSS/color.css" />
		<script type="text/javascript" src="../JS/external/brand.js"></script>
		<script type="text/javascript" src="../JS/external/brand_select.js"></script>
	    <script type="text/javascript" src="../JS/util.js" ></script>
	    <script src="../JS/loadmsg.js" type="text/javascript" charset="utf-8"></script>
	    <script src="../JS/setmeta.js" type="text/javascript" charset="utf-8"></script>
	    <script type="text/javascript">
        addLoadEvent(setmeta);//设置meta内容
	    </script>
	</head>
	<body>
<jsp:include page="/JSP/module_header.jsp" flush="true" ></jsp:include>
<jsp:include page="/HTML/view_complain.html"></jsp:include>
<jsp:include page="/HTML/footer.html"></jsp:include>
<script type="text/javascript">
/*
var aJson = [
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"}
]; */
	var msgJson = <%= msg %>;
	var maxsize=2;//设置每次展示条数
	var msgCount=0;//单页消息计数器
	var msgType="complain";//设置展示模式，新闻or吐槽
	loadmessage(maxsize);
</script>
	</body>
</html>