package dao.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmpDao {
	
	public int insert(Emp emp) throws Exception;
	
	public int update(Emp emp) throws Exception;
	
	public int delete(int empno) throws Exception;
	
	public Emp findByEmpno(int empno) throws Exception;
	
	public List<Emp> findByDeptno(int deptno) throws Exception;
	
	// 사원정보(부서정보포함) 한개 반환
	public HashMap findEmpnoWithDept(int no) throws Exception;
	
	// 사원정보(부서정보포함) 전체목록 반환
	public ArrayList<HashMap> findEmpsWithDept() throws Exception;
	
}







