package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//@Repository("guestMybatisDao")
public class GuestDaoImplMyBatis implements GuestDao {
	public static final String NAMESPACE = "com.itwill.guest.mapper.GuestMapper.";
	//@Autowired
	private SqlSession sqlSession;

	public GuestDaoImplMyBatis() throws Exception {
		System.out.println("1.### GuestDaoImplMyBatis()생성");
	}

	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("2.### GuestDaoImplMyBatis: setSqlSession(" + sqlSession + ")메쏘드실행");
		this.sqlSession = sqlSession;
	}

	@Override
	public List<Guest> selectAll() throws Exception {
		List<Guest> guestList = sqlSession.selectList(NAMESPACE + "selectAll");
		return guestList;
	}

	@Override
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		return isSuccess;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest guest = null;
		guest=sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		return guest;
	}

	@Override
	public boolean deleteGuest(int no) throws Exception {
		boolean deleteOK = false;
		return deleteOK;
	}

	@Override
	public boolean updateGuest(Guest updateGuest) throws Exception {
		boolean updateOK = true;
		return updateOK;
	}
}
