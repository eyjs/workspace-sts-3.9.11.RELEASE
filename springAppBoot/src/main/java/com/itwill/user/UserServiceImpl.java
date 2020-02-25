package com.itwill.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;

@Component(value = "userService")
public class UserServiceImpl implements UserService {
	//@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println("#### UserServiceImpl() : 디폴트생성자호출");
	}
	//@Autowired
	public UserServiceImpl(UserDao userDao) {
		System.out.println("#### UserServiceImpl(UserDao userDao) : 생성자호출");
		this.userDao=userDao;
	}
	
	@Autowired
	public void setUserDao(UserDao userDao) {
		System.out.println("#### UserServiceImpl : setUserDao("+userDao+") 호출");
		this.userDao = userDao;
	}
	public int create(User user) throws ExistedUserException, Exception {
		System.out.println("#### UserServiceImpl : create() 호출");
		return userDao.create(null);
	}

	/*
	 * User 상세보기
	 */
	public User findUser(String userId) throws UserNotFoundException, Exception {
		System.out.println("#### UserServiceImpl : findUser() 호출");
		return userDao.findUser(null);
	}

	/*
	 * 로그인
	 */
	public User login(String userId, String password)
			throws UserNotFoundException, PasswordMismatchException, Exception {
		// 입력되는 아이디로 User 찾아오기
		System.out.println("#### UserServiceImpl : login() 호출");
		return null;
	}

	public int update(User user) throws Exception {
		System.out.println("#### UserServiceImpl : update() 호출");
		return 0;
	}

	public int remove(String userId) throws Exception {
		System.out.println("#### UserServiceImpl : remove() 호출");
		return 0;
	}

	public List<User> findUserList() throws Exception {
		System.out.println("#### UserServiceImpl : findUserList() 호출  ");
		return userDao.findUserList();
	}
}
