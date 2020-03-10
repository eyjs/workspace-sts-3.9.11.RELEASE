package com.itwill.service;

public class UserExistedException extends Exception{
	public UserExistedException(String msg) {
		super(msg);
	}
}
