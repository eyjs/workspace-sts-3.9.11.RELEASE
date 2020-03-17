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
	@RequestMapping(value = "foursquare_json",produces = "application/json;charset=UTF-8")
	public String foursquare_json(@RequestParam(value = "lat",defaultValue = "37.499555") String lat ,
			                      @RequestParam(value = "lng",defaultValue = "127.031401") String lng) {
		try {
			String jsonUrl="https://api.foursquare.com/v2/venues/explore?"+
				    "client_secret=4ZTOF5RTH4XPCVZVVX4QRNA41PYWM2KOSFL5DLNUK4X3ASD1&"+
				    "client_id=4XW1NDXIE042PYDOA5ISWYB25ESRHPJZN4HGGWECIM22V3TT&"+
				    "ll="+lat+","+lng+"&"+
				    "radius=1000&"+
				    "limit=50&"+
				    "v=20130613";
			URL url = new URL(jsonUrl);
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
			con.disconnect();
			
			return resp.toString();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
	@RequestMapping(value = "proxy_xml",produces = "text/xml;charset=UTF-8")
	public String proxy_xml() {
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
			con.disconnect();
			
			return resp.toString();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}
	
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
