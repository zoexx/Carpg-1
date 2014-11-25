function addcar_addtime (year) {
	var selectItem= document.getElementById("sale_time");
	var currentdate=new Date();
	var currentYear=currentdate.getFullYear();
	for (i=0;i<year;i++) {
	var items=document.createElement("option");
	items.value=currentYear-i;
	items.innerHTML=currentYear-i;
	selectItem.appendChild(items);
	}
	
}
function addcar_color (obj) {
	var carColors= document.getElementsByName("carColor");
	alert(carColors.length);
	for (i=0;i<carColors.length;i++) {
		//将外面显示框全部取消
	}
	//根据传递的参数判断是哪个按钮，并且添加外围的显示框
	switch obj{
		case 1：
		break;
	}
	//给隐藏的color标签赋值
	return false;
}