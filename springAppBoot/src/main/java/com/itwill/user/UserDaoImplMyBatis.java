package com.itwill.user;

import java.util.List;

import org.apache.ibatis.session.SqlSession;


public class UserDaoImplMyBatis implements UserDao {
	public static String NAMESPACE="com.itwill3.dao.UserMapper.";
	private SqlSession sqlSession;
	
	
	public UserDaoImplMyBatis() {
		System.out.println("#### UserDaoImplMyBatis() : 디폴트생성자 호출  ");
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("#### UserDaoImplMyBatis : setSqlSession("+sqlSession+") 호출  ");
		this.sqlSession = sqlSession;
	}

	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : create() 호출  ");
		return sqlSession.insert(NAMESPACE+"create", user);
	}


	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : update() 호출  ");
		return sqlSession.update(NAMESPACE+"update", user);
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : remove() 호출  ");
		return sqlSession.delete(NAMESPACE+"remove", userId);
	}
	

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUser() 호출  ");
		return sqlSession.selectOne(NAMESPACE+"findUser",userId);
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplMyBatis : findUserList 호출  ");
		return sqlSession.selectList(NAMESPACE+"findUserList");
	}

	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplMyBatis : existedUser() 호출  ");
		int userCount = sqlSession.selectOne(NAMESPACE+"selectCountByUserId", userId);
		if(userCount >= 1) {
			return true;
		}else {
			return false;
		}
	}
	
}














