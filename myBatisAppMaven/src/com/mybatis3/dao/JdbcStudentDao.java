package com.mybatis3.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.mybatis3.domain.Student;

/**
 * This class is to demonstrate how much boilerplate code we need to write if we use plain JDBC.
 * @author Siva
 */

public class JdbcStudentDao
{
	
	private static final String DRIVER = "oracle.jdbc.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@210.16.214.203:1521:xe";
	private static final String USERNAME = "user0";
	private static final String PASSWORD = "user0";

	
	
	public Student findStudentById(int studId)
	{
		Student student = null;
		Connection conn = null;
		try
		{
			conn = getDatabaseConnection();
			String sql = "select * from students where stud_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, studId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				student = new Student();
				student.setStudId(rs.getInt("stud_id"));
				student.setName(rs.getString("name"));
				student.setEmail(rs.getString("email"));
				student.setDob(rs.getDate("dob"));
			}
			
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if(conn!= null){
				try {
					conn.close();
				} catch (SQLException e){ }
			}
		}
		return student;
	}
	
	public void createStudent(Student student)
	{
		Connection conn = null;
		try
		{
			conn = getDatabaseConnection();
			String sql = "INSERT INTO STUDENTS(STUD_ID,NAME,EMAIL,DOB) VALUES(STUDENTS_STUD_ID_SEQ.nextval,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			//pstmt.setInt(1, student.getStudId());
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			if(conn!= null){
				try {
					conn.close();
				} catch (SQLException e){ }
			}
		}
	}
	
	public void updateStudent(Student student)
	{
		Connection conn = null;
		try
		{
			conn = getDatabaseConnection();
			conn = getDatabaseConnection();
			String sql = "UPDATE STUDENTS SET NAME=?,EMAIL=?,DOB=? WHERE STUD_ID=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getEmail());
			pstmt.setDate(3, new java.sql.Date(student.getDob().getTime()));
			pstmt.setInt(4, student.getStudId());
			pstmt.executeUpdate();
			
		} catch (SQLException e)
		{
			throw new RuntimeException(e.getCause());
		}
		finally
		{
			if(conn!= null){
				try {
					conn.close();
				} catch (SQLException e){ }
			}
		}
	}
	
	protected Connection getDatabaseConnection() throws SQLException
	{
		try
		{
			Class.forName(JdbcStudentDao.DRIVER);
			return DriverManager.getConnection(JdbcStudentDao.URL, 
												JdbcStudentDao.USERNAME, 
												JdbcStudentDao.PASSWORD);
		} catch (SQLException e)
		{
			throw e;
		} catch (Exception e)
		{
			throw new RuntimeException(e.getCause());
		} 
	}

}
