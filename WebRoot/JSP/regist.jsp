<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../HTML/regist.html"></jsp:include>
<script type="text/javascript" src="../JS/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="../JS/Address/Address.js"></script>
<script type="text/javascript" src="../JS/Address/ChooseAddress.js"></script>
