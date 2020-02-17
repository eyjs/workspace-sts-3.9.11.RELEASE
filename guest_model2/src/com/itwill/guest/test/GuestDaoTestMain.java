package com.itwill.guest.test;

import java.util.ArrayList;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;

public class GuestDaoTestMain {
	public static void main(String[] args)throws Exception {
		GuestDao guestDao=new GuestDao(JavaSeDataSource.getDataSource());
		System.out.println("---------selectAll---------");
		ArrayList<Guest> guestList=guestDao.selectAll();
		for (int i = 0; i < guestList.size(); i++) {
			System.out.println(guestList.get(i));
		}
		System.out.println("---------selectByNo---------");
		Guest guest=guestDao.selectByNo(3);
		System.out.println(guest);
		System.out.println("---------insertGuest---------");
		Guest insertGuest=new Guest(-999, "guest_name", null, "guest_email", "guest_homepage", "guest_title", "guest_content");
		boolean insertSuccess=guestDao.insertGuest(insertGuest);
		System.out.println(insertSuccess);
		System.out.println("---------updateGuest---------");
		guest.guest_name="변경";
		guest.guest_email="변경이메일";
		boolean updateOk=guestDao.updateGuest(guest);
		System.out.println(updateOk);
		System.out.println("---------deleteGuest---------");
		boolean deleteOk=guestDao.deleteGuest(3);
		System.out.println(deleteOk);
	}

}








