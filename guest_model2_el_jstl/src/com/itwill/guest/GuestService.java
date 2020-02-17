package com.itwill.guest;

import java.util.ArrayList;

public class GuestService {
	
	private GuestDao guestDao;

	public GuestService() throws Exception{
		guestDao=new GuestDao();
	}
	/*
	 * 방명록 리스트
	 */
	public ArrayList<Guest> selectAll() throws Exception {
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
