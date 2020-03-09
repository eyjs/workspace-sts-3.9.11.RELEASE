package com.itwill.user;

import java.util.ArrayList;

import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

public interface UserService {

	/*
	 * 회원가입
	 */
	int create(User user) throws Exception, ExistedUserException;

	/*
	 * 회원 로그인
	 */
	User login(String userId, String password) throws Exception, UserNotFoundException, PasswordMismatchException;

	/*
	 * 회원1명보기
	 */
	User findUser(String userId) throws Exception, UserNotFoundException;

	/*
	 * 회원리스트
	 */
	ArrayList<User> findUserList() throws Exception;

	/*
	 * 아이디중복체크
	 * 
	 */
	/*
	 * 아이디중복체크
	 * 
	 */
	boolean isDuplcateUserId(String userId) throws Exception;

	/*
	 * 회원탈퇴
	 */
	int remove(String userId) throws Exception;

	/*
	 * 회원수정
	 */
	int update(User user) throws Exception;

}