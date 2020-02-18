package dao.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itwill.dao.common.ConnectionFactory;

public class EmpDaoImpl implements EmpDao {

	@Override
	public int insert(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Emp emp) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int empno) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Emp findByEmpno(int empno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<Emp> findByDeptno(int deptno) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	// 사원정보(부서정보포함) 한개 반환
	@Override
	public HashMap findEmpnoWithDept(int no) throws Exception {
		HashMap rowMap=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		
		con=ConnectionFactory.getConnection();
		pstmt=con.prepareStatement(EmpSQL.SELECT_EMPNO_WITHDEPT);
		pstmt.setInt(1,no);
		rs=pstmt.executeQuery();
		if(rs.next()) {
			rowMap=new HashMap();
			rowMap.put("empno", rs.getInt("empno"));
			rowMap.put("ename", rs.getString("ename"));
			rowMap.put("job", rs.getString("job"));
			rowMap.put("sal", rs.getDouble("sal"));
			rowMap.put("deptno", rs.getInt("deptno"));
	
			rowMap.put("dname", rs.getString("dname"));
			rowMap.put("loc", rs.getString("loc"));
		}
		
		return rowMap;
	}
	//사원정보(부서정보포함) 전체목록 반환
	@Override
	public ArrayList<HashMap> findEmpsWithDept() throws Exception {
		ArrayList<HashMap> empList = new ArrayList<HashMap>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		con = ConnectionFactory.getConnection();
		pstmt = con.prepareStatement(EmpSQL.SELECT_ALLEMP_WITHDEPT);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			HashMap rowMap = new HashMap();
			rowMap.put("empno", rs.getInt("empno"));
			rowMap.put("ename", rs.getString("ename"));
			rowMap.put("job", rs.getString("job"));
			rowMap.put("sal", rs.getDouble("sal"));
			rowMap.put("deptno", rs.getInt("deptno"));
	
			rowMap.put("dname", rs.getString("dname"));
			rowMap.put("loc", rs.getString("loc"));
			empList.add(rowMap);
		}
		
		return empList;
	}

	

}
