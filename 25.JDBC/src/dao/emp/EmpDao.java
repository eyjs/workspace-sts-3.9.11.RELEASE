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
	
	// �������(�μ���������) �Ѱ� ��ȯ
	public HashMap findEmpnoWithDept(int no) throws Exception;
	
	// �������(�μ���������) ��ü��� ��ȯ
	public ArrayList<HashMap> findEmpsWithDept() throws Exception;
	
}







