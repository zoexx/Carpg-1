//global
function addLoadEvent(func) {
  var oldonload = window.onload;
  if (typeof window.onload != 'function') {
    window.onload = func;
  } else {
    window.onload = function() {
      oldonload();
      func();
    }
  }
}

function insertAfter(newElement,targetElement) {
  var parent = targetElement.parentNode;
  if (parent.lastChild == targetElement) {
    parent.appendChild(newElement);
  } else {
    parent.insertBefore(newElement,targetElement.nextSibling);
  }
}

function addClass(element,value) {
  if (!element.className) {
    element.className = value;
  } else {
    newClassName = element.className;
    newClassName+= " ";
    newClassName+= value;
    element.className = newClassName;
  }
}

function highlightPage() {
  if (!document.getElementsByTagName) return false;
  if (!document.getElementById) return false;  
  var headers = document.getElementsByTagName('header');
  if (headers.length == 0) return false;
  var navs = headers[0].getElementsByTagName('nav');
  if (navs.length == 0) return false;
  
  var links = navs[0].getElementsByTagName("a");
  for (var i=0; i<links.length; i++) {
	  var linkurl;
	  for (var i=0; i<links.length; i++) {
	    linkurl = links[i].getAttribute("href");
	    if (window.location.href.indexOf(linkurl) != -1) {
	      links[i].className = "here";
	      var linktext = links[i].lastChild.nodeValue.toLowerCase();
	      document.body.setAttribute("id",linktext);
	    }
	  }
  }
}

//index.html
function addDate () {
	if (!document.getElementById) return false;
	var aaa=document.getElementById("current_time");
	var bbb=new Date;
	var year=bbb.getFullYear();
	var month=bbb.getMonth()+1;
	var day=bbb.getDate();
    var week='';
    switch (bbb.getDay()){
    	case 1:
    	week='一';
    		break;
    	case 2:
    	week='二';
    		break;
    	case 3:
    	week='三';
    		break;
    	case 4:
    	week='四';
    		break;
    	case 5:
    	week='五';
    		break;
    	case 6:
    	week='六';
    		break;
    	case 0:
    	week='日';
    		break;
    	default:
    		break;
    }
    aaa.innerHTML=year+'-'+month+'-'+day+' '+' 星期'+week;
}

addLoadEvent(addDate);

