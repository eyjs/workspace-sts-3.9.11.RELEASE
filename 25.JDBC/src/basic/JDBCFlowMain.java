package basic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception{
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		String selectSql="select * from emp";
		/*
		 * 1. oracle.jdbc.OracleDriver class loading
		 * 	   A. Driver객체생성
		 *     B. DriverManager에객체등록
		 */
		Class.forName(driverClass);
		System.out.println("1.driver class loading");
		/*
		 * 2. Connection생성(Socket)
		 */
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("2.Connection생성:"+con);
		/*
		 * 3.Statement생성(Stream)
		 */
		Statement stmt = con.createStatement();
		System.out.println("3.Statement생성:"+stmt);
		/*
		 * 4-1. SQL문전송(select)
		 * 4-2. ResultSet(결과집합)얻기
		 */
		ResultSet rs=stmt.executeQuery(selectSql);
		System.out.println("4.ResultSet객체얻기:"+rs);
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
		System.out.println("-------------------------");
		System.out.println("empno \t ename \t job \t sal");
		System.out.println("-------------------------");
		while(rs.next()) {
			String no = rs.getString("empno");
			String name = rs.getString("ename");
			String job = rs.getString("job");
			String sal = rs.getString("sal");
			System.out.println(no+"\t"+name+"\t"+job+"\t"+sal);
		}
		System.out.println("-------------------------");
		/*
		 * 5.연결해지
		 */
		System.out.println("5.연결해지");
		rs.close();
		stmt.close();
		con.close();
		
		
		
	}

}








