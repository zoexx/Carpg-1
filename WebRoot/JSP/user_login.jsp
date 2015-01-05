<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../HTML/login_re.html"></jsp:include>

<script type="text/javascript" src="../JS/util_new.js" ></script>
<script type="text/javascript" src="../JS/user_login.js" ></script>

