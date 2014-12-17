<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript">
	function send(){
		document.getElementById("login_reg").action="userOperate!returnPsw";
		document.getElementById("login_reg").submit();
	}
	
</script>  
<jsp:include page="../HTML/login_findpsw.html"></jsp:include>