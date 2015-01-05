<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title>车曝光-投稿</title>
		<meta name="title" content="车曝网" />
		<meta name="keywords" content="车曝网,汽车,轿车,二手车,曝光,质量,驾驶安全,反馈,调查报告,数据分析,召回,拍卖,竞价,消费者权益,315,车"/>
		<meta name="description" content="车曝网是国内首家收集整理车主驾驶体验信息的完全公开完全开放的民间网站，车曝网为广大车主以及准车主提供大量汽车质量的数据分析服务以及二手车交易信息服务。" />
		<link rel="stylesheet" href="../CSS/new_layout.css" />
		<script src="../JS/calander.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript" src="../Ueditor/ueditor.config.js"></script>
		<script type="text/javascript" src="../Ueditor/ueditor.all.js"></script>
	    <script type="text/javascript" src="../JS/util.js" ></script>
<script type="text/javascript">
	function sendReport(){
		//先将UEditor编辑框中的内容取出
		var content = UE.getEditor('editor').getContent();
		document.getElementById('content').value = content;
		return true;
	}
</script>
	</head>
	<body>
<jsp:include page="header.jsp" flush="true" ></jsp:include>

<jsp:include page="/HTML/edit_news.html"></jsp:include>
		
<jsp:include page="/HTML/footer.html"></jsp:include>
	
	</body>
</html>
