package com.itwill.user.annotation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.itwill.user.User;
import com.itwill.user.UserDao;
@Repository(value = "userDaoJdbcTemplate")
public class UserDaoImplJdbcTemplateAnnotation implements UserDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public UserDaoImplJdbcTemplateAnnotation(JdbcTemplate jdbcTemplate) {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation(" + jdbcTemplate + ") : 생성자호출  ");
		this.jdbcTemplate = jdbcTemplate;
	}

	public UserDaoImplJdbcTemplateAnnotation() {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation() : 디폴트생성자 호출  ");
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation : setJdbcTemplate(" + jdbcTemplate + ") 호출  ");
		this.jdbcTemplate = jdbcTemplate;
	}

	

	@Override
	public User findUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation : findUser() 호출  ");
		return jdbcTemplate.queryForObject("select userId,password,name,email from userinfo where userId=?",
				new Object[] { userId },
				new RowMapper<User>() {
					public User mapRow(ResultSet rs, int rowNum) throws SQLException {
						User user = 
								new User(rs.getString("userId"),
										rs.getString("password"), 
										rs.getString("name"),
										rs.getString("email"));
						return user;
					}
				});
	}

	@Override
	public List<User> findUserList() throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation : findUserList 호출  ");
		return jdbcTemplate.query(
				"select * from userinfo",
				new BeanPropertyRowMapper<User>(User.class));
	}
	@Override
	public boolean existedUser(String userId) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation : existedUser() 호출  ");
		return true;
	}

	@Override
	public int create(User user) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation : create() 호출  ");
		return 0;
	}

	@Override
	public int update(User user) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation : update() 호출  ");
		return 0;
	}

	@Override
	public int remove(String userId) throws Exception {
		System.out.println("#### UserDaoImplJdbcTemplateAnnotation : remove() 호출  ");
		return 0;
	}
}
