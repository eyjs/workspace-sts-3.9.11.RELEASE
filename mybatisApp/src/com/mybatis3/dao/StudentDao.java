package com.mybatis3.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis3.domain.Student;

public class StudentDao {
	private SqlSessionFactory sqlSessionFactory;
	public static final String NAMESPACE=
			"com.mybatis3.mapper.StudentMapper.";
	public StudentDao() {
		InputStream mybatisConfigInputStream=null;
		try {
			mybatisConfigInputStream = 
					Resources.getResourceAsStream("mybatis-config.xml");
			this.sqlSessionFactory =
					new SqlSessionFactoryBuilder()
					.build(mybatisConfigInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	 @@@@@@@@@@@@@@@@@@@@@@@ update @@@@@@@@@@@@@@@@@@@ 
	 */
	public int updateStudent(Student student) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int updateRowCount=
				sqlSession.delete(NAMESPACE+"updateStudent", student);
		sqlSession.close();
		return updateRowCount;
	}
	
	/*
	 @@@@@@@@@@@@@@@@@@@@@@@delete@@@@@@@@@@@@@@@@@@@ 
	 */
	public int deleteStudentById(Integer studId) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=
				sqlSession.delete(NAMESPACE+"deleteStudentById", studId);
		sqlSession.close();
		return deleteRowCount;
	}
	public int deleteStudentByName(String name) {
		SqlSession sqlSession=sqlSessionFactory.openSession(true);
		int deleteRowCount=
				sqlSession.delete(NAMESPACE+"deleteStudentByName", name);
		sqlSession.close();
		return deleteRowCount;
	}
	
	
	/*
	 @@@@@@@@@@@@@@@@@@@@@@@insert@@@@@@@@@@@@@@@@@@@ 
	 */
	public int insertStudent(Student student) {
		//auto commit false
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int insertRowCount=
				sqlSession.insert(NAMESPACE+"insertStudent", student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	public int insertStudentBySequence1(Student student) {
		//auto commit false
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int insertRowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequence1", student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	public int insertStudentBySequence2(Student student) {
		//auto commit false
		SqlSession sqlSession=sqlSessionFactory.openSession(false);
		int insertRowCount=
				sqlSession.insert(NAMESPACE+"insertStudentBySequence2", student);
		sqlSession.commit();
		sqlSession.close();
		return insertRowCount;
	}
	
	
	/*
	 @@@@@@@@@@@@@@@@@@@@@@@select@@@@@@@@@@@@@@@@@@@ 
	 */
	/*
	resultType: Student(DTO)
	 */
	public Student findStudentById(Integer studId) {
		/*
		 * true  : autocommit true
		 * 	   		sqlSession.close();		
		 * false : autocommit false
		 *     		sqlSession.commit();
		 *     		sqlSession.close();
		 */
		
		SqlSession sqlSession=null;
		Student findStudent=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			findStudent=
					sqlSession.selectOne(NAMESPACE+"findStudentById", studId);
		}finally {
			sqlSession.close();
		}
		return findStudent;
	}
	/*
	resultType: List<Student>(List<DTO>)
	 */
	public List<Student> findAllStudents() {
		
		SqlSession sqlSession=null;
		List<Student> studentList=new ArrayList<Student>();
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			studentList=
					sqlSession.selectList(NAMESPACE+"findAllStudents");
		}finally {
			sqlSession.close();
		}
		return studentList;
	}
	/*
	 resultType: HashMap
	*/
	public HashMap findStudentByIdMap(Integer studId) {
		SqlSession sqlSession=null;
		HashMap findStudentMap=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			findStudentMap=
					sqlSession.selectOne(NAMESPACE+"findStudentByIdMap", studId);
		}finally {
			sqlSession.close();
		}
		return findStudentMap;
	}
	/*
	 resultType: List<HashMap>
	*/
	public List<HashMap> findAllStudentsMap() {
		
		SqlSession sqlSession=null;
		List<HashMap> studentMapList=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			studentMapList=
					sqlSession.selectList(NAMESPACE+"findAllStudentsMap");
		}finally {
			sqlSession.close();
		}
		return studentMapList;
	}
	
	/*
	resultMap: Student(DTO)
	 */
	public Student findStudentByIdResultMap(Integer studId) {
		SqlSession sqlSession=null;
		Student findStudent=null;
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			findStudent=
					sqlSession.selectOne(NAMESPACE+"findStudentByIdResultMap", studId);
		}finally {
			sqlSession.close();
		}
		return findStudent;
	}
	/*
	resultMap: List<Student>(List<DTO>)
	 */
	public List<Student> findAllStudentsResultMap() {
		SqlSession sqlSession=null;
		List<Student> studentList=new ArrayList<Student>();
		try {
			sqlSession=sqlSessionFactory.openSession(true);
			studentList=
					sqlSession.selectList(NAMESPACE+"findAllStudentsResultMap");
		}finally {
			sqlSession.close();
		}
		return studentList;
	}
}












