package com.mybatis3.dao;

import java.util.List;

import com.mybatis3.domain.Student;

public class MapperInterfaceStudentDaoMain {

	public static void main(String[] args) {
		System.out.println("------------StudentMapper Interface를 사용한Dao메쏘드호출-----------");
		MapperInterfaceStudentDao mapperInterfaceStudentDao=
				new MapperInterfaceStudentDao();
		Student student=mapperInterfaceStudentDao.findStudentById(1);
		System.out.println("### "+student);
		System.out.println("------------StudentMapper Interface를 사용한호출-----------");
		List<Student> studentList=
				mapperInterfaceStudentDao.findAllStudents();
		System.out.println("### "+studentList);
	}

}
