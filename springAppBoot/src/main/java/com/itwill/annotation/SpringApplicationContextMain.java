package com.itwill.annotation;

public class SpringApplicationContextMain {
	public static void main(String[] args) throws IllegalAccessException, InstantiationException {
		SpringApplicationContext applicationContext = 
				new SpringApplicationContext();
		MemberService memberService = 
				applicationContext.getBean(MemberService.class);
		System.out.println("### "+memberService);
		applicationContext.printBean();
	}
}