<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<script type="text/javascript" src="../JS/ajax.js" />
<script type="text/javascript" src="../JS/util_new.js" />
<script type="text/javascript">
	function send(){
		if (document.getElementById("verify").value != ""){
			document.getElementById("login_reg").action="userOperate!returnPsw";
			document.getElementById("login_reg").submit();
		}else {alert("请输入验证码");}
		
	}
	//验证验证码的ajax, 用onlur操作触发
    function checkVerify(){
    	var v = document.getElementById("verify");
    	if (v!= ""){
    		send_request("GET","../servlet/AjaxServlet.sl?type=vcode&verify="+v.value,null,"text",showbackInfo_verify);
    	}
    }
    //验证验证码的回调
    function showbackInfo_verify(){
    	if (http_request.readyState == 4){
			if (http_request.status == 200) {
				var temp = http_request.responseText;
				if (temp == "fail"){
					//给出页面提示,并将验证码输入框置空，用于登陆验证判断，若为空则提示填写验证码
					alert("验证码输入错误");
					document.getElementById("verify").value = "";
				}
			}
		}
    }
	
	
</script>  
<jsp:include page="../HTML/login_findpsw.html"></jsp:include>