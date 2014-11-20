<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'regist.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=gbk" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="JS/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="JS/ajax.js"></script>
    <script type="text/javascript" src="JS/Address/Address.js"></script>
    <script type="text/javascript" src="JS/Address/ChooseAddress.js"></script>

<SCRIPT LANGUAGE="JavaScript">
function doCheck() {
    var u = document.getElementById("username");
        if(u.value!="") {
            document.getElementById("feedback").innerHTML = "系统正在处理您的请求，请稍后。";
            send_request("GET","index.jsp?username="+u.value,null,"text",showFeedbackInfo);
        }
        else {
            document.getElementById("feedback").innerHTML = "请输入用户名称。";
        }
}
function showFeedbackInfo() {
    if (http_request.readyState == 4) { // 判断对象状态
        if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
            document.getElementById("feedback").innerHTML = http_request.responseText;
        } else { //页面不正常
            alert("您所请求的页面有异常。");
        }
    }
}
</SCRIPT>	
  </head>
  
  <body>
    用户注册<br>
    <span id="feedback">测试ajax</span>
    <s:form action="userOperate">
    	<s:textfield name="name" id="name" label=" 用户名" onblur="doCheck();" />
        <s:password name="password"  label=" 密码" />
        <s:password name="password1"  label=" 确认密码" />  
        <s:select name="province" id="id_provSelect" list="{}" label="省" onChange="loadCity(this.value);" />
        <s:select name="city" id="id_citySelect" list="{}"label="市" onChange="loadArea(this.value);" />
        <s:select name="section" id="id_areaSelect" list="{}" label="区"/>
        <script type="text/javascript">loadProvince('420115');</script>
        <s:textfield name="email" label=" 邮箱" />
        <s:textfield name="tel" label=" 电话" />
        <s:hidden name="type" value="regist" />
        <s:submit value="确定" />
    </s:form>
  </body>
</html>
