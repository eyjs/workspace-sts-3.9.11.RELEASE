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
import com.mybatis3.mapper.StudentMapper;

public class MapperInterfaceStudentDao {
	private SqlSessionFactory sqlSessionFactory;

	public MapperInterfaceStudentDao() {
		InputStream mybatisConfigInputStream = null;
		try {
			mybatisConfigInputStream = Resources.getResourceAsStream("mybatis-config-mapper-interface.xml");
			this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	public Student findStudentById111111(Integer studId) {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		Student student = 
				sqlSession.
				selectOne(
						"com.mybatis3.mapper.StudentMapper.findStudentById",
						studId);
		sqlSession.close();
		return student;
	}
	*/
	public Student findStudentById(Integer studId) {

		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		System.out.println("studentMapper:" + studentMapper);
		Student student = studentMapper.findStudentById(studId);
		/*
		StudentMapper studentMapper=new MapperProxy();
		Student student=studentMapper.findStudentById(studId);
		*/
		return student;
	}
	/*
	public List<Student> findAllStudents1111111() {
			SqlSession sqlSession=sqlSessionFactory.openSession(true);
			List<Student> studentList=
					sqlSession.selectList(
							"com.mybatis3.mapper.StudentMapper.findAllStudents");
			sqlSession.close();
		return studentList;
	}
	*/
	public List<Student> findAllStudents() {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
		
		List<Student> studentList = studentMapper.findAllStudents();
		return studentList;
	}

	
	
}
