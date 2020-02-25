package com.itwill.guest;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class GuestDaoImplMybatis  implements GuestDao{

	private SqlSessionFactory sqlSessionFactory;
	public final static String NAMESPACE=
			"com.itwill.guest.mapper.GuestMapper.";
	
	public GuestDaoImplMybatis() throws Exception {
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory = 
					new SqlSessionFactoryBuilder()
					.build(in);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * READ ALL
	 */
	public List<Guest> selectAll() throws Exception {
		List<Guest> guestList = new ArrayList<Guest>();
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		guestList = sqlSession.selectList(NAMESPACE+"selectAll");
		sqlSession.close();
		return guestList;
	}
	
	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int insertRowCount=sqlSession.insert(NAMESPACE+"insertGuest", guest); 
		if(insertRowCount==1) {
			isSuccess=true;
		}else {
			isSuccess=false;
		}
		sqlSession.commit();
		sqlSession.close();
		return isSuccess;
	}

	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Guest guest =sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		sqlSession.close();
		return guest;
	}
	
	
	
	/*
	 * DELETE
	 */
	public boolean deleteGuest(int guest_no) throws Exception{
		boolean deleteOK=false;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=sqlSession.insert(NAMESPACE+"deleteGuest", guest_no); 
		if(deleteRowCount==1) {
			deleteOK=true;
		}else {
			deleteOK=false;
		}
		sqlSession.commit();
		sqlSession.close();
		return deleteOK;
	}
	/*
	 * UPDATE
	 */
	public boolean updateGuest(Guest updateGuest) throws Exception{
		boolean updateOK=false;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int updateRowCount=sqlSession.insert(NAMESPACE+"updateGuest", updateGuest); 
		if(updateRowCount==1) {
			updateOK=true;
		}else {
			updateOK=false;
		}
		sqlSession.commit();
		sqlSession.close();
		return updateOK;
	}
	

}










