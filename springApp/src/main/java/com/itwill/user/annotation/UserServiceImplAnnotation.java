package com.itwill.user.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMismatchException;
import com.itwill.user.exception.UserNotFoundException;



@Component(value = "userService")
public class UserServiceImplAnnotation implements UserService {
	@Autowired
	@Qualifier(value = "userDaoJDBC")
	private UserDao userDao;
	
	private UserServiceImplAnnotation(){
		System.out.println("#### 0.UserServiceImplAnnotation() : 디폴트생성자호출");
		
	}
	//@Autowired
	private UserServiceImplAnnotation(UserDao userDao){
		System.out.println("#### 0.UserServiceImplAnnotation(UserDao userDao) : 생성자호출");
		this.userDao=userDao;
	}
	
	//@Autowired
	public void setUserDao(UserDao userDao) {
		System.out.println("#### 1.UserServiceImplAnnotation : setUserDao("+userDao+") 호출");
		this.userDao = userDao;
	}

	public int create(User user) throws ExistedUserException,Exception{
		System.out.println("#### UserServiceImplAnnotation : create() 호출");
		
		return 0;
	}
	
	/*
	 * User 상세보기
	 */
	public User findUser(String userId) throws UserNotFoundException,Exception{
		System.out.println("#### UserServiceImplAnnotation : findUser() 호출");
		userDao.findUser(userId);
		return null;
		
	}
	/*
	 * 로그인
	 */
	public User login(String userId,String password) 
			throws UserNotFoundException,PasswordMismatchException, Exception{
		//입력되는 아이디로 User 찾아오기
		System.out.println("# UserServiceImplAnnotation : login() 호출");
		return null;
		
	}
	public int update(User user) throws Exception{
		System.out.println("# UserServiceImplAnnotation : update() 호출");
		return 0;
	}
	public int remove(String userId) throws Exception{
		System.out.println("# UserServiceImplAnnotation : remove() 호출");
		return 0;
	}
	public List<User> findUserList() throws Exception{
		System.out.println("# UserServiceImplAnnotation : findUserList() 호출  ");
		return null;
	} 
	
	
	
	
	
	
}
