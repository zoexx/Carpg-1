<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
</head>
<body>
	<form action="servlet/FileServlet.sl" method="post"
                        enctype="multipart/form-data" >
<input type="file" name="file" />
<br />
<input type="submit" value="Upload File" />
</form>
</body>
</html>
