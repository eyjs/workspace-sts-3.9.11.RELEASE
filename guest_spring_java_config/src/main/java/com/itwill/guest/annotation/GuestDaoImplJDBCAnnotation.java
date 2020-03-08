package com.itwill.guest.annotation;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestDao;
import com.itwill.guest.GuestSQL;

@Repository
public class GuestDaoImplJDBCAnnotation implements GuestDao  {
	@Autowired
	private DataSource dataSource;
	/*
	 * SE Test DataSource
	 */
	public GuestDaoImplJDBCAnnotation(DataSource dataSource) throws Exception{
		System.out.println("### GuestDaoImplJDBC("+dataSource+") 생성자");
		this.dataSource =dataSource;
	}
	
	public GuestDaoImplJDBCAnnotation() throws Exception{
		System.out.println("### GuestDaoImplJDBC() 기본생성자");
	}
	
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		System.out.println("### GuestDaoImplJDBC : setDataSource("+dataSource+") 메쏘드");
	}

	/*
	 * READ ALL
	 */
	@Override
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
	@Override
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
	@Override
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
	@Override
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
	@Override
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










