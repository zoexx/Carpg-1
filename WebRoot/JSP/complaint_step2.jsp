<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//得到返回的用户车列表信息
	String msg = (String)request.getSession().getAttribute("user_carinfo");
	//String[] carinfo = msg.split("~");
	
	
 %>
 <script type="text/javascript" src="../JS/util.js"></script>
 <script type="text/javascript">
 	//将用户车的信息载入到汽车选择列表
 	function loadCar(){
 		var selectCar = document.getElementById("select_cars");
 		var str = "<%= msg %>";
 		var strTemp = new Array();
 		strTemp = str.split("~");
 		for(var i=0; i< strTemp.length-1; i++){
 			var temp = strTemp[i];
 			var tempStr = temp.split(",");
 			var opt = new Option(tempStr[1]+"--"+tempStr[2], temp);
 			selectCar.appendChild(opt);
 		}
 	}
 	addLoadEvent(loadCar);
 	//进行下一步的提交事件
 	function doCheck(){
 		//验证下拉列表框的选择情况
 		if (document.getElementById("select_cars").value == "nodefault"){
 			alert("请选择一辆吐槽的车辆");
 			return false;
 		}else {
 			document.getElementById("form").action = "complaintOperate!complaintStep2";
 			document.getElementById("form").submit();
 			return true;
 		}
 	}
 </script>
<jsp:include page="/HTML/complain1.html" ></jsp:include>
