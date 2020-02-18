package resultset;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.itwill.dao.common.ConnectionFactory;

public class ResultSetMetaDataMain {

	public static void main(String[] args) throws Exception {
		String selectSql1="select * from emp";
		String selectSql2="select * from dept";
		
		Connection con=ConnectionFactory.getConnection();
		PreparedStatement pstmt=con.prepareStatement(selectSql2);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		int columnCount = rsmd.getColumnCount();
		System.out.println("1.컬럼수:"+columnCount);
		String headerStr="";
		for (int i = 1; i <= columnCount; i++) {
			headerStr+=rsmd.getColumnName(i)+"\t";
		}
		System.out.println("-------------------------------");
		System.out.println(headerStr);
		System.out.println("-------------------------------");
		
		
		for (int i = 1; i <= columnCount; i++) {
			System.out.println("---------"+i+" 번째컬럼--------");
			String columnName=rsmd.getColumnName(i);
			String columnTypeName=rsmd.getColumnTypeName(i);
			String columnClassName=rsmd.getColumnClassName(i);
			int isNullable = rsmd.isNullable(i);
			/*
			 * 0: not null
			 * 1: null
			 */
			String nullStr="";
			if(isNullable==ResultSetMetaData.columnNoNulls) {
				nullStr="NOT NULL";
			}else {
				nullStr="NULL";
			}
			int columDisplaySize = rsmd.getColumnDisplaySize(i);
			System.out.println("column name:"+columnName);
			System.out.println("column type name:"+columnTypeName);
			System.out.println("column class name:"+columnClassName);
			System.out.println("column NULL 허용여부:"+nullStr);
			System.out.println("column display size:"+columDisplaySize);
		}

	}

}




