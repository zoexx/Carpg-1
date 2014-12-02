<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<script language="javascript">
function setImage(obj){
    image.src = obj.value;
}
</script>
</head>
<body>
	<img id="image" name="image" src="" />
	<input type="file" name="file" onchange="setImage(this)"/>
</body>
</html>
