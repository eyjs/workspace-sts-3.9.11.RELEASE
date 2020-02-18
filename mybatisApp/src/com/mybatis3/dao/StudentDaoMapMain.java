package com.mybatis3.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class StudentDaoMapMain {

	public static void main(String[] args) {
		StudentDao studentDao = new StudentDao();
		System.out.println("-------findStudentByIdMap-------");
		System.out.println("###"+studentDao.findStudentByIdMap(3));
		HashMap studentMap = studentDao.findStudentByIdMap(1);
		BigDecimal studIdBigDecimal=
				(BigDecimal)studentMap.get("STUDID");
		int studId = studIdBigDecimal.intValue();
		String name=(String)studentMap.get("NAME");
		String email=(String)studentMap.get("EMAIL");
		Date dob=(Date)studentMap.get("DOB");
		System.out.println("-->"+studId+","+name+","+email+","+dob);
		
		System.out.println("-------findAllStudentsMap-------------");
		List<HashMap> studentMapList=studentDao.findAllStudentsMap();
		for (HashMap studentMap2 : studentMapList) {
			BigDecimal studIdBigDecimal2=
					(BigDecimal)studentMap2.get("STUDID");
			int studId2 = studIdBigDecimal2.intValue();
			String name2=(String)studentMap2.get("NAME");
			String email2=(String)studentMap2.get("EMAIL");
			Date dob2=(Date)studentMap2.get("DOB");
			System.out.println("-->"+studId2+","+name2+","+email2+","+dob2);
		}
		
		
	}
}
