var xhr=null;
function getXMLHttpRequest() {
	if(window.XMLHttpRequest){
		return new XMLHttpRequest();
	}else{
		return null;
	}
}
function sendRequest(url, params, callback, method, async) {
	
	xhr = getXMLHttpRequest();
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = httpUrl + "?" + httpParams;
	}
	if(async==undefined){
		async=true;
	} 
	xhr.onreadystatechange = callback;
	xhr.open(httpMethod, httpUrl, async);
	xhr.setRequestHeader(
		'Content-Type', 'application/x-www-form-urlencoded');
	xhr.send(httpMethod == 'POST' ? httpParams : null);
}
