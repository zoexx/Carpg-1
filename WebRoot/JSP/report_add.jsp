<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="/Carpg/Ueditor/ueditor.config.js"></script>
<script type="text/javascript" src="/Carpg/Ueditor/ueditor.all.js"></script>

<html>
<body>
	<div>
    <h1>完整demo</h1>
    <script id="editor" type="text/plain" style="width:1024px;height:500px;"></script>
</div>
</body>
</html>

<script type="text/javascript">
	var ue = UE.getEditor('editor');
</script>

