package resultset;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itwill.dao.common.ConnectionFactory;

public class ResultSetScrollableUpdatableMain {

	public static void main(String[] args)throws Exception {
		String selectSql="select empno,ename,job,mgr,hiredate,sal,comm,deptno "
						+ "from emp order by empno asc";
		/*
		ResultSet.TYPE_FORWARD_ONLY 
		ResultSet.CONCUR_READ_ONLY
		*/
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt = 
				con.prepareStatement(
						selectSql,
						ResultSet.TYPE_SCROLL_SENSITIVE ,
						ResultSet.CONCUR_UPDATABLE);
		ResultSet rs=pstmt.executeQuery();
		/*
		 * Cursor를 자유롭게움직일수있는 ResultSet생성
		 */
		System.out.println("---------rs.next()-------------");
		while (rs.next()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		}
		System.out.println("---------rs.previous()---------");
		while (rs.previous()) {
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		}
		System.out.println("---------rs.first()---------");
		rs.first();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("---------rs.first()---------");
		rs.last();
		int rowNum = rs.getRow();
		System.out.println("데이타갯수:" + rowNum);
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("---------rs.absolute(5)---------");
		rs.absolute(5);
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("---------rs.relative(1)--------");
		rs.relative(1);
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("---------rs.relative(-1)--------");
		rs.relative(-1);
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("---------rs.beforeFirst()--------");
		rs.beforeFirst();
		rs.next();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("---------rs.afterLast()--------");
		rs.afterLast();
		if(rs.isAfterLast()) {
			rs.previous();
			System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		}
		/*
		 *  수정가능한 ResultSet 생성
		 *    - ResultSet 을통한 INSERT,DELETE,UPDATE
		 */
		System.out.println("-----------ResultSet-->update------------");
		rs.first();
		rs.updateString(2, "홍길순");
		rs.updateDate(5, new Date(System.currentTimeMillis()));
		rs.updateDouble(6, 8989.90);
		rs.updateRow();
		System.out.println(rs.getInt("empno")+"\t"+rs.getString("ename"));
		System.out.println("-----------ResultSet-->delete------------");
		rs.last();
		//rs.deleteRow();
		System.out.println("-----------ResultSet-->insert------------");
		rs.moveToInsertRow();
		rs.updateInt(1, 7777);
		rs.updateString(2, "김수로");
		rs.updateString(3, "CLERK");
		rs.updateDate(5, new Date(2020-1900,1,9));
		rs.updateDouble(6,4500.8888888);
		rs.insertRow();
		
		System.out.println("----------------------------------------");
		rs.last();
		System.out.println("전체행수:"+rs.getRow());
		rs.close();
	}

}










