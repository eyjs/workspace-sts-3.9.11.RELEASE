package com.itwill0.log;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;
@Component
@Log4j2
public class HelloWorldLog4J {
	private Logger log = LogManager.getLogger(HelloWorldLog4J.class);
	public String hello(String name) {
		log.debug("start:"+name);
		log.info("start:"+name);
		log.warn("start:"+name);
		log.error("start:"+name);
		log.fatal("start:"+name);
		String message=name+" 님안녕하세요!!";
		log.debug("end:"+name);
		log.info("end:"+name);
		log.warn("end:"+name);
		log.error("end:"+name);
		log.fatal("end:"+name);
		return message;
	}
}
