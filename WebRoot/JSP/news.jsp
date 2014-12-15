<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<jsp:include page="header.jsp" flush="true"></jsp:include>
<jsp:include page="../HTML/view_news.html"></jsp:include>
<jsp:include page="../HTML/footer.html"></jsp:include>

