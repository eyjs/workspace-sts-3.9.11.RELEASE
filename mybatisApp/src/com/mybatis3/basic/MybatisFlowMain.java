package com.mybatis3.basic;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class MybatisFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		 * 0.mybatic-config.xml -->InputStream
		 */
		InputStream mybatisConfigInputStream
			=Resources.getResourceAsStream("mybatis-config.xml");
		/*
		 * 1.SqlSessionFactoryBuilder
		 */
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		/*
		 * 2.SqlSessionFactory
		 */
		SqlSessionFactory ssf = ssfb.build(mybatisConfigInputStream);
		/*
		 * 3.SqlSession 
		 */
		SqlSession sqlSession = ssf.openSession();
		/*
		 * 4.SqlSession사용(CRUD) 
		 */
		System.out.println("SqlSession:"+sqlSession);
		Student student=sqlSession.selectOne(
				"com.mybatis3.mapper.StudentMapper.findStudentById",
				new Integer(4));
		System.out.println("#### "+student);
		sqlSession.commit();
		sqlSession.close();
	}
}











