package com.itwill3.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.itwill.user.User;

public class UserRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User(	rs.getString("userId"),
							rs.getString("password"),
							rs.getString("name"),
							rs.getString("email"));
		return user;
	}

}
