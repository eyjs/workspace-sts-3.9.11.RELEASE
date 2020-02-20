package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentById-------");
		System.out.println("###"+studentDao.findStudentById(1));
		System.out.println("-------findAllStudents---------");
		System.out.println("###"+studentDao.findAllStudents());
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("###"+studentDao.findStudentByIdMap(3));
		System.out.println("-------findAllStudentsMap-------------");
		System.out.println("###"+studentDao.findAllStudentsMap());
		System.out.println("-------findStudentByIdResultMap-------");
		System.out.println("###"+studentDao.findStudentByIdResultMap(7));
		System.out.println("-------findAllStudentsResultMap---------");
		System.out.println("###"+studentDao.findAllStudentsResultMap());
		System.out.println("-------insertStudent(Dto)--------------");
		//Student insertStudent=new Student(8000, "김팔천", "8000@gmail.com", new Date());
		//System.out.println("###"+studentDao.insertStudent(insertStudent));
		System.out.println("-------insertStudentBySequence1---------");
		Student insertStudent2=new Student(0, "김영구", "0000@gmail.com", new Date(2020-1900,1,18));
		System.out.println("### "+studentDao.insertStudentBySequence1(insertStudent2));
		System.out.println("insert PK:"+insertStudent2);
		System.out.println("-------insertStudentBySequence2---------");
		Student insertStudent3=new Student(0, "김삼구", "3333@gmail.com", new Date());
		System.out.println("### "+studentDao.insertStudentBySequence2(insertStudent3));
		System.out.println("insert PK:"+insertStudent3);
		System.out.println("-------updateStudent-------------------");
		insertStudent3.setName("삼구변경");
		insertStudent3.setEmail("change@korea.com");
		insertStudent3.setDob(new Date());
		System.out.println("### "+studentDao.updateStudent(insertStudent3));
		System.out.println("-------delete Student------------------");
		System.out.println("### "+studentDao.deleteStudentById(insertStudent3.getStudId()));
		System.out.println("### "+studentDao.deleteStudentByName("김삼구"));
		
		/*
		System.out.println("-------findStudentByIdWithAddress----------");
		System.out.println("-------findStudentByIdNestedfindAddressById-----------");
	
		System.out.println("-------insertStudentParameterMap(parameter Map)----");
		
		System.out.println("-------updateStudentDynamicSql---------");
		
		System.out.println("-------findStudentCount----------------");
		*/
	}
}
