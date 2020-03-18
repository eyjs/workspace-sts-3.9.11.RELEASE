package com.itwill.guest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
@Service("guestService")
public class GuestServiceImpl implements GuestService {
	@Autowired
	@Qualifier("guestMybatisDaoMapperInterface")
	private GuestDao guestDao;
	
	public GuestServiceImpl() throws Exception{
		System.out.println("3.### GuestServiceImplAnnotation():생성자");
	}
	/*
	public void setGuestDao(GuestDao guestDao) {
		System.out.println("4.### GuestServiceImplAnnotation: setGuestDao("+guestDao+") 메써드호출");
		this.guestDao = guestDao;
	}
	*/
	/*
	 * 방명록 리스트
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#selectAll()
	 */
	@Override
	public List<Guest> selectAll() throws Exception {
		return guestDao.selectAll();
	}
	/*
	 * CREATE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#insertGuest(com.itwill.guest.Guest)
	 */
	@Override
	public boolean insertGuest(Guest guest) throws Exception{
		return guestDao.insertGuest(guest);
	}
	/*
	 * READ ONE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#selectByNo(int)
	 */
	@Override
	public Guest selectByNo(int no) throws Exception{
		return guestDao.selectByNo(no);
	}
	/*
	 * DELETE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#deleteGuest(int)
	 */
	@Override
	public boolean deleteGuest(int no) throws Exception{
		return guestDao.deleteGuest(no);
	}
	/*
	 * UPDATE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestService#updateGuest(com.itwill.guest.Guest)
	 */
	@Override
	public boolean updateGuest(Guest updateGuest) throws Exception{
		return guestDao.updateGuest(updateGuest);
	}
	
	
	

}
