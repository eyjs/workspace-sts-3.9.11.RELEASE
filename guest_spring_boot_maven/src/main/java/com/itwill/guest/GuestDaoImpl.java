package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;
/*
방명록에서 데이타베이스와의 작업을 전담하는 클래스
GUEST 테이블에 GUEST를 추가,삭제,검색,수정등의 작업을한다.
*/

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
//@Repository("guestDao")
public class GuestDaoImpl implements GuestDao {
	@Autowired
	private DataSource dataSource;
	
	public GuestDaoImpl() throws Exception {
		System.out.println("1.### GuestDaoImplAnnotation()생성");
	}
	/*
	public void setDataSource(DataSource dataSource) {
		System.out.println("2.### GuestDaoImplAnnotation: setDataSource("+dataSource+")메쏘드호출");
		this.dataSource = dataSource;
	}
	*/
	/*
	 * READ ALL
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestDao#selectAll()
	 */
	@Override
	public ArrayList<Guest> selectAll() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_ALL);
			rs = pstmt.executeQuery();
	
			while (rs.next()) {
				guestList.add(new Guest(rs.getInt("guest_no"), rs.getString("guest_name"), rs.getString("guest_date"),
						rs.getString("guest_email"), rs.getString("guest_homepage"), rs.getString("guest_title"),
						rs.getString("guest_content")));
			}
			
		}finally{
			/*
			 * 반드시실행하는블록
			 *   1. return전에 반드시실행 
			 *   2. 예외던지기전에 실행
			 */
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
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestDao#insertGuest(com.itwill.guest.Guest)
	 */
	@Override
	public boolean insertGuest(Guest guest) throws Exception {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(GuestSQL.GUEST_INSERT);
			pstmt.setString(1, guest.guest_name);
			pstmt.setString(2, guest.guest_email);
			pstmt.setString(3, guest.guest_homepage);
			pstmt.setString(4, guest.guest_title);
			pstmt.setString(5, guest.guest_content);
			int insertRowCount = pstmt.executeUpdate();
			if (insertRowCount == 1) {
				isSuccess = true;
			}

		} catch (Exception e) {
			isSuccess = false;
		} finally {
			if (con != null)
				con.close();
		}

		return isSuccess;
	}

	/*
	 * READ ONE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestDao#selectByNo(int)
	 */
	@Override
	public Guest selectByNo(int no) throws Exception {
		Guest guest = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(GuestSQL.GUEST_SELECT_BY_NO);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guest = new Guest(rs.getInt("guest_no"), rs.getString("guest_name"), rs.getString("guest_date"),
						rs.getString("guest_email"), rs.getString("guest_homepage"), rs.getString("guest_title"),
						rs.getString("guest_content"));
			}
		} finally {
			if (con != null)
				con.close();
		}
		return guest;
	}

	
	/*
	 * DELETE
	 */
	
	@Override
	public boolean deleteGuest(int no) throws Exception{
		boolean deleteOK=false;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_DELETE);
			pstmt.setInt(1, no);
			int deleteRowCount = pstmt.executeUpdate();
			deleteOK=true;
		}catch (Exception e) {
			deleteOK=false;
			e.printStackTrace();
		}finally {
			if (con != null)
			
					con.close();
				
		}
		return deleteOK;
	}
	/*
	 * UPDATE
	 */
	/* (non-Javadoc)
	 * @see com.itwill.guest.GuestDao#updateGuest(com.itwill.guest.Guest)
	 */
	@Override
	public boolean updateGuest(Guest updateGuest) throws Exception{
		boolean updateOK=true;
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try {
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(GuestSQL.GUEST_UPDATE);
			pstmt.setString(1, updateGuest.guest_name);
			pstmt.setString(2, updateGuest.guest_email);
			pstmt.setString(3 ,updateGuest.guest_homepage);
			pstmt.setString(4, updateGuest.guest_title);
			pstmt.setString(5, updateGuest.guest_content);
			pstmt.setInt(6, updateGuest.guest_no);
			int updateRowCount = pstmt.executeUpdate();
			updateOK=true;
		}catch (Exception e) {
			updateOK=false;
			e.printStackTrace();
		} finally {
			if (con != null)
				con.close();
		}
		return updateOK;
	}

}
