//写入meta charset
function setmeta () {
	var ahead=document.getElementsByTagName("head");
	var ameta=document.createElement("meta");
	ameta.setAttribute("charset","utf-8");
	var bmeta=document.createElement("meta");
	bmeta.setAttribute("name","title");
	bmeta.setAttribute("content","车曝光");
	var cmeta=document.createElement("meta");
	cmeta.setAttribute("name","keywords");
	cmeta.setAttribute("content","车曝网,汽车,轿车,二手车,曝光,质量,驾驶安全,反馈,调查报告,数据分析,召回,拍卖,竞价,消费者权益,315,车");
	var dmeta=document.createElement("meta");
	dmeta.setAttribute("name","description");
	dmeta.setAttribute("content","车曝网是国内首家收集整理车主驾驶体验信息的完全公开完全开放的民间网站，车曝网为广大车主以及准车主提供大量汽车质量的数据分析服务以及二手车交易信息服务。");
	ahead[0].appendChild(ameta);
	ahead[0].appendChild(bmeta);
	ahead[0].appendChild(cmeta);
	ahead[0].appendChild(dmeta);
}