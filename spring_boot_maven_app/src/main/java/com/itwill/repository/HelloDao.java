package com.itwill.repository;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.itwill.domain.Hello;

@Repository
public class HelloDao {
	@Autowired
	private DataSource dataSource;

	public List<Hello> helloDao() throws Exception {
		List<Hello> helloList=new ArrayList<Hello>();
		Connection con = dataSource.getConnection();
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from guest");
		while (rs.next()) {
			helloList.add(new Hello(rs.getInt("guest_no"), rs.getString("guest_name")));
		}
		return helloList;
	}
}
