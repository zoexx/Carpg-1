<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../HTML/login_re.html"></jsp:include>

  <script type="text/javascript">
	function doCheck(obj){
		var temp = obj;
		//判断是否是登陆操作
		if (temp == "登陆"){
			document.getElementById("type").value = "login";
			
			var username = document.getElementById("email").value;
			var psw = document.getElementById("password").value;
			if (username=="" || psw == ""){
				alert("用户名或密码不能为空！");
			}
			else{
				document.getElementById("login_reg").action="userOperate";
				document.getElementById("login_reg").submit();
			}
		}
		else if (temp == "注册"){
			document.getElementById("type").value = "login";
			//验证注册信息的合法性
			var email = doucument.getElementById("email").value;
			var psw = document.getElementById("password").value;
			var name = document.getElementById("name").value;
			
			if (email=="" || psw=="" || name==""){
				alert("请保证注册的信息不为空");
			}else if(document.getElementById("check_email").value == "true"){
				//跳转到注册详细页面
				//window.location = url;
			}else{
				alert("改用户名不可用");
			}
		}else{alert("test");}
	}
	function check_email() {
    	var u = document.getElementById("email");
        if(u.value!="") {
            document.getElementById("feedback").innerHTML = "系统正在处理您的请求，请稍后。";
            send_request("GET","index.jsp?username="+u.value,null,"text",showFeedbackInfo);
        }
	}
	function showFeedbackInfo() {
    	if (http_request.readyState == 4) { // 判断对象状态
        	if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
            	document.getElementById("check_email").value = http_request.responseText;
        	} else { //页面不正常
            	alert("您所请求的页面有异常。");
        	}
        }
    }
  </script>
