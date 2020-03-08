package com.itwill.guest.annotation;


import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
@Repository
public class GuestDaoImplMyBatisAnnotation  implements GuestDao{
	private SqlSession sqlSession;
	public final static String NAMESPACE=
			"com.itwill.guest.mapper.GuestMapper.";
	public GuestDaoImplMyBatisAnnotation() throws Exception {
	}
	public GuestDaoImplMyBatisAnnotation(SqlSession sqlSession) throws Exception {
		this.sqlSession=sqlSession;
	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	/*
	 * READ ALL
	 */
	public List<Guest> selectAll() throws Exception {
		List<Guest> guestList = new ArrayList<Guest>();
		guestList = sqlSession.selectList(NAMESPACE+"selectAll");
		return guestList;
	}
	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		int insertRowCount=sqlSession.insert(NAMESPACE+"insertGuest", guest); 
		if(insertRowCount==1) {
			isSuccess=true;
		}else {
			isSuccess=false;
		}
		return isSuccess;
	}
	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception {
		Guest guest =sqlSession.selectOne(NAMESPACE+"selectByNo",no);
		return guest;
	}
	/*
	 * DELETE
	 */
	public boolean deleteGuest(int guest_no) throws Exception{
		boolean deleteOK=false;
		int deleteRowCount=sqlSession.insert(NAMESPACE+"deleteGuest", guest_no); 
		if(deleteRowCount==1) {
			deleteOK=true;
		}else {
			deleteOK=false;
		}
		return deleteOK;
	}
	/*
	 * UPDATE
	 */
	public boolean updateGuest(Guest updateGuest) throws Exception{
		boolean updateOK=false;
		int updateRowCount=sqlSession.insert(NAMESPACE+"updateGuest", updateGuest); 
		if(updateRowCount==1) {
			updateOK=true;
		}else {
			updateOK=false;
		}
		return updateOK;
	}
	

}










