package com.itwill.guest.annotation;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.mapper.GuestMapper;
@Repository
public class GuestDaoImplMyBatisMapperInterfaceAnnotation  implements GuestDao{
	private GuestMapper guestMapper;
	public GuestDaoImplMyBatisMapperInterfaceAnnotation(GuestMapper guestMapper) throws Exception {
		this.guestMapper=guestMapper;
	}
	public GuestDaoImplMyBatisMapperInterfaceAnnotation() {
		// TODO Auto-generated constructor stub
	}
	public GuestMapper getGuestMapper() {
		return guestMapper;
	}

	public void setGuestMapper(GuestMapper guestMapper) {
		this.guestMapper = guestMapper;
	}
	/*
	 * READ ALL
	 */
	public List<Guest> selectAll() throws Exception {
		List<Guest> guestList=guestMapper.selectAll();
		return guestList;
	}
	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		int insertRowCount=guestMapper.insertGuest(guest); 
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
		Guest guest=guestMapper.selectByNo(no);
		return guest;
	}
	
	/*
	 /*
	 * DELETE
	 */
	public boolean deleteGuest(int guest_no) throws Exception{
		boolean deleteOK=false;
		int deleteRowCount=guestMapper.deleteGuest(guest_no); 
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
		int updateRowCount=guestMapper.updateGuest(updateGuest);
		if(updateRowCount==1) {
			updateOK=true;
		}else {
			updateOK=false;
		}
		return updateOK;
	}
}










