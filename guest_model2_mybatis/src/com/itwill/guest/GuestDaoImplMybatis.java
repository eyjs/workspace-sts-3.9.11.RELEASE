package com.itwill.guest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class GuestDaoImplMybatis  implements GuestDao{

	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insertGuest(Guest guest) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteGuest(int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGuest(Guest guest) {
		// TODO Auto-generated method stub
		return false;
	}
	

}










