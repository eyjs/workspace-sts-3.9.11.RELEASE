package com.itwill.guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;


/**
 * @author stu
 *
 */
public class GuestDao{
	private DataSource dataSource;
	public GuestDao() {
		try{
			InitialContext ic=new InitialContext();
			dataSource=(DataSource)ic.lookup("java:/comp/env/jdbc/OracleDB");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
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
			con = dataSource.getConnection();
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
				guest.setGuest_content(content);
				guest.setGuest_date(date);
				guest.setGuest_email(email);
				guest.setGuest_homepage(homepage);
				guest.setGuest_name(name);
				guest.setGuest_no(no);
				guest.setGuest_title(title);
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
				con.close();

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
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(insertSQL);
			pstmt.setString(1, guest.getGuest_name());
			pstmt.setString(2, guest.getGuest_email());
			pstmt.setString(3, guest.getGuest_homepage());
			pstmt.setString(4, guest.getGuest_title());
			pstmt.setString(5, guest.getGuest_content());
			int changeRow = pstmt.executeUpdate();
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				guest = new Guest();
				guest.setGuest_content(rs.getString("guest_content"));
				guest.setGuest_date(rs.getString("guest_date"));
				guest.setGuest_email(rs.getString("guest_email"));
				guest.setGuest_homepage(rs.getString("guest_homepage"));
				guest.setGuest_name(rs.getString("guest_name"));
				guest.setGuest_title(rs.getString("guest_title"));
				guest.setGuest_no(rs.getInt("guest_no"));
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return guest;
	}

	public boolean deleteGuest(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String deleteSQL = "delete from guest where guest_no=?";
		boolean isDelete = false;
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setInt(1, no);
			int changeRows = pstmt.executeUpdate();
			isDelete = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(deleteSQL);
			pstmt.setString(1, guest.getGuest_name());
			pstmt.setString(2, guest.getGuest_email());
			pstmt.setString(3, guest.getGuest_homepage());
			pstmt.setString(4, guest.getGuest_title());
			pstmt.setString(5, guest.getGuest_content());
			pstmt.setInt(6, guest.getGuest_no());
			int changeRows = pstmt.executeUpdate();
			isUpadte = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isUpadte;
	}

}
