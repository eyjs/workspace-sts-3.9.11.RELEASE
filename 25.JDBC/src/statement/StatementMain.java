package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StatementMain {

	public static void main(String[] args) throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		String selectSql = "select * from emp order by sal desc";
		String updateSql ="update emp set sal=6789.78 where empno >= 7369 and empno <= 7600";
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		Statement stmt=con.createStatement();
		/*
		 * ResultSet행의수를제한
		 */
		stmt.setMaxRows(14);
		/*
		ResultSet executeQuery(String sql) throws SQLException
			- Executes the given SQL statement, 
			  which returns a single ResultSet object.
			Parameters:
				sql - an SQL statement to be sent to the database,
				      typically a static SQL SELECT statement
			Returns:
				a ResultSet object that contains the data produced by the given query; 
				never null
		 */
		/*
		
		이름       널?       유형           
		-------- -------- ------------ 
		EMPNO    NOT NULL NUMBER(4)    
		ENAME             VARCHAR2(10) 
		JOB               VARCHAR2(9)  
		MGR               NUMBER(4)    
		HIREDATE          DATE         
		SAL               NUMBER(7,2)  
		COMM              NUMBER(7,2)  
		DEPTNO            NUMBER(2)  
	
		 */
		ResultSet rs = stmt.executeQuery(selectSql);
		while(rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String job=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
		}
		rs.close();
		/*
		int executeUpdate(String sql) throws SQLException
			- Executes the given SQL statement, 
			   which may be an INSERT, UPDATE, or DELETE statement 
			   or an SQL statement that returns nothing,
			   such as an SQL DDL statement.
		Parameters:
			sql - an SQL Data Manipulation Language (DML) statement, 
			 such as INSERT, UPDATE or DELETE; 
			 or an SQL statement that returns nothing,
			 such as a DDL statement.
		Returns:
			either (1) the row count for SQL Data Manipulation Language (DML) statements or 
			       (2) 0 for SQL statements that return nothing
		 */
		
		int updateRowcounts = stmt.executeUpdate(updateSql);
		System.out.println(">>영향받은 행의수:"+updateRowcounts);
		
		String anySql = selectSql;
		//anySql = updateSql;
		
		boolean isResultSet = stmt.execute(anySql);
		if(isResultSet) {
			System.out.println("---"+anySql+"-----");
			ResultSet rs1 = stmt.getResultSet();
			while(rs1.next()) {
				int empno = rs1.getInt("empno");
				String ename=rs1.getString("ename");
				String job=rs1.getString("job");
				double sal=rs1.getDouble("sal");
				System.out.println(empno+"\t"+ename+"\t"+job+"\t"+sal);
			}
			
		}else {
			System.out.println("---"+anySql+"-----");
			int rowCounts = stmt.getUpdateCount();
			System.out.println("updateCount:"+rowCounts);
		}
		
		
		

	}

}






