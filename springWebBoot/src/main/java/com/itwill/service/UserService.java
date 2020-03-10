package com.itwill.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
@Service
public class UserService {
	@Autowired
	private MessageSource messageSource;
	
	public void create(/*Locale requestLocale*/)  throws UserExistedException{
		/*
		 * ko --> userId 존재안함!!
		 * en --> userId no existed!!
		 */
		/*
		String msg=messageSource.getMessage("exception.userexisted", 
				new Object[] {"xxx"}, requestLocale);
		*/
		String msg="exception.userexisted";
		throw new UserExistedException(msg);
		
		
		
	}
}
