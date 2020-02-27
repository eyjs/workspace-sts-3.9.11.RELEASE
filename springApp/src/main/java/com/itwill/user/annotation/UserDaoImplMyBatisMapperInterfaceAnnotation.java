package com.itwill.user.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.user.User;
import com.itwill.user.UserDao;
import com.itwill.user.mapper.UserMapper;

@Repository("userDaoMyBatisMapper")
//@MapperScan(basePackages = "com.itwill.user.mapper")
public class UserDaoImplMyBatisMapperInterfaceAnnotation implements UserDao {
	@Autowired
	private UserMapper userMapper;
	
	public UserDaoImplMyBatisMapperInterfaceAnnotation() {
		System.out.println("#### UserDaoImplMyBatisMapperInterfaceAnnotation() : 디폴트생성자 호출  ");
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterfaceAnnotation : create() 호출  ");
		return userMapper.create(user);
	}
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterfaceAnnotation : update() 호출  ");
		return userMapper.update(user);
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterfaceAnnotation : remove() 호출  ");
		return userMapper.remove(userId);
	}
	

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterfaceAnnotation : findUser() 호출  ");
		return userMapper.findUser(userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatisMapperInterfaceAnnotation : findUserList 호출  ");
		return userMapper.findUserList();
	}

	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplMyBatisMapperInterfaceAnnotation : existedUser() 호출  ");
		int userCount = userMapper.selectCountByUserId(userId);
		if(userCount >= 1) {
			return true;
		}else {
			return false;
		}
	}
	
}














