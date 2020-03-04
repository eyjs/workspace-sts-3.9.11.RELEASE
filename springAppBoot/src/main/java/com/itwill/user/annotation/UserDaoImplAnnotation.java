package com.itwill.user.annotation;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.itwill.user.User;
import com.itwill.user.UserDao;

@Repository(value = "userDao")
public class UserDaoImplAnnotation implements UserDao {
	public UserDaoImplAnnotation() {
		System.out.println("#### UserDaoImplAnnotation() : 디폴트생성자 호출  ");
	}


	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#create(com.itwill.user.User)
	 */
	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplAnnotation : create() 호출  ");
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
		System.out.println("#### UserDaoImplAnnotation : update() 호출  ");
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
		System.out.println("#### UserDaoImplAnnotation : remove() 호출  ");
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
		System.out.println("#### UserDaoImplAnnotation : findUser() 호출  ");
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
		System.out.println("#### UserDaoImplAnnotation : findUserList 호출  ");
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
		System.out.println("#### UserDaoImplAnnotation : existedUser() 호출  ");
		return true;
	}
	
}














