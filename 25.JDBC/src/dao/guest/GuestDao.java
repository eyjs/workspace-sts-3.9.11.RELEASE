package dao.guest;

import java.util.ArrayList;

public interface GuestDao {
	
	/*
	 * Create
	 */
	public int insertGuest(Guest guest) throws Exception;
	/*
	 * Read
	 */
	public Guest selectByNo(int no) throws Exception;
	public ArrayList<Guest> selectAll() throws Exception;
	/*
	 * Update
	 */
	public int updateGuest(Guest guest) throws Exception;
	/*
	 * Delete
	 */
	public int deleteGuest(int no) throws Exception;
}
