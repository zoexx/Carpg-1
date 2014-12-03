//通用类
function hasClass( elements,cName ){    
    return !!elements.className.match( new RegExp( "(\\s|^)" + cName + "(\\s|$)") );   
};    
function addClass( elements,cName ){    
    if( !hasClass( elements,cName ) ){    
        elements.className += " " + cName;    
    };    
};    
function removeClass( elements,cName ){    
    if( hasClass( elements,cName ) ){    
        elements.className = elements.className.replace( new RegExp( "(\\s|^)" + cName + "(\\s|$)" ), " " );  
    };    
}; 


//添加年限时间
function addcar_addtime (year,selectID) {
	var selectItem= document.getElementById(selectID);
	var currentdate=new Date();
	var currentYear=currentdate.getFullYear();
	for (i=0;i<year;i++) {
	var items=document.createElement("option");
	items.value=currentYear-i;
	items.innerHTML=currentYear-i;
	selectItem.appendChild(items);
	}
	
}

//漆色选择外框
function addcar_color (obj) {
	var carColors= document.getElementsByName("carColor");
	for (i=0;i<carColors.length;i++) {
		//将外面显示框全部取消
		removeClass(carColors[i],"carcolor_checked");
	}
	//根据传递的参数判断是哪个按钮，并且添加外围的显示框
		addClass(obj,"carcolor_checked");
	//给隐藏的color标签赋值
	    document.getElementById("color").value=obj.value;
	return false;
}
//添加车辆问题
function addproblem (opValue) {
	if (opValue=="none") {
		document.getElementById("add_problem_text").hidden=false;
	}else{
		document.getElementById("add_problem_text").hidden=true;
	}
}
//添加造成的事故
function golSelect (objID,objValue) {
	
	if(objValue){
		document.getElementById(objID).nextSibling.nextSibling.hidden=false;
	}else{
		document.getElementById(objID).nextSibling.nextSibling.hidden=true;
	}
}
//检查表单
function checkSelect (objID) {
	var objs=document.getElementById(objID);
	if(objs.value=="default") {
		objs.style.color="#FF0000";
		objs.style.border="1px solid #FF0000";
	}else{
		objs.style.color="#000000";
		objs.style.border="1px solid #ABADB3";
	}
}
function doCheck () {
	if (document.getElementById("type").value=="default") {
		alert("请填写问题部位")；
		return false;
	}
	if (document.getElementById("problem").value=="default") {
		alert("请添加问题描述")；
		return false;
	}
	if (document.getElementById("start_time").value=="") {
		alert("请选择发生时间")；
		//document.getElementById("start_time").style.border="1px solid #ABADB3";
		return false;
	}
	var objss=document.getElementsByName("course_detile");
	var toSub=document.getElementById("course");
	for (var i = 0; i < objss.length; i++) {
		if (objss.length[i].checked) {
			toSub.value=toSub.value+"~"+objss.length[i].nextSibling.value;
		}
	}
	if (document.getElementById("course_feel").value=="default") {
		alert("请选择故事感受")；
		return false;
	}
	if (document.getElementById("mark").value==null) {
		alert("您的详细经过将更有助于维护您的权益，请填写事件的详细经过")；
	}
	document.getElementById("form").action="";
	document.getElementById("form").submit();
}