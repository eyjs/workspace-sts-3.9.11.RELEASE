package com.itwill.guest;

import java.util.ArrayList;

public interface GuestDao {

	/*
	 * READ ALL
	 */
	ArrayList<Guest> selectAll() throws Exception;

	/*
	 * CREATE
	 */
	boolean insertGuest(Guest guest) throws Exception;

	/*
	 * READ ONE
	 */
	Guest selectByNo(int no) throws Exception;

	/*
	 * DELETE
	 */
	boolean deleteGuest(int no);

	/*
	 * UPDATE
	 */
	boolean updateGuest(Guest guest);

}