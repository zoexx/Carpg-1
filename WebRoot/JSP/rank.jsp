<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="java.net.URLDecoder" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%

	String param = request.getParameter("param");
	String deString = URLDecoder.decode(URLDecoder.decode(param, "utf-8"));
%>
<jsp:include page="header.jsp" flush="true" ></jsp:include>
<jsp:include page="../HTML/view_rank_total.html" ></jsp:include>
<jsp:include page="../HTML/footer.html" ></jsp:include>

<script type="text/javascript">
	var carTitle='<%= deString %>';
	setCar(carTitle);
	jakeChartProblem();	
</script>