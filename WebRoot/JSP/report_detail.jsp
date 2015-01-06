<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="java.net.URLDecoder" %>
<%
	String temp = request.getParameter("param");
	String param = URLDecoder.decode(URLDecoder.decode(temp, "utf-8"));
%>
<!DOCTYPE html>
<html>
	<head>
		<title>车曝光-调查和召回</title>
		<link rel="stylesheet" href="../CSS/new_layout.css" />
		<link rel="stylesheet" href="../CSS/color.css" />
	    <script type="text/javascript" src="../JS/util.js" ></script>
	    <script src="../JS/loadnews.js" type="text/javascript" charset="utf-8"></script>
	    <script src="../JS/setmeta.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		var news=<%= param%>;
		addLoadEvent(loadnewsDetail);
		addLoadEvent(setmeta);
		</script>
	</head>
	<body>
<jsp:include page="header.jsp" flush="true" ></jsp:include>
        <div  class="global_content">
			<div  class="index_rank right">
             <jsp:include page="/JSP/module_rank.jsp"></jsp:include>
             <jsp:include page="/HTML/right_news.html"></jsp:include>
	    	</div>
		
		    <div class="index_content left">
			 <jsp:include page="/HTML/left_newsDetail.html"></jsp:include>
		    </div>
		</div>
<jsp:include page="/HTML/footer.html"></jsp:include>
	
	</body>
</html>