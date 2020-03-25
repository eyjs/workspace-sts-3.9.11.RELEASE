package com.itwill.guest;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.guest.mapper.GuestMapper;
@Repository("guestMybatisDaoMapperInterface")
public class GuestDaoImplMyBatisMapperInterface implements GuestDao {
	@Autowired
	private GuestMapper guestMapper;
	
	public GuestDaoImplMyBatisMapperInterface() {
		System.out.println("1.#### GuestDaoImplMyBatisMapperInterface()");
		
	}
	@Override
	public boolean insertGuest(Guest guest) throws Exception {
		try {
			guestMapper.insertGuest(guest);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest guest=guestMapper.selectByNo(no);
		return guest;
	}
	@Override
	public boolean deleteGuest(int no) throws Exception {
		
		try {
		 guestMapper.deleteGuest(no);
		 return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public boolean updateGuest(Guest updateGuest) throws Exception {
		try {
			guestMapper.updateGuest(updateGuest);
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public List<Guest> selectAll() throws Exception {
		List<Guest> guestList=guestMapper.selectAll();
		return guestList;
	}
}
