package com.itwill.naver.login;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.scribejava.core.model.OAuth2AccessToken;

/**
 * Handles requests for the application home page.
 */
@Controller
public class LoginController {
	/* NaverLoginBO */
	private NaverLoginBO naverLoginBO;
	private String apiResult = null;

	@Autowired
	private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
		this.naverLoginBO = naverLoginBO;
	}

	// 로그인 첫 화면 요청 메소드
	@RequestMapping(value = "/naver_login", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, HttpSession session) {
		System.out.println("**********여기는 naver로 login요청*************");
		/* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
		String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
		// https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
		// redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
		System.out.println("네이버:" + naverAuthUrl);
		// 네이버
		model.addAttribute("url", naverAuthUrl);
		System.out.println("*************************************************");
		return "naver_login";
	}

	// 네이버 로그인 성공시 callback호출 메소드
	@RequestMapping(value = "/naver_login_callback", method = { RequestMethod.GET, RequestMethod.POST })
	public String callback(Model model, @RequestParam String code, @RequestParam String state, HttpSession session)
			throws IOException, ParseException {
		System.out.println("**********여기는 callback*************");
		System.out.println("code:"+code);
		System.out.println("state:"+state);
		
		OAuth2AccessToken oauthToken;
		oauthToken = naverLoginBO.getAccessToken(session, code, state);
		// 1. 로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBO.getUserProfile(oauthToken); // String형식의 json데이터
		/*
		 {
		 	"resultcode":"00",
		 	"message":"success",
		 	"response":{
		 				"id":"15914306",
		 				"nickname":"\u3131\u3137",
		 				"profile_image":"https:\/\/phinf.pstatic.net\/contact\/20180208_57\/1518076151519pSuIf_PNG\/avatar_profile.png",
		 				"age":"30-39",
		 				"gender":"M",
		 				"email":"guard883@naver.com",
		 				"name":"\uae40\uacbd\ud638",
		 				"birthday":"06-04"
		 				}
		 }
		 */
		System.out.println(apiResult);
		// 2. String형식인 apiResult를 json형태로 바꿈
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(apiResult);
		JSONObject jsonObj = (JSONObject) obj;
		// 3. 데이터 파싱
		JSONObject response_obj = (JSONObject) jsonObj.get("response");
		//response의 값 파싱
		String id = (String)response_obj.get("id");
		String nickname = (String) response_obj.get("nickname");
		String name = (String)response_obj.get("name");
		String profile_image = (String) response_obj.get("profile_image");
		String age = (String) response_obj.get("age");
		String gender = (String) response_obj.get("gender");
		String email = (String)response_obj.get("email");
		String birthday = (String)response_obj.get("birthday");
		// 4.파싱 닉네임 세션으로 저장
		
		session.setAttribute("access_token", oauthToken.getAccessToken());
		session.setAttribute("id", id); 
		session.setAttribute("nickname", nickname);
		session.setAttribute("profile_image", profile_image); 
		session.setAttribute("age", age); 
		session.setAttribute("gender", gender);
		session.setAttribute("email", email);
		session.setAttribute("name", name);
		session.setAttribute("birthday", birthday);
		System.out.println("access_token:"+ oauthToken.getAccessToken());
		System.out.println("id:"+ id);
		System.out.println("nickname:"+ nickname);
		System.out.println("profile_image:"+ profile_image);
		System.out.println("age:"+ age);
		System.out.println("gender:"+ gender);
		System.out.println("email:"+ email);
		System.out.println("name:"+ name);
		System.out.println("birthday:"+ birthday);
		System.out.println("**************************************");
		return "naver_login";
	}

//로그아웃
	@RequestMapping(value = "/logout", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session)
			throws IOException {
		System.out.println("**********여기는 logou*************");
		String access_token=(String)session.getAttribute("access_token");
		String client_id = "M7ccNW11nS1dG3Z_PHmt";// 애플리케이션 클라이언트 아이디값";
		String client_secret = "C0ZxpZoijC";// 애플리케이션 클라이언트 시크릿값";
		String apiURL;
		apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=delete";
		apiURL += "&client_id=" + client_id;
		apiURL += "&client_secret=" + client_secret;
		apiURL += "&access_token=" + access_token;
		apiURL += "&service_provider=NAVER";
		System.out.println("apiURL=" + apiURL);
		System.out.println("access_token=" + access_token);
		try {
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			System.out.print("responseCode=" + responseCode);
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			String inputLine;
			StringBuffer res = new StringBuffer();
			while ((inputLine = br.readLine()) != null) {
				res.append(inputLine);
			}
			System.out.println(res.toString());
			br.close();
			if (responseCode == 200) {

			}else {
				
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		session.invalidate();
		System.out.println("***************************************");
		return "redirect:naver_login";
	}
}
