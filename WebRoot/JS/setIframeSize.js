//控制iframe的显示与关闭
function onShowIframe (showHref) {
				document.getElementById("myiframe").src=""+showHref;								       
				document.getElementById("content_iframe").hidden=false;//iframe容器
				document.getElementById("overlay_mask").hidden=false;//遮罩层
				
 	    }
function closeIframe () {
				document.getElementById("content_iframe").hidden=true;				
				document.getElementById("overlay_mask").hidden=true;
		}
//设置iframe的大小
function setIframeSize(){
	if (document.getElementById("myiframe").readyState=="complete") {
				var ifm=document.getElementById("content_iframe");
				var a=document.getElementById("myiframe").contentWindow;
				var b=a.document.getElementById("iniframe");
				ifm.style.width==b.offsetWidth;				
				ifm.style.height=b.offsetHeight;
	}			
		}