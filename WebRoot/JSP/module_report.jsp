<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	//获取首页新闻模块的数据（5条）
	String msgReport = (String)request.getAttribute("msgReport");
%>
<script type="text/javascript">
var newsPreJson1=<%= msgReport%>;
var newsPreJson2=<%= msgReport%>;
function addnewsPre(objID,mjson){
    var aul=document.getElementById(objID);
    var lis=aul.getElementsByTagName("li");
    for (var i=0;i<lis.length;i++){
    if(mjson[i]){
    var atime = mjson[i].time.split("-");
    var mtime = atime[1]+"-"+atime[2];

    //给span赋值
    lis[i].children[0].innerText=mtime;
    //给a赋值
    lis[i].children[1].innerText=mjson[i].title;
    //给a加href
	var str=JSON.stringify(mjson[i]);
	str = str.replace(/\//g, "\\\/");
	str = str.replace(/\&/g, "\\\&");
	str = str.replace(/\?/g, "\\\?");
	lis[i].children[1].href=""+encodeURI(encodeURI('report_detail.jsp?param='+str));    
    }
    }
}
function loadnewsPre(){
addnewsPre("newsPre1",newsPreJson1);
addnewsPre("newsPre2",newsPreJson2);

}
addLoadEvent(loadnewsPre);

</script>
<jsp:include page="/HTML/right_news.html"></jsp:include>