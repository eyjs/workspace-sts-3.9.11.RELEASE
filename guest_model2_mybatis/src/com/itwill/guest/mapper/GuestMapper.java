package com.itwill.guest.mapper;

import java.util.List;

import com.itwill.guest.Guest;
import com.sun.javafx.scene.traversal.Hueristic2D;

public interface GuestMapper {
	/*
	 * 메쏘드이름은 	GuestMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 GuestMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 GuestMapper.xml 파일의 resultType 와일치
	 */
	/*
	<select id="selectByNo" resultType="com.itwill.guest.Guest" 
	parameterType="_int">
		select * from guest where guest_no=#{guest_no}
	</select>
	 */
	public Guest selectByNo(int no);
	/*
	<select id="selectAll" resultType="com.itwill.guest.Guest">
		select * from guest
	</select>
	 */
	public List<Guest> selectAll();
	public int insertGuest(Guest guest);
	public int deleteGuest(int guest_no);
	public int updateGuest(Guest guest);
}
