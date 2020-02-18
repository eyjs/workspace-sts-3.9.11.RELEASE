package statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
<<PreparedStatement>>
1. sql���ۼ�
    - ?(�Ķ��Ÿ) �� ����ؼ� ���߿� �ܺο��� ����Ÿ(���ͷ�)�� �������ְ��Ѵ�.
      ex> insert into emp(empno,ename,job,manager,hiredate,sal,comm,deptno) values(?,?,?,?,?,?,?,?)	
    - ���̺��̸�,�÷��̸����� ? �� ����ؼ� �ܺο��� �Է¹���������.
      ex> select * from ? 
          select ?,? from emp    
2. PreparedStatement ��ü������ ���ڷ� sql���� �־�����Ѵ�
   ex> PreparedStatement pstmt = con.prepareStatement(sql);
3. ������ PreparedStatement ��ü�� �Ķ��Ÿ�� setting �Ѵ�
    - sql ���� ? ���� 1,2,3...
   ex> 	pstmt.setInt(1,1234);              
 	   	pstmt.setString(2,"KIM");              
   		pstmt.setString(3,"MANAGER");              
  		pstmt.setInt(4,7839);              
   		pstmt.setDate(5,new Date());              
   		pstmt.setDouble(6,1000.12);              
   		pstmt.setInt(7,0);              
   		pstmt.setInt(8,10);              
 4.  ����
    - ����� sql���� ���ڷ� �����ȴ´�.
    ex> pstmt.executeUpdate();         
        pstmt.executeQuery();         
*/
public class PreparedStatementMain {

	public static void main(String[] args) throws Exception{
		//String driverClass="oracle.jdbc.OracleDriver";
		String driverClass="net.sf.log4jdbc.sql.jdbcapi.DriverSpy";
		//String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String url="jdbc:log4jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javaspring31";
		String password="javaspring31";
		
		int startSal = 1000;
		int endSal = 9000;
		String job="CLERK";
		
		String selectSql1="select empno,ename,job,sal,deptno from emp "
				+ "where sal >= "+startSal+" and sal<="+endSal+" and job='"+job+"'";
		
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url,user,password);
		System.out.println("---------------SELECT(Statement)-----------------");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery(selectSql1);
		while (rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String jobs=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
		}
		rs.close();
		stmt.close();
		System.out.println("---------------SELECT(PreparedStatement)-----------------");
		String selectSql2="select empno,ename,job,sal,deptno from emp "
				+ "where sal >= ? and sal<= ? and job= ?";
		PreparedStatement pstmt =con.prepareStatement(selectSql2);
		System.out.println(pstmt);
//		pstmt.getOriginalSql();
		System.out.println("-----PreparedStatement�ݺ�1------");
		pstmt.setInt(1, startSal);
		pstmt.setInt(2, endSal);
		pstmt.setString(3, job);
		rs = pstmt.executeQuery();
		while (rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String jobs=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
		}
		System.out.println("-----PreparedStatement�ݺ�2------");
		startSal=1000;
		endSal=5000;
		job="SALESMAN";
		//pstmt.clearParameters();
		
		pstmt.setInt(1, startSal);
		pstmt.setInt(2, endSal);
		pstmt.setString(3, job);
		
		rs = pstmt.executeQuery();
	
		while (rs.next()) {
			int empno = rs.getInt("empno");
			String ename=rs.getString("ename");
			String jobs=rs.getString("job");
			double sal=rs.getDouble("sal");
			System.out.println(empno+"\t"+ename+"\t"+jobs+"\t"+sal);
		}
		rs.close();
		pstmt.close();
		System.out.println("------------------insert(PreparedStatement)-----------)");
		/*
		String insertSql0=
				"insert into emp values(9000,'ALICE','CLERK',7499,sysdate,5600,0,10)";
		*/
		String insertSql1=
				"insert into emp values(?,?,?,?,?,?,?,?)";
		//insert into emp values(?,?,?,?,to_date('2020/01/08','YYYY/MM/DD'),?,?,?)
		String insertSql2=
				"insert into emp values(?,?,?,?,to_date(?,?),?,?,?)";
		/*
		pstmt = con.prepareStatement(insertSql1);
		
		pstmt.setInt(1, 1115);
		pstmt.setString(2, "TOM");
		pstmt.setString(3, "CLERK");
		pstmt.setInt(4, 7499);
		pstmt.setDate(5, new Date(System.currentTimeMillis()));
		pstmt.setDouble(6, 8888.45);
		pstmt.setDouble(7, Types.NULL);
		pstmt.setInt(8, 10);
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(">> insert row count:"+insertRowCount);
		
		pstmt.setInt(1, 1117);
		pstmt.setString(2, "TOM2");
		pstmt.setString(3, "SALESMAN");
		pstmt.setInt(4, 7499);
		pstmt.setDate(5, new Date(System.currentTimeMillis()));
		pstmt.setDouble(6, 4545.45);
		pstmt.setDouble(7, 0);
		pstmt.setInt(8, 20);
		insertRowCount = pstmt.executeUpdate();
		System.out.println(">> insert row count:"+insertRowCount);
		*/
		/*
		pstmt = con.prepareStatement(insertSql2);
		pstmt.setInt(1,4545);
		pstmt.setString(2, "ȫ�浿");
		pstmt.setString(3, "MANAGER");
		pstmt.setInt(4, Types.NULL);
		pstmt.setString(5, "2020/01/05");
		pstmt.setString(6, "YYYY/MM/DD");
		pstmt.setDouble(7, 6767.45);
		pstmt.setNull(8, Types.NUMERIC);
		pstmt.setInt(9, 10);
		
		int insertRowCount = pstmt.executeUpdate();
		System.out.println(">> insert row count:"+insertRowCount);
		*/
		
	}
	public static void printSqlStatement(PreparedStatement preparedStatement, String sql) throws SQLException{
        String[] sqlArrya= new String[preparedStatement.getParameterMetaData().getParameterCount()];
        try {
               Pattern pattern = Pattern.compile("\\?");
               Matcher matcher = pattern.matcher(sql);
               StringBuffer sb = new StringBuffer();
               int indx = 1;  // Parameter begin with index 1
               while (matcher.find()) {
            	   matcher.appendReplacement(sb,String.valueOf(sqlArrya[indx]));
               }
               matcher.appendTail(sb);
              System.out.println("Executing Query [" + sb.toString() + "] with Database[" + "] ...");
               } catch (Exception ex) {
                   System.out.println("Executing Query [" + sql + "] with Database[" +  "] ...");
            }

    }
}












