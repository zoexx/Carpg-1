//jQuery封装的ajax

//验证用户名（邮箱)是否存在
function check_username(){
	var u = document.getElementById("email");
	var check_username = $.ajax({
		type:'get',
		url:'../servlet/AjaxServlet.sl?type=username&username='+u.value,
		data:'',
		timeout:2000,
		cache:false,
		async: false, 
		dataType:'text',
		success:function(msg){
			//服务器段返回成功消息
			if (msg == "success"){
				//跳转到注册详细页面
				document.getElementById("login_reg").action="userOperate!loginRe";
				document.getElementById("login_reg").submit();
				return true;
			}else if (msg == "fail"){
				alert("该邮箱已经被注册");
				return false;
			}
		},
		error:function(){
			alert("获取信息失败");
		},
		complete : function(XMLHttpRequest,status){ //请求完成后最终执行参数
　　　　　  if(status=='timeout'){//超时,status还有success,error等值的情况
　　　　　  	alert("请求超时");
　　　　　  }
　　　　}
	}) ;
}

//验证验证码
function check_verify(){
	var v = document.getElementById("verify");
	var check_verify = $.ajax({
		type:'get',
		url:'../servlet/AjaxServlet.sl?type=vcode&verify='+v.value,
		data:'',
		timeout:2000,
		cache:false,
		async: false, 
		dataType:'text',
		success:function(msg){
			//服务器段返回成功消息
			if (msg == "success"){
				return true;
			}else if (msg == "fail"){
				alert("验证码输入错误");
				v.value = "";
				return false;
			}
		},
		error:function(){
			alert("获取信息失败");
		},
		complete : function(XMLHttpRequest,status){ //请求完成后最终执行参数
　　　　　  if(status=='timeout'){//超时,status还有success,error等值的情况
　　　　　  	alert("请求超时");
　　　　　  }
　　　　}
	}) ;
}

//ajax登陆
function check_login(){
	var v = document.getElementById("email").value;
	var p = document.getElementById("password").value;
	var code = document.getElementById("verify").value;
	var check_login = $.ajax({
		type:'get',
		url:'../servlet/AjaxServlet.sl?type=login&username='+v+'&password='+p+'&verify='+code,
		data:'',
		timeout:2000,
		cache:false,
		async: false,
		dataType:'text',
		success:function(msg){
			//服务器段返回成功消息
			if (msg == "success"){
				//登陆成功跳转
				document.getElementById("login_reg").action="userOperate!login";
				document.getElementById("login_reg").submit();
				parent.location.reload();
				return true;
			}else if (msg == "fail"){
				alert("用户名或密码输入错误");
				return false;
			}
		},
		error:function(){
			alert("获取信息失败");
			return;
		},
		complete : function(XMLHttpRequest,status){ //请求完成后最终执行参数
　　　　　  if(status=='timeout'){//超时,status还有success,error等值的情况
　　　　　  	alert("请求超时");
　　　　　  }
　　　　}
	}) ;
}