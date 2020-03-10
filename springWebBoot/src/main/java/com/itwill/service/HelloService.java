package com.itwill.service;

import com.itwill.dao.HelloDao;

public class HelloService {
	private HelloDao helloDao;
	public HelloService() {
		System.out.println("### HelloService()생성자");
	}
	public void setHelloDao(HelloDao helloDao) {
		System.out.println("### HelloService: setHelloDao()메쏘드호출");
		this.helloDao = helloDao;
	}
	public void service_method() {
		System.out.println("### HelloService: service_method() 메쏘드호출");
		helloDao.dao_method();
	}
	
	
}
