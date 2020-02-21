package com.itwill0.log;

import org.apache.log4j.Logger;

public class HelloWorldLog4J {
	
	private Logger logger = Logger.getLogger(HelloWorldLog4J.class);
	public String hello(String name) {
		
		logger.debug("start"+name);
		logger.info("start"+name);
		logger.warn("start"+name);
		logger.error("start"+name);
		logger.fatal("start"+name);
		String message = name+" 님 안녕하세요!!";
		logger.debug("end"+name);
		logger.info("end"+name);
		logger.warn("end"+name);
		logger.error("end"+name);
		logger.fatal("end"+name);
		return message;
	}

}
