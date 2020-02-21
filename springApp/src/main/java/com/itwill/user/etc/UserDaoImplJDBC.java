package com.itwill.user.etc;

import java.util.List;

import com.itwill.user.User;
import com.itwill.user.UserDao;


public class UserDaoImplJDBC implements UserDao {
	

	public UserDaoImplJDBC() {
		System.out.println("#### UserDaoImplJDBC() : 디폴트생성자 호출  ");
	}


	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#create(com.itwill.user.User)
	 */
	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplJDBC : create() 호출  ");
		return 0;
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#update(com.itwill.user.User)
	 */
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplJDBC : update() 호출  ");
		return 0;
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#remove(java.lang.String)
	 */
	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplJDBC : remove() 호출  ");
		return 0;
	}
	
	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서
	 * User 도메인클래스에 저장하여 반환
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplJDBC : findUser() 호출  ");
		return null;
	}
	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 
	 * List<User> 콜렉션 에 저장하여 반환
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#findUserList()
	 */
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplJDBC : findUserList 호출  ");
		return null;
	}
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#existedUser(java.lang.String)
	 */
	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplJDBC : existedUser() 호출  ");
		return true;
	}
	
}














