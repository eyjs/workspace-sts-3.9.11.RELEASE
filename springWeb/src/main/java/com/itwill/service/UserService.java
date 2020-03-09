package com.itwill.service;

import org.springframework.stereotype.Service;
@Service
public class UserService {
	//@Autowired
	//private MessageSource messageSource;
	
	public void create()  throws UserExistedException{
		/*
		 * ko --> userId 존재안함!!
		 * en --> userId no existed!!
		 */
		/*
		String msg=messageSource.getMessage("exception.userexisted", 
				new Object[] {"xxx"}, 
				Locale.getDefault());
		*/
		String msg="exception.userexisted";
		throw new UserExistedException(msg);
		
		
		
	}
}
