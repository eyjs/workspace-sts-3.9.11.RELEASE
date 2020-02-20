package com.mybatis3.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis3.domain.Student;
import com.mybatis3.mapper.StudentMapper;

public class MapperProxy implements StudentMapper{
	private SqlSession sqlSession;
	@Override
	public Student findStudentById(Integer studId) {
		String nameSpace = StudentMapper.class.getName();
		Student student = sqlSession.selectOne(nameSpace+".findStudentById",studId);
		return student;
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

}
