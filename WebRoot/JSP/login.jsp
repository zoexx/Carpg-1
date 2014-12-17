<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="../HTML/login_re.html"></jsp:include>

<script type="text/javascript" src="../JS/jquery-1.7.2.min.js" ></script>
<script type="text/javascript" src="../JS/ajax.js" ></script>
  <script type="text/javascript">
  	//验证邮箱的合法性
  function check_format(){
    var mail = document.getElementById("email").value;
    //对电子邮件的验证
    var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    if(!myreg.test(mail)){
      alert("请输入正确的邮箱!");
      return false;
    }
  }
	function doCheck(obj){
		var temp = obj;
		//判断是否是登陆操作
		if (temp == "登陆"){
			document.getElementById("type").value = "login";
			
			var username = document.getElementById("email").value;
			var psw = document.getElementById("password").value;
			if (username=="" || psw == ""){
				alert("用户名或密码不能为空！");
				return false;
			}
			else{
				//登陆用ajax判断
				checkLogin();
				
			}
		}
		else if (temp == "注册"){
			document.getElementById("type").value = "login_re";
			//验证注册信息的合法性
			var email = document.getElementById("email").value;
			var psw1 = document.getElementById("password").value;
			var name = document.getElementById("name").value;
			if (email=="" || psw1=="" || name==""){
				alert("请保证注册的信息不为空");
				return false;
			}else{
				checkEmail();
			}
		}else{alert("test");}
		return false;
	}
	//登陆的ajax
	function checkLogin() {
		var v = document.getElementById("email").value;
		var p = document.getElementById("password").value;
		send_request("GET","../servlet/AjaxServlet.sl?type=login&username="+v+"&password="+p, null, "text", showBack);
	}//登陆的ajax回调
	function showBack(){
		if (http_request.readyState == 4){
			if (http_request.status == 200) {
				var temp = http_request.responseText;
				if (temp == "success"){
					//登陆成功跳转
					document.getElementById("login_reg").action="userOperate!login";
				    document.getElementById("login_reg").submit();
				}else if (temp == "fail"){
					//给出页面提示
					document.getElementById("email").value = "登陆失败, 用户名或密码错误";
				}
			}
		}
	}//验证邮箱的唯一性的ajax
	function checkEmail() {
		check_format();
    	var u = document.getElementById("email");
        if(u.value!="") {
            //document.getElementById("feedback").innerHTML = "系统正在处理您的请求，请稍后。";
            send_request("GET","../servlet/AjaxServlet.sl?type=username&username="+u.value,null,"text",showFeedbackInfo);
        }
	}//验证邮箱的唯一性的ajax的回调
	function showFeedbackInfo() {
    	if (http_request.readyState == 4) { // 判断对象状态
        	if (http_request.status == 200) { // 信息已经成功返回，开始处理信息
            	document.getElementById("check_email").value = http_request.responseText;
            	if (document.getElementById("check_email").value == "fail"){
            		document.getElementById("email").value = "该邮箱已经被注册";
            		return false;
            	}
            	else if (document.getElementById("check_email").value == "success"){
            		//跳转到注册详细页面
					document.getElementById("login_reg").action="userOperate!loginRe";
				    document.getElementById("login_reg").submit();
            	}
        	} else { //页面不正常
            	alert("您所请求的页面有异常。");
            	return false;
        	}
        }
    }
  </script>
