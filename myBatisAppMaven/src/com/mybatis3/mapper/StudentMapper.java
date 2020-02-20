package com.mybatis3.mapper;

import java.util.List;

import com.mybatis3.domain.Student;

public interface StudentMapper {
	/*
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치
	 */
	public Student findStudentById(Integer studId);
	/*
	<!-- resultType: Student(DTO),List<Student> -->
	<select id="findStudentById" 
			parameterType="java.lang.Integer" 
			resultType="com.mybatis3.domain.Student">
		select stud_id as studId ,name,email,dob
		from students
		where stud_id = #{studId}
	</select>
	 */
	public List<Student> findAllStudents();
	/*
	<select id="findAllStudents" 
			resultType="Student">
		select stud_id as studId ,name,email,dob
		from students
	</select>
	 */
}
