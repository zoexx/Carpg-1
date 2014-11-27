//主要是一些js工具类
//window.onload事件
	function addLoadEvent(func){
		var oldonload = window.onload;
		if (typeof window.onload != "function"){
			window.onload = func;
		}else{
			window.onload = function(){
				oldonload();
				func();
			}
		}
	}