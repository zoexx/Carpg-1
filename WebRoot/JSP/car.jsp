<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	
%>
<script type="text/javascript">
	//将汽车品牌中的汉字和车型转化为汉字
	function changeToBrand(){
		var brand = document.getElementById("brand");
		var serial = document.getElementById("serial");
		//找到对应的汉字
		var b = brand.selectedOptions[0].innerHTML.split('-')[1];
		var s = serial.selectedOptions[0].innerHTML.split('-')[1];
		brand.value = b;
		serial.value = s;
	}


</script>
