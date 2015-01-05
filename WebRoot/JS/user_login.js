//user_login.jsp页面的js脚本,前端页面的引用要放在</body>之后
	
	//引入外部的js
	new_element=document.createElement("script");
 	new_element.setAttribute("type","text/javascript");
	new_element.setAttribute("src","../JS/ajax.js");// 在这里引入了ajax.js
 	document.body.appendChild(new_element)
	//表单提交前的判断
	function doCheck(obj){
		var temp = obj;
		var code = document.getElementById("verify").value;
		//判断是否是登陆操作
		if (temp == "登陆"){
			document.getElementById("type").value = "login";
			
			var username = document.getElementById("email").value;
			var psw = document.getElementById("password").value;
			if (username=="" || psw == "" || code == ""){
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
			if (email=="" || psw1=="" || name=="" || code==""){
				alert("请保证注册的信息不为空");
				return false;
			}else{
				checkEmail();
			}
		}else{alert("test");}
	}
	//登陆的ajax
	function checkLogin() {
		var v = document.getElementById("email").value;
		var p = document.getElementById("password").value;
		var code = document.getElementById("verify").value;
		send_request("GET","../servlet/AjaxServlet.sl?type=login&username="+v+"&password="+p+"&verify="+code, null, "text", showBack);
	}//登陆的ajax回调
	function showBack(){
		if (http_request.readyState == 4){
			if (http_request.status == 200) {
				var temp = http_request.responseText;
				if (temp == "success"){
					//登陆成功跳转
					document.getElementById("login_reg").action="userOperate!login";
				    document.getElementById("login_reg").submit();
				    parent.location.reload();
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