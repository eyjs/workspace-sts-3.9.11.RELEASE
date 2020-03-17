package com.itwill.ajax.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenApiController {
	@RequestMapping(value = "/proxy_naver",produces = "text/xml;charset=UTF-8")
	public String proxy_naver(@RequestParam(value = "searchBook",defaultValue = "자바스크립트") String searchBook) {
		
		String clientId = "Jaxxx_gxFJfvXW9FrxFP";
		String clientSecret = "9xjPC6rXZi";
		try {
			String text = URLEncoder.encode(searchBook, "UTF-8");
			//String apiURL = "https://openapi.naver.com/v1/search/book?display=100&query="+ text; // json 
			String apiURL = "https://openapi.naver.com/v1/search/book.xml?display=100&query=" + text; // xml 
			//String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json 
			//String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query=" + text; // xml 
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "UTF-8"));
			}
			String inputLine;
			StringBuffer resp = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				resp.append(inputLine);
			}
			br.close();
			System.out.println(resp.toString());
			con.disconnect();
			return resp.toString();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
