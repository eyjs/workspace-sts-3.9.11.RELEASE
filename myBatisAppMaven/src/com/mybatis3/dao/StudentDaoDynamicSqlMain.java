package com.mybatis3.dao;

import java.util.Date;
import java.util.HashMap;

import com.mybatis3.domain.Student;

public class StudentDaoDynamicSqlMain {

	public static void main(String[] args) {
		StudentDaoDynamicSql studentDaoDynamicSql=
				new StudentDaoDynamicSql();
		System.out.println("----------------------findAllStudentsOrder-------------------");
		//System.out.println("### "+studentDaoDynamicSql.findAllStudentsOrder("studId"));
		//System.out.println("### "+studentDaoDynamicSql.findAllStudentsOrder("name"));
		System.out.println("----------------------findStudents-------------------");
		System.out.println("### "+studentDaoDynamicSql.findStudents(null));
		Student findStudent = new Student(1,"김영구","guard@naver.com",new Date());
		System.out.println("### "+studentDaoDynamicSql.findStudents(findStudent));
		findStudent.setStudId(null);
		System.out.println("### "+studentDaoDynamicSql.findStudents(findStudent));
		findStudent.setStudId(0);
		findStudent.setDob(null);
		System.out.println("### "+studentDaoDynamicSql.findStudents(findStudent));
		findStudent.setStudId(1);
		findStudent.setEmail(null);
		findStudent.setName(null);
		findStudent.setDob(null);
		System.out.println("----------------------findStudentsByNameLike-------------------");
		System.out.println("### "+studentDaoDynamicSql.findStudentsByNameLike("혜민"));
		System.out.println("----------------------updateStudentById-------------------");
		Student updateStudent=
				new Student(8000, "변경이름2", "change@korea.com", new Date());
		System.out.println("### "+studentDaoDynamicSql.updateStudentById(updateStudent));
		updateStudent.setStudId(3);
		System.out.println("### "+studentDaoDynamicSql.updateStudentById(updateStudent));
		updateStudent.setStudId(4);
		updateStudent.setName(null);
		updateStudent.setEmail("second2@gmail.com");
		updateStudent.setDob(null);
		System.out.println("### "+studentDaoDynamicSql.updateStudentById(updateStudent));
		System.out.println("----------------------findStudentsByIdRange-------------------");
		HashMap paramterMap=new HashMap();
		paramterMap.put("studId1", 10);
		paramterMap.put("studId2", 30);
		System.out.println("### "+studentDaoDynamicSql.findStudentsByIdRange(paramterMap));
	}

}














