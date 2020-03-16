<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%
	try {
		String apiURL="http://www.chosun.com/site/data/rss/ent.xml";
		//String apiURL="http://api.flickr.com/services/feeds/photos_public.gne?id=117992213@N05&format=rest";
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		if (responseCode == 200) { 
			br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
		} else { 
			br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"UTF-8"));
		}
		String inputLine;
		StringBuffer resp = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			resp.append(inputLine);
		}
		br.close();
		System.out.println(resp.toString());
		
		response.reset();
		out.clearBuffer();
		response.setContentType("text/xml;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		out.print(resp.toString());
		
	} catch (Exception e) {
		System.out.println(e);
	}
%>


