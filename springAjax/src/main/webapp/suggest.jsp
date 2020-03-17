<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/plain; charset=euc-kr"%>
<%@ page import="java.util.List"%>
<%!	
	String[] keywords = {"AJAX","AJAX 실전 프로그래밍","ASSARA",
						"AIM","ASURA","AAA",
						"AJA","AZERA","자라자",
						"자라","자바 프로그래밍",
			   			"자바 서버 페이지","자바스터디",
			   			"자바서비스","자바캔","자요",
			   			"자동차","자아라"};
	public List<String> search(String keyword) {
		if (keyword == null || keyword.equals("")) 
			return new ArrayList<String>();
		keyword = keyword.toUpperCase();
		List<String> result = new java.util.ArrayList<String>(8);
		for ( int i = 0 ; i < keywords.length ; i++ ) {
			if (((String)keywords[i]).startsWith(keyword)) {
				result.add(keywords[i]);
			}
		}
		return result;
	}
%>
<%	request.setCharacterEncoding("utf-8");
	String keyword = request.getParameter("keyword");
	List keywordList = this.search(keyword);
	out.print(keywordList.size());
	out.print("|");
	for (int i = 0 ; i < keywordList.size() ; i++) {
		String key = (String)keywordList.get(i);
		out.print(key);
		if (i < keywordList.size() - 1) {
			out.print(",");
		}
	}
%>

