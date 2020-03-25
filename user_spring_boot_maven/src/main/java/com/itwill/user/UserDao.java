package com.itwill.user;

import java.util.ArrayList;

public interface UserDao {

	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	int create(User user) throws Exception;

	/*
	 * 기존의 사용자정보를 수정
	 */
	int update(User user) throws Exception;

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	int remove(String userId) throws Exception;

	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서
	 * User 도메인클래스에 저장하여 반환
	 */
	User findUser(String userId) throws Exception;

	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 
	 * List<User> 콜렉션 에 저장하여 반환
	 */
	ArrayList<User> findUserList() throws Exception;

	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	boolean existedUser(String userId) throws Exception;

}