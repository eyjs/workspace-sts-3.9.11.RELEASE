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
		 * 	   A. Driver��ü����
		 *     B. DriverManager����ü���
		 */
		Class.forName(driverClass);
		System.out.println("1.driver class loading");
		/*
		 * 2. Connection����(Socket)
		 */
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("2.Connection����:"+con);
		/*
		 * 3.Statement����(Stream)
		 */
		Statement stmt = con.createStatement();
		System.out.println("3.Statement����:"+stmt);
		/*
		 * 4-1. SQL������(select)
		 * 4-2. ResultSet(�������)���
		 */
		ResultSet rs=stmt.executeQuery(selectSql);
		System.out.println("4.ResultSet��ü���:"+rs);
		/*
		�̸�       ��?       ����           
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
		 * 5.��������
		 */
		System.out.println("5.��������");
		rs.close();
		stmt.close();
		con.close();
		
		
		
	}

}








