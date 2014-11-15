<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  
    <s:form action="userOperate" >                
              <s:textfield name="username" label=" 用户名"/>
              <s:textfield name="password"  label=" 密码" /> 
              <s:textfield name="type" id="type" value="login" />
              <s:property value="type"/>       
              <s:submit value="确定" onclick="show();"/>            
          </s:form>
  </body>
<script type="text/javascript" language="javascript">
function show(){
	var obj = document.getElementById("type");
	var a = obj.value;
	alert(a);
}
</script>
  
  
</html>
