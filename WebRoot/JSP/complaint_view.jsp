<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//得到action传递过来的抱怨信息,信息采用jsonArray的形式存储
	String msg = request.getParameter("msg");
	
	
 %>

<jsp:include page="header.jsp" flush="true"></jsp:include>
<jsp:include page="../HTML/view_complain.html"></jsp:include>
<jsp:include page="../HTML/footer.html"></jsp:include>
<script type="text/javascript">
var aJson = [
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"},
{ "time":"2014/12/23 12:24" , "user_name":"Gates" ,"frequency":"三天一次","course":"unknown","fee":"2000","image":["../images/img/example1.jpg","../images/img/example2.jpg"],"mark":"1234567890","car_brand":"奥迪","car_type":"Q5","mileage":"5000km","problem_type":"引擎","problem_problem":"引擎启动难","problem_detail":"满油发动机依然启动难"}
];
	var maxSize=2;//设置每次展示条数
	var msgCount=0;//单页消息计数器
	loadMassage(maxSize);
</script>