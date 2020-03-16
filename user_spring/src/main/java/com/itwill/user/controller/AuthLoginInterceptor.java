package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*
①HandlerInterceptor 인터페이스
②HandlerInterceptorAdapter 추상클래스
	- public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler)
     	Controller 요청 전 실행
	
	- public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler, ModelAndVeiw modelAndVeiw)
     	Controller 처리가 끝나고 화면에 띄어주는 처리 직전에 수행
	
	- afterCompletion() : 모든 처리가 끝난 후 호출
 */
@Controller
public class AuthLoginInterceptor extends HandlerInterceptorAdapter{
    public AuthLoginInterceptor() {
    	System.out.println("### AuthLoginInterceptor()생성자");
    }
	//preHandle() : 컨트롤러보다 먼저 수행되는 메서드
    @Override
    public boolean preHandle(
    		HttpServletRequest request, 
    		HttpServletResponse response, 
    		Object handler)
            throws Exception {
    	System.out.println("### AuthLoginInterceptor.preHandle()메써드");
        // session 객체를 가져옴
        HttpSession session = request.getSession();
        // login처리를 담당하는 사용자 정보를 담고 있는 객체를 가져옴
        String sUserId =(String)session.getAttribute("sUserId");
          
        if ( sUserId == null ){
            // 로그인이 안되어 있는 상태임으로 로그인 폼으로 다시 돌려보냄(redirect)
            response.sendRedirect("user_main");
            return false; // 더이상 컨트롤러 요청으로 가지 않도록 false로 반환함
        }
          
        // preHandle의 return은 컨트롤러 요청 uri로 가도 되냐 안되냐를 허가하는 의미임
        // 따라서 true로하면 컨트롤러 uri로 가게 됨.
        return true;
    }
  
    // 컨트롤러가 수행되고 화면이 보여지기 직전에 수행되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        super.postHandle(request, response, handler, modelAndView);
    }    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
    		throws Exception {
    	// TODO Auto-generated method stub
    	super.afterCompletion(request, response, handler, ex);
    }
}