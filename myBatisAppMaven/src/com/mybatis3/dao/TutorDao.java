package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Tutor;

public class TutorDao 
{
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.mapper.TutorMapper.";
	public TutorDao() {
		InputStream mybatisConfigInputStream=null;
		try {
			mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory =
					new SqlSessionFactoryBuilder()
					.build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 JOIN(Tutor + Courses + Address)
	 */
	public Tutor findTutorWithCoursesAndAddressById(Integer tutorId) {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		Tutor tutor=sqlSession.selectOne(
				NAMESPACE+"findTutorWithCoursesAndAddressById", tutorId);
		sqlSession.close();
		return tutor;
	}
	/*
	 JOIN(Tutot + Courses )
	 */
	public Tutor findTutorWithCoursesById(Integer tutorId) {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		Tutor tutor=sqlSession.selectOne(
				NAMESPACE+"findTutorWithCoursesById", tutorId);
		sqlSession.close();
		return tutor;
	}
	/*
	Tutor
	*/
	public Tutor findTutorById(Integer tutorId) {
		SqlSession sqlSession=
				sqlSessionFactory.openSession(true);
		Tutor tutor=sqlSession.selectOne(
				NAMESPACE+"findTutorById", tutorId);
		sqlSession.close();
		return tutor;
	}
	
}













