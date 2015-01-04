<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="header.jsp" flush="true" ></jsp:include>
<jsp:include page="../HTML/edit_news.html"></jsp:include>
<jsp:include page="/HTML/footer.html"></jsp:include>

<script type="text/javascript">
	function sendReport(){
		//先将UEditor编辑框中的内容取出
		var content = UE.getEditor('editor').getContent();
		document.getElementById('content').value = content;
		return true;
	}
</script>

