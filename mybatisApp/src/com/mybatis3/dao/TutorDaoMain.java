package com.mybatis3.dao;

import java.util.List;

import com.mybatis3.domain.Address;
import com.mybatis3.domain.Course;
import com.mybatis3.domain.Tutor;

public class TutorDaoMain {

	public static void main(String[] args) {
		TutorDao tutorDao=new TutorDao();
		System.out.println("----------findTutorById--------");
		System.out.println("### "+tutorDao.findTutorById(1));
		System.out.println("----------selectTutorWithCourses--------");
		System.out.println("### "+tutorDao.findTutorWithCoursesById(1));
		
		Tutor tutor1 = tutorDao.findTutorWithCoursesById(1);
		List<Course> courseList1 = tutor1.getCourses();
		System.out.println("Tutor1:"+tutor1);
		for (Course course : courseList1) {
			System.out.println("\t"+tutor1.getName() +"강사코스 -->"+
					course.toString());
			
		}
		System.out.println("----------findTutorWithCoursesAndAddressById--------");
		Tutor tutor2 = tutorDao.findTutorWithCoursesAndAddressById(2);
		Address address2=tutor2.getAddress();
		List<Course> courseList2 = tutor2.getCourses();
		
		System.out.println("Tutor2:"+tutor2);
		System.out.println("\t"+tutor2.getName()+"강사 주소-->"+address2);
		for (Course course : courseList2) {
			System.out.println("\t"+tutor2.getName() +"강사 코스 -->"+
					course.toString());
			
		}
		//System.out.println("-------------nestedSelectTutorById----------------");

	}

}
