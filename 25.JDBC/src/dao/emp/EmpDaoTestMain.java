package dao.emp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmpDaoTestMain {

	public static void main(String[] args)throws Exception {
		EmpDao empDao=new EmpDaoImpl();
		ArrayList<HashMap> empList=empDao.findEmpsWithDept();
		System.out.println("--------empdept list--------");
		for (Map rowMap : empList) {
			int empno=(Integer)rowMap.get("empno");
			String ename=(String)rowMap.get("ename");
			String job=(String)rowMap.get("job");
			double sal=(Double)rowMap.get("sal");
			String dname=(String)rowMap.get("dname");
			String loc=(String)rowMap.get("loc");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+dname+"\t"+loc);
		}
		System.out.println("--------empdept one--------");
		HashMap rowMap = empDao.findEmpnoWithDept(7499);
		int empno=(Integer)rowMap.get("empno");
		String ename=(String)rowMap.get("ename");
		String job=(String)rowMap.get("job");
		double sal=(Double)rowMap.get("sal");
		String dname=(String)rowMap.get("dname");
		String loc=(String)rowMap.get("loc");
		System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal+"\t"+dname+"\t"+loc);
		
		
	}

}
