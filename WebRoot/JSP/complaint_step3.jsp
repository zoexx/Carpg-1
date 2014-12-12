<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//得到上一个页面传到的车辆信息
	//String msg = request.getParameter("msg");
 %>
<script type="text/javascript">
function doCheck () {
	if (document.getElementById("type").value=="default") {
		alert("请填写问题部位");
		return false;
	}
	if (document.getElementById("problem").value=="default") {
		alert("请添加问题描述");
		return false;
	}
	if (document.getElementById("start_time").value=="") {
		alert("请选择发生时间");
		//document.getElementById("start_time").style.border="1px solid #ABADB3";
		return false;
	}
	var objss=document.getElementsByName("course_detile");
	var toSub=document.getElementById("course");
	for (var i = 0; i < objss.length; i++) {
		if (objss[i].checked) {
			toSub.value=toSub.value+"~"+objss[i].nextSibling.value;
		}
	}
	if (document.getElementById("course_feel").value=="default") {
		alert("请选择故事感受");
		return false;
	}
	if (document.getElementById("mark").value==null) {
		alert("您的详细经过将更有助于维护您的权益，请填写事件的详细经过");
		return false;
	}
	document.getElementById("form").action="complaintOperate";
	document.getElementById("form").submit();
}
</script>
<jsp:include page="../HTML/complain_addcomplain.html" ></jsp:include>
