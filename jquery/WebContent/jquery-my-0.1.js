window.jQuery = function(selector) {
	/*
	 * selector : .className , #content ,h1
	 */
	if( typeof  selector == 'string'){
	
	}else if(typeof selector =='function'){
		
		window.addEventListener('load',selector);
		
	}else if(typeof selector == 'object'){
	}
	
	var elementNodeList = document.querySelectorAll(selector);
	var elementNode = document.querySelector(selector);
	var jQueryWrapperObject = {
		'elementNodeList' : elementNodeList,
		'element' : elementNode,
		'css' : function(colorArg) {
			for (var i = 0; i < elementNodeList.length; i++) {
				this.elementNodeList.item(i).style.color = colorArg;
			}
			return this;
		},
		'text':function(txt){
			if(txt){
				for (var i = 0; i < elementNodeList.length; i++) {
					this.elementNodeList.item(i).firstChild.nodeValue=txt;
				}
			}else{
				return this.element.firstChild.nodeValue;
			}
			return this;
		}
	};
	return jQueryWrapperObject;
};
window.$ = window.jQuery;