package com.mybatis3.dao;

import java.util.Date;

import com.mybatis3.domain.Student;

public class StudentDaoWithAddressMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentByIdWithAddress----------");
		System.out.println("### "+studentDao.findStudentsByIdWithAddressResultMap(1));
		System.out.println("### "+studentDao.findStudentsByIdWithAddressResultMap(7));
		System.out.println("-------findStudentsByIdWithAddressNestedSelectResultMap----------");
		System.out.println("### "+studentDao.findStudentsByIdWithAddressNestedSelectResultMap(3));
		/*
		System.out.println("-------insertStudentParameterMap(parameter Map)----");
		System.out.println("-------updateStudentDynamicSql---------");
		System.out.println("-------findStudentCount----------------");
		*/
	}
}
