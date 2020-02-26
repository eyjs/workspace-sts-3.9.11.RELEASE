package com.itwill.user.annotation;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.user.User;
import com.itwill.user.UserDao;

//@Repository("userDaoMyBatis")
public class UserDaoImplMyBatisAnnotation implements UserDao {
	public static String NAMESPACE="com.itwill3.dao.UserMapper.";
	@Autowired
	private SqlSession sqlSession;
	
	
	public UserDaoImplMyBatisAnnotation() {
		System.out.println("#### UserDaoImplMyBatisAnnotation() : 디폴트생성자 호출  ");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatisAnnotation : setSqlSession("+sqlSession+") 호출  ");
		this.sqlSession = sqlSession;
	}

	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisAnnotation : create() 호출  ");
		return sqlSession.insert(NAMESPACE+"create", user);
	}


	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatisAnnotation : update() 호출  ");
		return sqlSession.update(NAMESPACE+"update", user);
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisAnnotation : remove() 호출  ");
		return sqlSession.delete(NAMESPACE+"remove", userId);
	}
	

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatisAnnotation : findUser() 호출  ");
		return sqlSession.selectOne(NAMESPACE+"findUser",userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatisAnnotation : findUserList 호출  ");
		return sqlSession.selectList(NAMESPACE+"findUserList");
	}

	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplMyBatisAnnotation : existedUser() 호출  ");
		int userCount = sqlSession.selectOne(NAMESPACE+"selectCountByUserId", userId);
		if(userCount >= 1) {
			return true;
		}else {
			return false;
		}
	}
	
}














