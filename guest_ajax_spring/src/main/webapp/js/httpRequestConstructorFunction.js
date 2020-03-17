function AjaxRequest(url,params,callback,method,async){
	this.xhr=null;
	this.url=url;
	this.params=params;
	this.callback=callback;
	this.method=method;
	this.async=async;
	this.sendRequest();
}
AjaxRequest.prototype={
		'getXMLHttpRequest':function(){
			if(window.XMLHttpRequest){
				return new XMLHttpRequest();
			}else{
				return null;
			}
		},
		'sendRequest':function(){
			this.xhr = this.getXMLHttpRequest();
			var httpMethod = this.method ? this.method : 'GET';
			if (httpMethod != 'GET' && httpMethod != 'POST') {
				httpMethod = 'GET';
			}
			var httpParams = (this.params == null || this.params == '') ? null : this.params;
			var httpUrl = this.url;
			if (httpMethod == 'GET' && httpParams != null) {
				httpUrl = httpUrl + "?" + httpParams;
			}
			var ajaxRequest = this;
			this.xhr.onreadystatechange = function(){
				
				if(this.readyState==4){
					ajaxRequest.callback(this,this.responseText);
				}
			};
			
			if(this.async==undefined){
				this.async==true;
			}
			this.xhr.open(httpMethod, httpUrl, this.async);
			this.xhr.setRequestHeader(
				'Content-Type', 'application/x-www-form-urlencoded');
			this.xhr.send(httpMethod == 'POST' ? httpParams : null);
		}
};

