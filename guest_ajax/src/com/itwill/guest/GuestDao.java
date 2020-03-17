package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.itwill.common.RdbmsDAO;

public class GuestDao extends RdbmsDAO {
	public GuestDao() {
		
	}

	public ArrayList<Guest> guestList() throws Exception {
		ArrayList<Guest> guestList = new ArrayList<Guest>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectSQL = "SELECT GUEST_NO," + "GUEST_NAME," + "GUEST_DATE,"
				+ "GUEST_EMAIL," + "GUEST_HOMEPAGE," + "GUEST_TITLE,"
				+ "GUEST_CONTENT " + " FROM GUEST ORDER BY GUEST_DATE DESC";

		try {
			con = getConnection();
			pstmt = con.prepareStatement(selectSQL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("guest_no");
				String name = rs.getString("guest_name");
				String date = rs.getString("guest_date");
				String email = rs.getString("guest_email");
				String homepage = rs.getString("guest_homepage");
				String content = rs.getString("guest_content");
				String title = rs.getString("guest_title");
				Guest guest = new Guest();
				guest.guest_content = content;
				guest.guest_date = date;
				guest.guest_email = email;
				guest.guest_homepage = homepage;
				guest.guest_name = name;
				guest.guest_no = no;
				guest.guest_title = title;
				guestList.add(guest);

			}// end while
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (con != null) {
				this.releaseConnection(con);// connection �ݳ�.

			}
		}
		return guestList;
	}

	public boolean insertGuest(Guest guest) {
		boolean isSuccess = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertSQL = "insert into guest "
				+ "values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		try {
			con = getConnection();
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, guest.guest_name);
			pstmt.setString(2, guest.guest_email);
			pstmt.setString(3, guest.guest_homepage);
			pstmt.setString(4, guest.guest_title);
			pstmt.setString(5, guest.guest_content);
			int changeRow = pstmt.executeUpdate();
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {
			if (con != null) {
				releaseConnection(con);
			}
		}
		return isSuccess;
	}

	public Guest selectByNo(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from guest where guest_no = ? ";
		Guest guest = null;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guest = new Guest();
				guest.guest_content = rs.getString("guest_content");
				guest.guest_date = rs.getString("guest_date");
				guest.guest_email = rs.getString("guest_email");
				guest.guest_homepage = rs.getString("guest_homepage");
				guest.guest_name = rs.getString("guest_name");
				guest.guest_title = rs.getString("guest_title");
				guest.guest_no = rs.getInt("guest_no");
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			releaseConnection(con);
		}

		return guest;
	}

	public boolean deleteGuest(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteSQL = "delete from guest where guest_no=?";
		boolean isDelete = false;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setInt(1, no);
			int changeRows = pstmt.executeUpdate();
			isDelete = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseConnection(con);
		}
		return isDelete;
	}

	public boolean updateGuest(Guest guest) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteSQL = "update guest set " + "guest_name=?,"
				+ "guest_email=?," + "guest_homepage=?," + "guest_title=?,"
				+ "guest_content=? where guest_no=?";
		boolean isUpadte = false;
		try {
			con = getConnection();
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setString(1, guest.guest_name);
			pstmt.setString(2, guest.guest_email);
			pstmt.setString(3, guest.guest_homepage);
			pstmt.setString(4, guest.guest_title);
			pstmt.setString(5, guest.guest_content);
			pstmt.setInt(6, guest.guest_no);
			int changeRows = pstmt.executeUpdate();
			isUpadte = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			releaseConnection(con);
		}
		return isUpadte;
	}

}
