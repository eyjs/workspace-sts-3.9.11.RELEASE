package com.itwill.guest.annotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestService;
@Service
public class GuestServiceImplAnnotation implements GuestService {
	@Autowired
	private GuestDao guestDao;

	public GuestServiceImplAnnotation() throws Exception{
		//guestDao=new GuestDaoImplJDBC();
		//guestDao=new GuestDaoImplMybatis();
		//guestDao=new GuestDaoImplMapperInterfaceMybatis();
		System.out.println("### GuestServiceImpl()생성자");
		
	}
	
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
		System.out.println("### GuestServiceImpl:setGuestDao("+guestDao+")메쏘드호출");
	}

	/*
	 * 방명록 리스트
	 */
	@Override
	public List<Guest> selectAll() throws Exception {
		return guestDao.selectAll();
	}
	/*
	 * CREATE
	 */
	@Override
	public boolean insertGuest(Guest guest) throws Exception{
		return guestDao.insertGuest(guest);
	}
	/*
	 * READ ONE
	 */
	@Override
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}
	/*
	 * DELETE
	 */
	@Override
	public boolean deleteGuest(int no) throws Exception{
		return guestDao.deleteGuest(no);
	}
	/*
	 * UPDATE
	 */
	@Override
	public boolean updateGuest(Guest updateGuest) throws Exception{
		return guestDao.updateGuest(updateGuest);
	}
	
	
	

}
