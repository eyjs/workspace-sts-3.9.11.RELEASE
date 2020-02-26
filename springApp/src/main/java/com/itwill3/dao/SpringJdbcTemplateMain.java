package com.itwill3.dao;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.itwill.user.User;

public class SpringJdbcTemplateMain {

	public static void main(String[] args) throws Exception {
		/*
		 * ApplicationContext[BeanFactory]객체생성 - Spring Container객체생성
		 */
		System.out.println("-------------Spring Container초기화시작--------");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"com/itwill3/dao/3-6.spring_jdbc_template.xml");
		System.out.println("-------------Spring Container초기화끝----------");
		JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean(JdbcTemplate.class);
		/*
		 * queryForObject [String,Wrapper,Bean]
		 */
		User user = jdbcTemplate.queryForObject("select userId,password,name,email from userinfo where userId=?",
				new Object[] { "x1" }, new BeanPropertyRowMapper<User>(User.class));
		System.out.println("### " + user);
		/*
		 * query [String,Wrapper,Bean List]
		 */
		/*
		 * List<User> userList=jdbcTemplate.query("select * from userinfo", new
		 * BeanPropertyRowMapper<User>(User.class));
		 */
		List<User> userList = jdbcTemplate.query("select * from userinfo", new UserRowMapper());
		System.out.println("### " + userList);

		/*
		 * queryForMap [Map]
		 */
		Map rowMap = jdbcTemplate.queryForMap("select userId,password,name,email from userinfo where userId=?", "x");
		System.out.println("### " + rowMap);
		/*
		 * queryForList [List<Map>]
		 */
		List rowMapList = jdbcTemplate.queryForList("select userId,password,name,email from userinfo");
		System.out.println("### " + rowMapList);

		/*
		 * update[insert delete update]
		 */
		try {
			int rowCount = jdbcTemplate.update("insert into userinfo values(?,?,?,?)", "id1", "pass", "email", "name");
			System.out.println("### " + rowCount);
		} catch (Exception e) {
			System.out.println("insert error:"+e.getMessage());
		}
	}
}
