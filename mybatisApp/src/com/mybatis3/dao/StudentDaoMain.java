package com.mybatis3.dao;

public class StudentDaoMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentById-------");
		System.out.println("###"+studentDao.findStudentById(1));
		System.out.println("-------findAllStudents---------");
		System.out.println("###"+studentDao.findAllStudents());
		/*
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("-------findStudentByIdResultMap-------");
		System.out.println("-------findAllStudentsMap-------------");
		System.out.println("-------findAllStudentsResultMap---------");
		System.out.println("-------findStudentByIdWithAddress----------");
		System.out.println("-------findStudentByIdNestedfindAddressById-----------");
		System.out.println("-------insertStudent(Dto)--------------");
		System.out.println("-------insertStudentBySequence---------");
		System.out.println("-------insertStudentParameterMap(parameter Map)----");
		System.out.println("-------updateStudent-------------------");
		System.out.println("-------updateStudentDynamicSql---------");
		System.out.println("-------delete Student------------------");
		System.out.println("-------findStudentCount----------------");
		*/
	}
}
