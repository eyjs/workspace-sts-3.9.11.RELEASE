package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.mapper.StudentMapper.";
	public StudentDao() {
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
	
	public Student findStudentById(Integer studId) {
		/*
		 * true  : autocommit true
		 * 	   		sqlSession.close();		
		 * false : autocommit false
		 *     		sqlSession.commit();
		 *     		sqlSession.close();
		 */
		
		SqlSession sqlSession=null;
		Student findStudent=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			findStudent=
					sqlSession.selectOne(NAMESPACE+"findStudentById", studId);
		}finally {
			sqlSession.close();
		}
		return findStudent;
	}
	public List<Student> findAllStudents() {
		
		SqlSession sqlSession=null;
		List<Student> studentList=new ArrayList<Student>();
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			studentList=
					sqlSession.selectList(NAMESPACE+"findAllStudents");
		}finally {
			sqlSession.close();
		}
		return studentList;
	}
	
	
}












