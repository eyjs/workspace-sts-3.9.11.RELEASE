package com.itwill.guest.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.itwill.guest.Guest;
@Mapper
public interface GuestMapper {
	List<Guest> selectAll() throws Exception;
	boolean insertGuest(Guest guest) throws Exception;
	Guest selectByNo(int no) throws Exception;
	boolean deleteGuest(int no) throws Exception;
	boolean updateGuest(Guest updateGuest) throws Exception;
}
