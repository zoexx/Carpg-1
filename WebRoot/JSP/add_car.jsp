<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>
<script type="text/javascript" src="../JS/test/brand.js"> </script>
<script type="text/javascript" src="../JS/test/selectJs_20140324.js"> </script>
<script type="text/javascript" src="../JS/util.js"> </script>

<script type="text/javascript">
	//window.onload事件
	//添加载入品牌事件
	addLoadEvent(showBrand1);
	//验证判断
	function doCheck(){
		//将汽车品牌中的汉字和车型转化为汉字
		changeToBrand();
		document.getElementById("form").action="carOperate!addUserCar";
		document.getElementById("form").submit();
	}
	//将汽车品牌中的汉字和车型转化为汉字
	function changeToBrand(){
		var brand= document.getElementById("brand");
		var serial = document.getElementById("serial");
		//找到对应的汉字
		var b = brand.selectedOptions[0].innerHTML.split('-')[1];
		var s = serial.selectedOptions[0].innerHTML;
		document.getElementById("brands").value = b;
		document.getElementById("car_type").value = s;
	}


</script>
<jsp:include page="../HTML/complain_addcar.html" ></jsp:include>
