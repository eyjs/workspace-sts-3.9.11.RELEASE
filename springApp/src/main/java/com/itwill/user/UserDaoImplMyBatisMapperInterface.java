package com.itwill.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.itwill.user.mapper.UserMapper;


public class UserDaoImplMyBatisMapperInterface implements UserDao {
	
	private UserMapper userMapper;
	public UserDaoImplMyBatisMapperInterface() {
		System.out.println("#### UserDaoImplMyBatisMapperInterface() : 디폴트생성자 호출  ");
	}
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : create() 호출  ");
		return userMapper.create(user);
	}
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : update() 호출  ");
		return userMapper.update(user);
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : remove() 호출  ");
		return userMapper.remove(userId);
	}
	

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUser() 호출  ");
		return userMapper.findUser(userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterface : findUserList 호출  ");
		return userMapper.findUserList();
	}

	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplMyBatisMapperInterface : existedUser() 호출  ");
		int userCount = userMapper.selectCountByUserId(userId);
		if(userCount >= 1) {
			return true;
		}else {
			return false;
		}
	}
	
}














