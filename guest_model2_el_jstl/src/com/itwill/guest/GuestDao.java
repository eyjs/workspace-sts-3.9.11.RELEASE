package com.itwill.guest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;


public class GuestDao  {
	private DataSource dataSource;
	/*
	 * SE Test DataSource
	 */
	public GuestDao(DataSource dataSource) throws Exception{
		this.dataSource =dataSource;
	}
	
	public GuestDao() throws Exception{
		InitialContext ic=new InitialContext();
		dataSource =(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
	}
	
	/*
	 * READ ALL
	 */
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				guestList.add(new Guest(
										rs.getInt("guest_no"),
										rs.getString("guest_name"),
										rs.getString("guest_date"),
										rs.getString("guest_email"),
										rs.getString("guest_homepage"),
										rs.getString("guest_title"),
										rs.getString("guest_content")
										)
						     );
			}
			
			
		}finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		return guestList;
	}
	/*
	 * CREATE
	 */
	public boolean insertGuest(Guest guest) throws Exception{
		boolean isSuccess = false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_INSERT);
			pstmt.setString(1, guest.guest_name);
			pstmt.setString(2, guest.guest_email);
			pstmt.setString(3, guest.guest_homepage);
			pstmt.setString(4, guest.guest_title);
			pstmt.setString(5, guest.guest_content);
			int insertRowCount=pstmt.executeUpdate();
			if(insertRowCount==1){
				isSuccess=true;
			}
			
		}catch(Exception e){
			isSuccess=false;
		}finally {
			if(con!=null)
				con.close();
		}
		
		return isSuccess;
	}
	/*
	 * READ ONE
	 */
	public Guest selectByNo(int no) throws Exception{
		Guest guest=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try{
			con = dataSource.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()){
				guest=new Guest(
						rs.getInt("guest_no"),
						rs.getString("guest_name"),
						rs.getString("guest_date"),
						rs.getString("guest_email"),
						rs.getString("guest_homepage"),
						rs.getString("guest_title"),
						rs.getString("guest_content")
						);
			}
		}finally{
			if(con!=null)
				con.close();
		}
		return guest;
	}
	/*
	 * DELETE
	 */
	public boolean deleteGuest(int no){
		boolean deleteOK=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_DELETE);
			pstmt.setInt(1,no);
			int deleteRowCount=pstmt.executeUpdate();
			if(deleteRowCount==1){
				deleteOK=true;
			}
		}catch(Exception e){
			e.printStackTrace();
			deleteOK=false;
		}finally {
			if(con!=null)
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return deleteOK;
	}
	/*
	 * UPDATE
	 */
	public boolean updateGuest(Guest guest){
		boolean updateOK=true;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_UPDATE);
			pstmt.setString(1, guest.guest_name);
			pstmt.setString(2, guest.guest_email);
			pstmt.setString(3, guest.guest_homepage);
			pstmt.setString(4, guest.guest_title);
			pstmt.setString(5, guest.guest_content);
			pstmt.setInt(6, guest.guest_no);
			int updateRowCount=pstmt.executeUpdate();
			if(updateRowCount==1){
				updateOK=true;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			updateOK=false;
		}finally {
			if(con!=null)
				try {
					con.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return updateOK;
	}

}










