package com.itwill.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "userDaoJDBC2")
public class UserDaoImplJDBC2 implements UserDao {
	@Autowired
	private DataSource dataSource;
	public UserDaoImplJDBC2() {
		System.out.println("#### UserDaoImplJDBC2() : 디폴트생성자 호출  ");
		
	}
	public UserDaoImplJDBC2(DataSource dataSource) {
		System.out.println("#### UserDaoImplJDBC2(DataSource dataSource) : 생성자 호출  ");
		this.dataSource = dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		System.out.println("#### UserDaoImplJDBC2.setDataSource("+dataSource+") : 호출  ");
		this.dataSource = dataSource;
	}


	/*
	 * 사용자관리테이블에 새로운사용자생성
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#create(com.itwill.user.User)
	 */
	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplJDBC2 : create() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		String insertQuery = "insert into userinfo values(?,?,?,?)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(insertQuery);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();;
		}
		
	}

	/*
	 * 기존의 사용자정보를 수정
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#update(com.itwill.user.User)
	 */
	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplJDBC2 : update() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		String updateQuery = "update userinfo set password=?,name=?,email=? where userid=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(updateQuery);
			pstmt.setString(1, user.getPassword());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getUserId());
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();;
		}
	}

	/*
	 * 사용자아이디에해당하는 사용자를 삭제
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#remove(java.lang.String)
	 */
	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplJDBC2 : remove() 호출  ");
		Connection con = null;
		PreparedStatement pstmt = null;
		String removeQuery = "delete from userinfo where userid=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(removeQuery);
			pstmt.setString(1, userId);
			int rows = pstmt.executeUpdate();
			return rows;
		} finally {
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
	}
	
	/*
	 * 사용자아이디에해당하는 정보를 데이타베이스에서 찾아서
	 * User 도메인클래스에 저장하여 반환
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplJDBC2 : findUser() 호출  ");
		User user = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select userid,password,name,email from userinfo where userid=?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getString("userid"),
						rs.getString("password"), rs.getString("name"),
						rs.getString("email"));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return user;
	}
	/*
	 * 모든사용자 정보를 데이타베이스에서 찾아서 
	 * List<User> 콜렉션 에 저장하여 반환
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#findUserList()
	 */
	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplJDBC2 : findUserList 호출  ");
		ArrayList<User> userList= new ArrayList<User>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select userid,password,name,email from userinfo";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(selectQuery);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				userList.add(new User(
						rs.getString("userid"),
						rs.getString("password"),
						rs.getString("name"),
						rs.getString("email")));
			}
		} finally {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (con != null)
				con.close();
		}
		return userList;
	}
	/*
	 * 인자로 전달되는 아이디를 가지는 사용자가 존재하는지의 여부를판별
	 */
	/* (non-Javadoc)
	 * @see com.itwill.user.UserDao#existedUser(java.lang.String)
	 */
	@Override
	public boolean existedUser(String userId)throws Exception{
		System.out.println("#### UserDaoImplJDBC2 : existedUser() 호출  ");
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String existedQuery="select count(*) cnt from userinfo" +
							" where userid=?";
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(existedQuery);
			pstmt.setString(1, userId);
			rs=pstmt.executeQuery();
			int count=0;
			if(rs.next()){
				count=rs.getInt("cnt");
			}
			if(count==1){
				return true;
			}else{
				return false;
			}
		}finally{
			if(rs!=null)
				rs.close();
			if(pstmt!=null)
				pstmt.close();
			if(con!=null)
				con.close();
		}
		
	}
	
}














