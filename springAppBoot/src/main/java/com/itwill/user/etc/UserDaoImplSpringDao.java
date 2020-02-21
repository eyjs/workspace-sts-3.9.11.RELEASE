package com.itwill.user.etc;

import java.util.List;

import com.itwill.user.User;
import com.itwill.user.UserDao;


public class UserDaoImplSpringDao implements UserDao {
	public UserDaoImplSpringDao() {
		System.out.println("#### UserDaoSpringJDBC() : 디폴트생성자 호출  ");
	}

	@Override
	public int create(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(String userId) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User findUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findUserList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existedUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}














