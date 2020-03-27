package com.itwill.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.domain.Hello;
import com.itwill.repository.HelloDao;

@Service
public class HelloService {
	@Autowired
	private HelloDao helloDao;
	
	public List<Hello> helloService() throws Exception{
		return  helloDao.helloDao();
	}
}
