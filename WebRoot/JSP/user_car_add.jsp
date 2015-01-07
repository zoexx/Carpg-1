<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<jsp:include page="../HTML/complain_addcar.html" ></jsp:include>
<script type="text/javascript">
	//验证判断
	function doCheck(){
		//将汽车品牌中的汉字和车型转化为汉字
		changeToBrand();
		document.getElementById("form").action="carOperate!addUserCar";
		document.getElementById("form").submit();
	}
	//将汽车品牌中的汉字和车型转化为汉字
	function changeToBrand(){
		var brand= document.getElementById("brand");
		var serial = document.getElementById("serial");
		//找到对应的汉字
		var b = brand.selectedOptions[0].innerHTML.split('-')[1];
		var s = serial.selectedOptions[0].innerHTML.replace('&nbsp;&nbsp;','');
		document.getElementById("brands").value = b;
		document.getElementById("car_type").value = s;
	}
//complain_addcar.html
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

</script>