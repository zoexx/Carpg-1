<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//得到action传递过来的抱怨信息,信息采用jsonArray的形式存储
	String msg = request.getParameter("msg");
	
	
 %>
<script type="text/javascript">
    //第一次载入时给后端-1
    //加载更多 最后一条id
	var cjson = "<%= msg %>";
    addLoadEvent(loadMassage(2));
</script>
<jsp:include page="header.jsp" flush="true"></jsp:include>
<jsp:include page="../HTML/view_complain.html"></jsp:include>
<jsp:include page="../HTML/footer.html"></jsp:include>
