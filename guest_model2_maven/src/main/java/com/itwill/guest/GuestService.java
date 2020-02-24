﻿package com.itwill.guest;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class GuestService {
	
	private GuestDao guestDao;
	private Log log=LogFactory.getLog(GuestService.class);
	public GuestService() throws Exception{
		//guestDao=new GuestDaoImplJDBC();
		//guestDao=new GuestDaoImplMybatis();
		guestDao=new GuestDaoImplMapperInterfaceMybatis();
	}
	/*
	 * 방명록 리스트
	 */
	public List<Guest> selectAll() throws Exception {
		log.debug("start");
		return guestDao.selectAll();
	}
	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception{
		return guestDao.insertGuest(guest);
	}
	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}
	/*
	 * DELETE
	 */
	public boolean deleteGuest(int no) throws Exception{
		return guestDao.deleteGuest(no);
	}
	/*
	 * UPDATE
	 */
	public boolean updateGuest(Guest updateGuest) throws Exception{
		return guestDao.updateGuest(updateGuest);
	}
	
	
	

}
