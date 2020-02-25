package com.itwill.guest;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.itwill.guest.mapper.GuestMapper;


public class GuestDaoImplMapperInterfaceMybatis  implements GuestDao{

	private SqlSessionFactory sqlSessionFactory;
	
	
	public GuestDaoImplMapperInterfaceMybatis() throws Exception {
		InputStream in=null;
		try {
			in=Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
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
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		List<Guest> guestList=guestMapper.selectAll();
		sqlSession.close();
		return guestList;
	}
	
	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		int insertRowCount=guestMapper.insertGuest(guest); 
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
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		Guest guest=guestMapper.selectByNo(no);
		sqlSession.close();
		return guest;
	}
	
	
	
	/*
	 /*
	 * DELETE
	 */
	public boolean deleteGuest(int guest_no) throws Exception{
		boolean deleteOK=false;
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		int deleteRowCount=guestMapper.deleteGuest(guest_no); 
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
		GuestMapper guestMapper=sqlSession.getMapper(GuestMapper.class);
		int updateRowCount=guestMapper.updateGuest(updateGuest);
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










